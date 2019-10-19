package com.foodie.portal.feedback;

import lombok.Data;

@Data
public class CreateFeedbackCommand {
    protected String title;
    protected String content;
}
