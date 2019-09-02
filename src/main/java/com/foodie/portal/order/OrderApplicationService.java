package com.foodie.portal.order;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderApplicationService {

    @Autowired
    private OrderRepository orderRepository;

    public Order create(CreateOrderCommand createOrderCommand) {
        var order = Order.create(createOrderCommand.getActivity(), createOrderCommand.getCount(), createOrderCommand.getPrice());
        orderRepository.save(order);
        return order;
    }
}
