package com.foodie.portal.feedback.command;

import lombok.Data;

@Data
public class CreateMerchantFeedbackCommand {
    protected String title;
    protected String content;
}
