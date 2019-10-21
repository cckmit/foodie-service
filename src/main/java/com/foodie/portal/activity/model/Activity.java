package com.foodie.portal.activity.model;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.foodie.portal.city.City;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.user.model.Merchant;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Activity {

    private String id;
    private String title;
    private String subTitle;
    private String description;
    private String duration;
    private int maxPeopleLimit;
    private String images;
    private String language;
    private String address;
    private City city;
    private List<ActivityPrice> priceList;
    private List<ServiceScheduling> serviceSchedulingList;
    private ActivityStatus status;
    private ActivityType type;
    private Merchant merchant;

    public Activity() {
        this.id = IdUtil.fastSimpleUUID();
        status = ActivityStatus.NON_APPROVE;
    }

    public Activity(String title, String subTitle, String desc, String time, int maxPeopleCount,
                    String images, String language, String address, City city,
                    List<ActivityPrice> costList, ActivityType type) {
        this();
        this.title = title;
        this.subTitle = subTitle;
        this.description = desc;
        this.duration = time;
        this.maxPeopleLimit = maxPeopleCount;
        this.images = images;
        this.language = language;
        this.address = address;
        this.city = city;
        this.priceList = costList;
        this.type = type;
    }

    public static Activity create(String title, String subTitle, String desc, String duration, int maxPeopleCount,
                                  String images, String language, String address, City city,
                                  List<ActivityPrice> costList, ActivityType type) {
        if (Objects.isNull(city)) {
            throw new RestException(ErrorCode.FAILED, "所选城市不能存在");
        }
        return new Activity(title, subTitle, desc, duration, maxPeopleCount, images, language, address, city, costList, type);
    }

    public void update(String title, String subTitle, String desc, String time, int maxPeopleCount,
                       String images, String language, String address,
                       List<ActivityPrice> costList) {
        this.title = title;
        this.subTitle = subTitle;
        this.description = desc;
        this.duration = time;
        this.maxPeopleLimit = maxPeopleCount;
        this.images = images;
        this.language = language;
        this.address = address;
        this.priceList = costList;
    }

    public void pass() {
        this.status = ActivityStatus.PASSED;
    }

    public void reject() {
        this.status = ActivityStatus.REJECTED;
    }

    public double getPrice(int count) {
        if (priceList == null) {
            throw new RestException(ErrorCode.REFUSED, "活动价格未设定");
        }
        for (ActivityPrice activityPrice : priceList) {
            if (activityPrice.getReserveCount() == count) {
                return activityPrice.getPrice();
            }
        }
        throw new RestException(ErrorCode.REFUSED, "当前人数价格未设置");
    }

    public void updateScheduling(List<ServiceScheduling> serviceSchedulingList) {
        this.serviceSchedulingList = serviceSchedulingList;
    }

    public void updateReserve(String serviceDate, String startTime, int count) {
        ServiceScheduling scheduling = serviceSchedulingList.stream()

                .filter(serviceScheduling ->
                                DateUtil.format(serviceScheduling.getServiceDate(),"yyyy-MM-dd").equals(serviceDate))
                .findFirst()
                .orElseThrow(() -> new RestException(ErrorCode.FAILED, "没有排班日期！"));

        scheduling.updateReserve(startTime, count, maxPeopleLimit);
    }
}
