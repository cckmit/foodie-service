package com.foodie.portal.feedback;

import com.foodie.portal.feedback.model.MerchantFeedback;
import com.foodie.portal.feedback.model.UserFeedback;
import com.foodie.portal.feedback.repository.MerchantFeedbackEntityMapper;
import com.foodie.portal.feedback.repository.MerchantFeedbackJpaRepository;
import com.foodie.portal.feedback.repository.UserFeedbackEntityMapper;
import com.foodie.portal.feedback.repository.UserFeedbackJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFeedbackRepository {

    @Autowired
    private UserFeedbackJpaRepository userFeedbackJpaRepository;

    public void save(UserFeedback feedback) {
        userFeedbackJpaRepository.save(UserFeedbackEntityMapper.INSTANCE.from(feedback));
    }
}
