package com.foodie.portal.order.repository;

import com.foodie.portal.order.model.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantOrderJpaRepository extends JpaRepository<RestaurantOrderEntity, String> {

    RestaurantOrderEntity findByIdAndUserId(String id, String userId);

    Page<RestaurantOrderEntity> findByUserId(String userId, Pageable pageable);

    RestaurantOrderEntity findByPaymentId(String paymentId);

    RestaurantOrderEntity findByNumber(String number);
}
