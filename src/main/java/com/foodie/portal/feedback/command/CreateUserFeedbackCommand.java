package com.foodie.portal.feedback.command;

import lombok.Data;

@Data
public class CreateUserFeedbackCommand {
    private String title;
    private String content;
    private String name;
    private String email;
}
