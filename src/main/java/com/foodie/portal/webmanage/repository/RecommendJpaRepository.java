package com.foodie.portal.webmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendJpaRepository extends JpaRepository<RecommendEntity, RecommendId> {

    List<RecommendEntity> findByType(RecommendType type);
}
