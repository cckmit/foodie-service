package com.foodie.portal.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFeedbackJpaRepository extends JpaRepository<UserFeedbackEntity, String> {
}
