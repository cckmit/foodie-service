package com.foodie.portal.web.po;

import lombok.Data;

@Data
public class RestaurantRepresentationPo {
    private String id;
    private String title;
    private String subTitle;
    private String setMeals;
    private String images;
    private String content;
    private String cityName;
    private String area;
    private String address;
    private boolean favourite;

}
