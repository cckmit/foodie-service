package com.foodie.portal.feedback;

import com.foodie.portal.user.model.Merchant;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackApplicationService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public void create(CreateFeedbackCommand command, Merchant merchant) {
        var feedback = MerchantFeedback.create(command.getTitle(),command.getContent(), merchant);
        feedbackRepository.save(feedback);

    }
}
