package com.foodie.portal.order;

import com.foodie.portal.user.model.User;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderApplicationService {

    @Autowired
    private OrderRepository orderRepository;

    public Order create(CreateOrderCommand createOrderCommand, User user) {
        var order = Order.create(createOrderCommand.getActivity(), createOrderCommand.getCount(), createOrderCommand.getPrice());
        order.setUser(user);
        orderRepository.save(order);

        return order;
    }
}
