package com.foodie.portal.restaurant.repository;

import com.foodie.portal.restaurant.model.RestaurantType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity, String> {

    Page<RestaurantEntity> findByCityId(String cityId, Pageable page);

    Page<RestaurantEntity> findByCityIdAndTypeOrderBySort(String cityId, RestaurantType type, Pageable page);
}
