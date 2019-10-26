package com.foodie.portal.order.representation;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.OrderRepository;
import com.foodie.portal.user.model.User;
import com.foodie.portal.utils.PaginationUtils;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderRepresentationService {
    @Autowired
    private OrderRepository orderRepository;

    public Pagination<OrderSummaryRepresentation> myOrderList(int page, int size, User user) {
        return OrderSummaryRepresentation.from(orderRepository.findUserId(page - 1, size, user.getId()));
    }

    public Pagination<OrderSummaryRepresentation> orderList(int page, int size) {
        Pagination<Order> orders = orderRepository.findByPage(page - 1, size);

        return PaginationUtils.map(orders, order -> OrderSummaryRepresentation.from(order));
    }

    public OrderDetailRepresentation findById(String id) {
        Order order = orderRepository.byId(id);
        return OrderDetailRepresentationMapper.instance.from(order);
    }

    public OrderDetailRepresentation findByIdAndMerchantId(String id, String merchantId) {
        var order = orderRepository.findByIdAndMerchantId(id,merchantId);
        return OrderDetailRepresentationMapper.instance.from(order);
    }

    public OrderDetailRepresentation findByIdAndUserId(String id,String userId) {
        var order = orderRepository.findByIdAndUserId(id, userId);
        return OrderDetailRepresentationMapper.instance.from(order);
    }
}
