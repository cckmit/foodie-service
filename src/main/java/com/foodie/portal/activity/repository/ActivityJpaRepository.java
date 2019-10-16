package com.foodie.portal.activity.repository;

import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.activity.model.ActivityType;
import com.foodie.portal.webmanage.repository.ActivityRecommendEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityJpaRepository extends JpaRepository<ActivityEntity, String> {

    Page<ActivityEntity> findByStatus(ActivityStatus status, Pageable pageable);

    Page<ActivityEntity> findByMerchantId(String merchantId, Pageable pageable);

    List<ActivityEntity> findByIdIn(List<String> ids);

    Page<ActivityEntity> findByCityId (String cityId, Pageable pageable);
}
