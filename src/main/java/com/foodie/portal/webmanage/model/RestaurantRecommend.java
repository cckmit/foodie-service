package com.foodie.portal.webmanage.model;

import lombok.Data;

import javax.persistence.Id;

@Data
public class RestaurantRecommend {
    @Id
    private String id;
    private String title;
    private String subTitle;
    private String images;
    private String content;
    private String cityId;
    private boolean interestedRecommend;
}
