package com.foodie.portal.feedback.repository;

import com.foodie.portal.user.repository.MerchantEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "foodie_merchant_feedback")
public class MerchantFeedbackEntity {
    @Id
    private String id;
    private String title;
    private String content;
    @ManyToOne
    private MerchantEntity merchant;
}
