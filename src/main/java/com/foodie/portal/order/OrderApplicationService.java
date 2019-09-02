package com.foodie.portal.order;

import com.foodie.portal.activity.Activity;
import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.user.model.User;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Objects;

@Service
public class OrderApplicationService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ActivityApplicationService activityApplicationService;

    public Order create(CreateOrderCommand createOrderCommand, User user) {
        Activity activity = activityApplicationService.findById(createOrderCommand.getActivityId());
        if (Objects.isNull(activity)) {
            throw new RestException(ErrorCode.NO_RESULT_FOUND.getCode(), "活动不存在");
        }
        var order = Order.create(activity, createOrderCommand.getCount());
        order.setUser(user);
        orderRepository.save(order);

        return order;
    }

    public Pagination<Order> findByPage(int page, int size) {
        return orderRepository.findByPage(page - 1, size);
    }

    public void pay(String id, @Valid PayOrderCommand command) {
        var order = orderRepository.byId(id);
        order.pay(command.getPaidPrice());
        orderRepository.save(order);
    }
}
