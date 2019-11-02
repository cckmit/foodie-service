package com.foodie.portal.feedback;

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
}
