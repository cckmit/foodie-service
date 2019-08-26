package com.foodie.portal.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityJpaRepository extends JpaRepository<ActivityEntity, String> {
}
