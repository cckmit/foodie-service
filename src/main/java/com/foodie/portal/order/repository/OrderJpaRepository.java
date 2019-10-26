package com.foodie.portal.order.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, String> {

    Page<OrderEntity> findByMerchantId(String merchantId, Pageable pageable);

    OrderEntity findByIdAndMerchantId(String id, String merchantId);

    OrderEntity findByIdAndUserId(String id, String userId);

    Page<OrderEntity> findByUserId(String userId, Pageable pageable);

    OrderEntity findByPaymentId(String paymentId);

    OrderEntity findByNumber(String number);
}
