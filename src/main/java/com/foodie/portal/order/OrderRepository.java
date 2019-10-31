package com.foodie.portal.order;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.model.OrderStatus;
import com.foodie.portal.order.model.RestaurantOrder;
import com.foodie.portal.order.repository.OrderEntityMapper;
import com.foodie.portal.order.repository.OrderJpaRepository;
import com.foodie.portal.order.repository.RestaurantOrderEntityMapper;
import com.foodie.portal.order.repository.RestaurantOrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository {

    @Autowired
    private OrderJpaRepository orderJpaRepository;
    @Autowired
    private RestaurantOrderJpaRepository restaurantOrderJpaRepository;

    public void save(Order order) {
        orderJpaRepository.save(OrderEntityMapper.instance.from(order));
    }

    public void save(RestaurantOrder order) {
        restaurantOrderJpaRepository.save(RestaurantOrderEntityMapper.instance.from(order));
    }

    public Order findActivityOrderById(String id) {
        return OrderEntityMapper.instance.to(orderJpaRepository.getOne(id));
    }


    public RestaurantOrder findRestaurantOrderById(String id) {
        return RestaurantOrderEntityMapper.instance.to(restaurantOrderJpaRepository.getOne(id));
    }

    public Order byPaymentId(String paymentId) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findByPaymentId(paymentId));
    }

    public RestaurantOrder findRestaurantOrderByPaymentId(String paymentId) {
        return RestaurantOrderEntityMapper.instance.to(restaurantOrderJpaRepository.findByPaymentId(paymentId));
    }

    public Order findActivityOrderByOrderNo(String orderNo) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findByNumber(orderNo));
    }

    public RestaurantOrder findRestaurantOrderByOrderNo(String orderNo) {
        return RestaurantOrderEntityMapper.instance.to(restaurantOrderJpaRepository.findByNumber(orderNo));
    }

    public Pagination<Order> findByMerchantId(int page, int size, String merchantId) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findByMerchantId(merchantId, PageRequest.of(page, size)));
    }

    public Pagination<Order> findByMerchantId(int page, int size, String merchantId, OrderStatus status) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findByMerchantIdAndStatus(merchantId, status, PageRequest.of(page, size)));
    }

    public Order findByIdAndMerchantId(String id, String merchantId) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findByIdAndMerchantId(id, merchantId));
    }

    public Order findByIdAndUserId(String id, String userId) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findByIdAndUserId(id, userId));
    }


    public Pagination<Order> findActivityOrderByUserId(int page, int size, String merchantId) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findByUserId(merchantId, PageRequest.of(page, size)));
    }

    public Pagination<RestaurantOrder> findRestaurantOrderByUserId(int page, int size, String merchantId) {
        return RestaurantOrderEntityMapper.instance.to(restaurantOrderJpaRepository.findByUserId(merchantId, PageRequest.of(page, size)));
    }

    public Pagination<Order> findActivityOrdersByPage(int page, int size) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findAll(PageRequest.of(page, size)));
    }

    public Pagination<RestaurantOrder> findRestaurantOrdersByPage(int page, int size) {
        return RestaurantOrderEntityMapper.instance.to(restaurantOrderJpaRepository.findAll(PageRequest.of(page, size)));
    }
}
