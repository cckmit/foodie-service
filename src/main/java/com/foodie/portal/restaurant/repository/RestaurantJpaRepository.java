package com.foodie.portal.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity, String> {
}
