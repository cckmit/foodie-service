package com.foodie.portal.feedback.model;

import com.foodie.portal.user.repository.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserFeedback extends Feedback{

    private String name;
    private String email;
    private UserEntity user;
}
