package com.foodie.portal.webmanage.representation;

import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.activity.model.ActivityType;
import lombok.Data;

@Data
public class RecommendActivityRepresentation {
    private String id;
    private String title;
    private String subTitle;
    private String description;
    private String images;
    private ActivityStatus status;
    private ActivityType type;
    private String merchantName;
}
