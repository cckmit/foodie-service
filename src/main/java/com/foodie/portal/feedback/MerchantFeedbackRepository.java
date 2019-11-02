package com.foodie.portal.feedback;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.feedback.model.MerchantFeedback;
import com.foodie.portal.feedback.repository.MerchantFeedbackEntityMapper;
import com.foodie.portal.feedback.repository.MerchantFeedbackJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class MerchantFeedbackRepository {

    @Autowired
    private MerchantFeedbackJpaRepository merchantFeedbackJpaRepository;

    public void save(MerchantFeedback feedback) {
        merchantFeedbackJpaRepository.save(MerchantFeedbackEntityMapper.INSTANCE.from(feedback));
    }

    public Pagination<MerchantFeedback> findAll(int page, int size) {
        return MerchantFeedbackEntityMapper.INSTANCE.to(merchantFeedbackJpaRepository.findAll(PageRequest.of(page, size)));
    }

    public MerchantFeedback byId(String id) {
        return merchantFeedbackJpaRepository.findById(id)
                .map(MerchantFeedbackEntityMapper.INSTANCE::to)
                .orElse(null);
    }
}
