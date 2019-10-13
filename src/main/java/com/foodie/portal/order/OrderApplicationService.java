package com.foodie.portal.order;

import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.commons.event.OrderCreatedEvent;
import com.foodie.portal.order.command.CreateOrderCommand;
import com.foodie.portal.order.command.PayOrderCommand;
import com.foodie.portal.order.representation.OrderSummaryRepresentation;
import com.foodie.portal.payment.PaymentApplicationService;
import com.foodie.portal.payment.PaypalPaymentIntent;
import com.foodie.portal.payment.PaypalPaymentMethod;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.User;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Slf4j
@Service
public class OrderApplicationService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ActivityApplicationService activityApplicationService;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private PaymentApplicationService paymentApplicationService;

    @Transactional
    public Order create(CreateOrderCommand command, User user) {
        //创建订单
        Activity activity = activityApplicationService.findById(command.getActivityId());
        var order = Order.create(activity, command.getCount(), command.getOrderInfo());
        //更新预定人数
        activityApplicationService.updateReserve(command.getActivityId(), command.getServiceDate(), command.getStartTime(), command.getCount());

        order.setUser(user);
        orderRepository.save(order);
        applicationContext.publishEvent(new OrderCreatedEvent(order));
        return order;
    }

    public Pagination<Order> orderList(int page, int size) {
        return orderRepository.findByPage(page - 1, size);
    }

    public String prePay(String id, @Valid PayOrderCommand command, String successUrl, String cancelUrl) {
        var order = orderRepository.byId(id);
        order.prePay(command.getPaidPrice());
        Payment payment;
        try {
            payment = paymentApplicationService.createPayment(command.getPaidPrice(),
                    "USD", PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale, "订单支付",
                    cancelUrl, successUrl);
        } catch (PayPalRESTException e) {
            throw new RestException(ErrorCode.FAILED, "支付失败");
        }
        order.setPaymentId(payment.getId());
        orderRepository.save(order);

        for (Links links : payment.getLinks()) {
            if (links.getRel().equals("approval_url")) {
                return links.getHref();
            }
        }
        throw new RestException(ErrorCode.FAILED, "没有获取到支付URL");
    }

    public Pagination<OrderSummaryRepresentation> myOrderList(int page, int size, User user) {
        return OrderSummaryRepresentation.to(orderRepository.findUserId(page - 1, size, user.getId()));
    }

    public Pagination<Order> merchantOrderList(int page, int size, Merchant merchant) {
        return orderRepository.findByMerchantId(page - 1, size, merchant.getId());
    }

    public Order accept(String id, Merchant merchant) {
        var order = orderRepository.byId(id);
        order.accept(merchant);
        orderRepository.save(order);
        return order;
    }

    public Order reject(String id, String reason, Merchant merchant) {
        var order = orderRepository.byId(id);
        order.reject(reason, merchant);
        orderRepository.save(order);
        return order;
    }

    public Order startService(String id, String payNo, Merchant merchant) {
        var order = orderRepository.byId(id);
        order.startService(payNo, merchant);
        orderRepository.save(order);
        return order;
    }

    public void pay(String paymentId, String payerId) {
        log.info("支付回调：paymentId: {}, payerId: {}", paymentId, payerId);
        try {
            Payment payment = paymentApplicationService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                var order = orderRepository.byPaymentId(paymentId);
                order.pay();
                orderRepository.save(order);
                return;
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        throw new RestException(ErrorCode.FAILED, "支付失败");
    }


}
