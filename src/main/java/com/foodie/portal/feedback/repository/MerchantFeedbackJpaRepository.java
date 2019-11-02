package com.foodie.portal.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantFeedbackJpaRepository extends JpaRepository<MerchantFeedbackEntity, String> {
}
