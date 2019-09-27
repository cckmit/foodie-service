package com.foodie.portal.webmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerJpaRepository extends JpaRepository<BannerEntity, String> {
}
