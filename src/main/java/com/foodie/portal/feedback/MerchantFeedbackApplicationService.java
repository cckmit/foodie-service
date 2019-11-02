package com.foodie.portal.feedback;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.feedback.command.CreateMerchantFeedbackCommand;
import com.foodie.portal.feedback.model.MerchantFeedback;
import com.foodie.portal.user.model.Merchant;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantFeedbackApplicationService {

    @Autowired
    private MerchantFeedbackRepository feedbackRepository;

    public void create(CreateMerchantFeedbackCommand command, Merchant merchant) {
        var feedback = MerchantFeedback.create(command.getTitle(),command.getContent(), merchant);
        feedbackRepository.save(feedback);
    }

    public Pagination<MerchantFeedback> list(int page, int size) {
        return feedbackRepository.findAll(page - 1, size);
    }

    public MerchantFeedback detail(String id) {
        return feedbackRepository.byId(id);
    }
}
