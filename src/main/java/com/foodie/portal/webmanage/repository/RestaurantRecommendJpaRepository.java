package com.foodie.portal.webmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRecommendJpaRepository extends JpaRepository<RestaurantRecommendEntity, String> {

    List<RestaurantRecommendEntity> findByInterestedRecommend(boolean interestedRecommend);

    List<RestaurantRecommendEntity> findByInterestedRecommendAndCityId(boolean interestedRecommend, String cityId);

}
