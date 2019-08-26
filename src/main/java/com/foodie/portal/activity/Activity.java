package com.foodie.portal.activity;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

import java.util.List;

@Data
public class Activity {

    private String id;
    private String title;
    private String subTitle;
    private String description;
    private String category;
    private String duration;
    private int maxPeopleCount;
    private String images;
    private String language;
    private String address;
    private String cityId;
    private String cityName;
    private List<ActivityPrice> priceList;
    private List<ActivityDateTime> serviceTime;
    private String state;

    public Activity() {
        this.id = IdUtil.fastSimpleUUID();
    }

    public Activity(String title, String subTitle, String desc, String category, String time, int maxPeopleCount, String images, String language, String address, String city,String cityName, List<ActivityPrice> costList, List<ActivityDateTime> dates, String state) {
        this();
        this.title = title;
        this.subTitle = subTitle;
        this.description = desc;
        this.category = category;
        this.duration = time;
        this.maxPeopleCount = maxPeopleCount;
        this.images = images;
        this.language = language;
        this.address = address;
        this.cityId = city;
        this.cityName = cityName;
        this.priceList = costList;
        this.serviceTime = dates;
        this.state = state;
    }

    public static Activity create(String title, String subTitle, String desc, String category, String duration, int maxPeopleCount, String images, String language, String address, String cityId,String cityName, List<ActivityPrice> costList, List<ActivityDateTime> dates, String state) {
        return new Activity(title, subTitle, desc, category, duration, maxPeopleCount, images, language, address, cityId, cityName ,costList, dates, state);
    }

    public void update(String title, String subTitle, String desc, String category, String time, int maxPeopleCount, String images, String language, String address, String city,String cityName, List<ActivityPrice> costList, List<ActivityDateTime> dates, String state) {
        this.title = title;
        this.subTitle = subTitle;
        this.description = desc;
        this.category = category;
        this.duration = time;
        this.maxPeopleCount = maxPeopleCount;
        this.images = images;
        this.language = language;
        this.address = address;
        this.cityId = city;
        this.cityName = cityName;
        this.priceList = costList;
        this.serviceTime = dates;
        this.state = state;
    }
}
