package com.foodie.portal.order;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.repository.OrderEntityMapper;
import com.foodie.portal.order.repository.OrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    public void save(Order order) {
        orderJpaRepository.save(OrderEntityMapper.instance.from(order));
    }

    public Pagination<Order> findByPage(int page, int size) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findAll(PageRequest.of(page, size)));
    }
}
