package com.foodie.portal.order;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.commons.event.OrderCreatedEvent;
import com.foodie.portal.order.command.CreateOrderCommand;
import com.foodie.portal.order.command.PayOrderCommand;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.User;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class OrderApplicationService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ActivityApplicationService activityApplicationService;
    @Autowired
    private ApplicationContext applicationContext;

    public Order create(CreateOrderCommand createOrderCommand, User user) {
        Activity activity = activityApplicationService.findById(createOrderCommand.getActivityId());
        var order = Order.create(activity, createOrderCommand.getCount());
        order.setUser(user);
        orderRepository.save(order);
        applicationContext.publishEvent(new OrderCreatedEvent(order));
        return order;
    }

    public Pagination<Order> orderList(int page, int size) {
        return orderRepository.findByPage(page - 1, size);
    }

    public void pay(String id, @Valid PayOrderCommand command) {
        var order = orderRepository.byId(id);
        order.pay(command.getPaidPrice());
        orderRepository.save(order);
    }

    public Pagination<Order> myOrderList(int page, int size, User user) {
        return orderRepository.findByMerchantId(page - 1, size, user.getId());
    }

    public Pagination<Order> merchantOrderList(int page, int size, Merchant merchant) {
        return orderRepository.findByMerchantId(page - 1, size, merchant.getId());
    }

    public Order accept(String id, Merchant merchant) {
        var order =  orderRepository.byId(id);
        order.accept(merchant);
        orderRepository.save(order);
        return order;
    }

    public Order reject(String id, String reason, Merchant merchant) {
        var order =  orderRepository.byId(id);
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
}
