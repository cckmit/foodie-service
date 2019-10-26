package com.foodie.portal.order;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.model.OrderStatus;
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

    public Order byId(String id) {
        return OrderEntityMapper.instance.to(orderJpaRepository.getOne(id));
    }

    public Order byPaymentId(String paymentId) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findByPaymentId(paymentId));
    }

    public Order byOrderNo(String orderNo) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findByNumber(orderNo));
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


    public Pagination<Order> findUserId(int page, int size, String merchantId) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findByUserId(merchantId, PageRequest.of(page, size)));
    }

    public Pagination<Order> findByPage(int page, int size) {
        return OrderEntityMapper.instance.to(orderJpaRepository.findAll(PageRequest.of(page, size)));
    }
}
