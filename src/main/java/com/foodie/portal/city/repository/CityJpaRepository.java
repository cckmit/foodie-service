package com.foodie.portal.city.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityJpaRepository extends JpaRepository<CityEntity, String> {
}
