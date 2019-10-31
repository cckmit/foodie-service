package com.foodie.portal.order.representation;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.OrderRepository;
import com.foodie.portal.order.model.OrderStatus;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.User;
import com.foodie.portal.utils.PaginationUtils;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderRepresentationService {
    @Autowired
    private OrderRepository orderRepository;

    public Pagination<OrderSummaryRepresentation> myOrderList(int page, int size, User user) {
        return OrderSummaryRepresentation.from(orderRepository.findActivityOrderByUserId(page - 1, size, user.getId()));
    }

    public Pagination<RestaurantOrderSummaryRepresentation> myRestaurantOrderList(int page, int size, User user) {
        return RestaurantOrderSummaryRepresentation.from(orderRepository.findRestaurantOrderByUserId(page - 1, size, user.getId()));
    }

    public Pagination<OrderSummaryRepresentation> merchantOrderList(int page, int size, Merchant merchant, OrderStatus status) {
        if(Objects.isNull(status)) {
            return OrderSummaryRepresentation.from(orderRepository.findByMerchantId(page - 1, size, merchant.getId()));

        }
        return OrderSummaryRepresentation.from(orderRepository.findByMerchantId(page - 1, size, merchant.getId(),status));
    }


    public Pagination<OrderSummaryRepresentation> activityOrderList(int page, int size) {
        Pagination<Order> orders = orderRepository.findActivityOrdersByPage(page - 1, size);

        return PaginationUtils.map(orders, order -> OrderSummaryRepresentation.from(order));
    }

    public OrderDetailRepresentation findActivityOrderById(String id) {
        Order order = orderRepository.findActivityOrderById(id);
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

    public Pagination<RestaurantOrderSummaryRepresentation> restaurantOrderList(int page, int size) {
        var orders = orderRepository.findRestaurantOrdersByPage(page - 1, size);

        return PaginationUtils.map(orders, order -> RestaurantOrderSummaryRepresentation.from(order));
    }

    public RestaurantOrderDetailRepresentation findRestaurantOrderById(String id) {
        var order = orderRepository.findRestaurantOrderById(id);
        return RestaurantOrderDetailRepresentationMapper.instance.from(order);
    }
}
