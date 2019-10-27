package com.foodie.portal.webmanage.repository;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.webmanage.model.ActivityRecommend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRecommendJpaRepository extends JpaRepository<ActivityRecommendEntity, String> {

    List<ActivityRecommendEntity> findByInterestedRecommendAndCityId(boolean interestedRecommend, String cityId);

    List<ActivityRecommendEntity> findByInterestedRecommend(boolean interestedRecommend);

    List<ActivityRecommendEntity> findByTopRecommend(boolean topRecommend);
}
