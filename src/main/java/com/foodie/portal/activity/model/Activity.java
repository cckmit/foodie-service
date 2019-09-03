package com.foodie.portal.activity.model;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.city.City;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.user.model.Merchant;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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
    private City city;
    private String cityName;
    private List<ActivityPrice> priceList;
    private List<ActivityDateTime> serviceTime;
    private ActivityStatus status;
    private ActivityType type;
    private Merchant merchant;

    public Activity() {
        this.id = IdUtil.fastSimpleUUID();
        status = ActivityStatus.NON_APPROVE;
    }

    public Activity(String title, String subTitle, String desc, String category, String time, int maxPeopleCount,
                    String images, String language, String address, City city,String cityName,
                    List<ActivityPrice> costList, List<ActivityDateTime> dates, ActivityType type) {
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
        this.city = city;
        this.cityName = cityName;
        this.priceList = costList;
        this.serviceTime = dates;
        this.type = type;
    }

    public static Activity create(String title, String subTitle, String desc, String category, String duration, int maxPeopleCount,
                                  String images, String language, String address, City city,String cityName,
                                  List<ActivityPrice> costList, List<ActivityDateTime> dates, ActivityType type) {
        if(Objects.isNull(city)) {
            throw new RestException(ErrorCode.FAILED, "所选城市不能存在");
        }
        return new Activity(title, subTitle, desc, category, duration, maxPeopleCount, images, language, address, city, cityName ,costList, dates, type);
    }

    public void update(String title, String subTitle, String desc, String category, String time, int maxPeopleCount,
                       String images, String language, String address,
                       String cityName, List<ActivityPrice> costList, List<ActivityDateTime> dates) {
        this.title = title;
        this.subTitle = subTitle;
        this.description = desc;
        this.category = category;
        this.duration = time;
        this.maxPeopleLimit = maxPeopleCount;
        this.images = images;
        this.language = language;
        this.address = address;
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

    public BigDecimal getPrice(int count) {
        if(priceList == null) {
            return BigDecimal.ZERO;
        }
        for (ActivityPrice activityPrice: priceList) {
            if (activityPrice.getCount() == count) {
                return activityPrice.getPrice();
            }
        }
        throw new RestException(ErrorCode.REFUSED, "不包含当前人数的价格");
    }
}
