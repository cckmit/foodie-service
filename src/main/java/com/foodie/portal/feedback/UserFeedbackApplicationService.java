package com.foodie.portal.feedback;

import com.foodie.portal.feedback.command.CreateMerchantFeedbackCommand;
import com.foodie.portal.feedback.command.CreateUserFeedbackCommand;
import com.foodie.portal.feedback.model.MerchantFeedback;
import com.foodie.portal.feedback.model.UserFeedback;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.User;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFeedbackApplicationService {

    @Autowired
    private UserFeedbackRepository feedbackRepository;

    public void create(CreateUserFeedbackCommand command, User user) {
        var feedback = UserFeedback.create(command.getTitle(),command.getContent(),command.getName(), command.getEmail(), user);
        feedbackRepository.save(feedback);
    }
}
