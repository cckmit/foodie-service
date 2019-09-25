package com.foodie.portal.activity.representation;

import com.foodie.portal.activity.model.ServiceScheduling;
import com.foodie.portal.activity.model.ActivityPrice;
import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.activity.model.ActivityType;

import java.util.List;

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
    private List<ActivityPrice> priceList;
    private List<ServiceScheduling> serviceTime;
    private ActivityStatus status;
    private ActivityType type;
    private String merchantName;
}
