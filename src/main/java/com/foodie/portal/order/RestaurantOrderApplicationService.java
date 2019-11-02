package com.foodie.portal.order;

import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.EventPublisher;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.commons.event.OrderCreatedEvent;
import com.foodie.portal.order.command.CreateOrderCommand;
import com.foodie.portal.order.command.CreateRestaurantOrderCommand;
import com.foodie.portal.order.command.PayOrderCommand;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.model.RestaurantOrder;
import com.foodie.portal.payment.PaymentApplicationService;
import com.foodie.portal.payment.PaypalPaymentIntent;
import com.foodie.portal.payment.PaypalPaymentMethod;
import com.foodie.portal.restaurant.RestaurantApplicationService;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.User;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Slf4j
@Service
public class RestaurantOrderApplicationService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ActivityApplicationService activityApplicationService;
    @Autowired
    private RestaurantApplicationService restaurantApplicationService;
    @Autowired
    private EventPublisher eventPublisher;
    @Autowired
    private PaymentApplicationService paymentApplicationService;


    @Transactional
    public RestaurantOrder create(CreateRestaurantOrderCommand command, User user) {
        //创建订单
        var restaurant = restaurantApplicationService.findById(command.getRestaurantId());
        var order = RestaurantOrder.create(restaurant,command.getSetMealName(), command.getCount(), command.getReserveDate(),
                 command.getOrderInfo(), user);
        orderRepository.save(order);
//        eventPublisher.publish(new OrderCreatedEvent(order));
        return order;
    }


    public String prePay(String id, @Valid PayOrderCommand command) {
        var order = orderRepository.findRestaurantOrderById(id);
        order.prePay(command.getPaidPrice());
        Payment payment;
        try {
            payment = paymentApplicationService.createPayment(command.getPaidPrice(),
                    "USD", PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale, "餐厅订单支付", order.getNumber());
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

    public RestaurantOrder cancel(String orderNo) {
        var order = orderRepository.findRestaurantOrderByOrderNo(orderNo);
        order.cancel();
        orderRepository.save(order);
        return order;
    }

    public Order pay(String paymentId, String payerId) {
        log.info("支付回调：paymentId: {}, payerId: {}", paymentId, payerId);
        try {
            Payment payment = paymentApplicationService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                var order = orderRepository.findRestaurantOrderByPaymentId(paymentId);
                order.pay();
                orderRepository.save(order);
                return order;
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        throw new RestException(ErrorCode.FAILED, "支付失败");
    }

}
