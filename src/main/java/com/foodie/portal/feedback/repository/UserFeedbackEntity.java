package com.foodie.portal.feedback.repository;

import com.foodie.portal.user.repository.MerchantEntity;
import com.foodie.portal.user.repository.UserEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Table(name = "foodie_user_feedback")
public class UserFeedbackEntity {
    @Id
    private String id;
    private String title;
    private String content;
    private String name;
    private String email;
    @ManyToOne
    private UserEntity user;
    private Instant createdAt;
}
