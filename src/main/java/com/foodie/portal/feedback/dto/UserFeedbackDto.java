package com.foodie.portal.feedback.dto;

import com.foodie.portal.user.repository.UserEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Data
public class UserFeedbackDto {
    private String id;
    private String title;
    private String content;
    private String name;
    private String email;
    private Instant createdAt;
}
