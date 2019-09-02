package com.foodie.portal.activity.repository;

import com.foodie.portal.activity.ActivityStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityJpaRepository extends JpaRepository<ActivityEntity, String> {

    Page<ActivityEntity> findByStatus(ActivityStatus status, Pageable pageable);

    Page<ActivityEntity> findByMerchantId(String merchantId, Pageable pageable);
}
