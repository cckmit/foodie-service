package com.foodie.portal.feedback;

import com.foodie.portal.feedback.model.MerchantFeedback;
import com.foodie.portal.feedback.repository.MerchantFeedbackEntityMapper;
import com.foodie.portal.feedback.repository.MerchantFeedbackJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MerchantFeedbackRepository {

    @Autowired
    private MerchantFeedbackJpaRepository merchantFeedbackJpaRepository;

    public void save(MerchantFeedback feedback) {
        merchantFeedbackJpaRepository.save(MerchantFeedbackEntityMapper.INSTANCE.from(feedback));
    }
}
