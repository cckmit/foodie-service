package com.foodie.portal.order;

import com.foodie.portal.order.repository.OrderEntityMapper;
import com.foodie.portal.order.repository.OrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    public void save(Order order) {
        orderJpaRepository.save(OrderEntityMapper.instance.from(order));
    }
}
