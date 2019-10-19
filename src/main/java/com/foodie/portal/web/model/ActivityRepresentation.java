package com.foodie.portal.web.model;

import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.activity.model.ActivityType;
import lombok.Data;

@Data
public class ActivityRepresentation {

    private String id;
    private String title;
    private String subTitle;
    private String description;
    private String duration;
    private int maxPeopleLimit;
    private String images;
    private String language;
    private String address;
    private String cityId;
    private String cityName;
    private ActivityStatus status;
    private ActivityType type;
    private String merchantName;
}
