package com.foodie.portal.feedback.model;

import com.foodie.portal.user.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserFeedback extends Feedback{

    private String name;
    private String email;
    private User user;

    public UserFeedback(String title, String content, String name, String email, User user) {
        super(title, content);
        this.name = name;
        this.email = email;
        this.user = user;
    }

    public static UserFeedback create(String title, String content, String name, String email, User user) {
        return new UserFeedback(title, content, name, email, user);

    }
}
