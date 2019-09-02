package com.foodie.portal.activity;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.user.Merchant;
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
    private int maxPeopleLimit;
    private String images;
    private String language;
    private String address;
    private String cityId;
    private String cityName;
    private List<ActivityPrice> priceList;
    private List<ActivityDateTime> serviceTime;
    private ActivityStatus status;
    private Merchant merchant;

    public Activity() {
        this.id = IdUtil.fastSimpleUUID();
        status = ActivityStatus.NON_APPROVE;
    }

    public Activity(String title, String subTitle, String desc, String category, String time, int maxPeopleCount, String images, String language, String address, String city,String cityName, List<ActivityPrice> costList, List<ActivityDateTime> dates) {
        this();
        this.title = title;
        this.subTitle = subTitle;
        this.description = desc;
        this.category = category;
        this.duration = time;
        this.maxPeopleLimit = maxPeopleCount;
        this.images = images;
        this.language = language;
        this.address = address;
        this.cityId = city;
        this.cityName = cityName;
        this.priceList = costList;
        this.serviceTime = dates;
    }

    public static Activity create(String title, String subTitle, String desc, String category, String duration, int maxPeopleCount, String images, String language, String address, String cityId,String cityName, List<ActivityPrice> costList, List<ActivityDateTime> dates) {
        return new Activity(title, subTitle, desc, category, duration, maxPeopleCount, images, language, address, cityId, cityName ,costList, dates);
    }

    public void update(String title, String subTitle, String desc, String category, String time, int maxPeopleCount, String images, String language, String address, String city,String cityName, List<ActivityPrice> costList, List<ActivityDateTime> dates) {
        this.title = title;
        this.subTitle = subTitle;
        this.description = desc;
        this.category = category;
        this.duration = time;
        this.maxPeopleLimit = maxPeopleCount;
        this.images = images;
        this.language = language;
        this.address = address;
        this.cityId = city;
        this.cityName = cityName;
        this.priceList = costList;
        this.serviceTime = dates;
    }

    public void pass() {
        this.status = ActivityStatus.PASSED;
    }

    public void reject() {
        this.status = ActivityStatus.REJECTED;
    }
}
