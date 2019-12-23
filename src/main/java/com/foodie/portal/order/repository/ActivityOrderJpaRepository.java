package com.foodie.portal.order.repository;

import com.foodie.portal.order.model.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityOrderJpaRepository extends JpaRepository<ActivityOrderEntity, String> {

    Page<ActivityOrderEntity> findByMerchantId(String merchantId, Pageable pageable);

    Page<ActivityOrderEntity> findByMerchantIdAndStatusIn(String merchantId, List<OrderStatus> status, Pageable pageable);

    ActivityOrderEntity findByIdAndMerchantId(String id, String merchantId);

    ActivityOrderEntity findByIdAndUserId(String id, String userId);

    Page<ActivityOrderEntity> findByUserId(String userId, Pageable pageable);

    ActivityOrderEntity findByPaymentId(String paymentId);

    ActivityOrderEntity findByNumber(String number);
}
