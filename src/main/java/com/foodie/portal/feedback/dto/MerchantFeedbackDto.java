package com.foodie.portal.feedback.dto;

import com.foodie.portal.user.repository.MerchantEntity;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Data
public class MerchantFeedbackDto {
    private String id;
    private String title;
    private String content;
    private String merchantName;
    private String merchantEmail;
    private Instant createdAt;
}
