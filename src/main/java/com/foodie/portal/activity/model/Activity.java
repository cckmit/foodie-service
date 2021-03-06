package com.foodie.portal.activity.model;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.foodie.portal.city.City;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.user.model.Merchant;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Data
public class Activity {

    private String id;
    private String title;
    private String subTitle;
    private String description;
    private String tags;
    private String duration;
    private int maxPeopleLimit;
    private String images;
    private String language;
    private String area;
    private String address;
    private City city;
    private List<ActivityPrice> priceList;
    private List<ServiceScheduling> serviceSchedulingList;
    private ActivityStatus status;
    private ActivityType type;
    private Merchant merchant;
    private Long sort;
    private Instant createdAt;

    public Activity() {
        this.id = IdUtil.fastSimpleUUID();
        status = ActivityStatus.NON_APPROVE;
        sort = 999L;
        createdAt = Instant.now();
    }

    public Activity(String title, String subTitle, String desc, String tags, String duration, int maxPeopleCount,
                    String images, String language, String area, String address, City city,
                    List<ActivityPrice> costList, ActivityType type) {
        this();
        this.title = title;
        this.subTitle = subTitle;
        this.description = desc;
        this.duration = duration;
        this.maxPeopleLimit = maxPeopleCount;
        this.images = images;
        this.language = language;
        this.area = area;
        this.address = address;
        this.city = city;
        this.priceList = costList;
        this.type = type;
        this.tags = tags;
    }

    public static Activity create(String title, String subTitle, String desc, String tags, String duration, int maxPeopleCount,
                                  String images, String language, String area, String address, City city,
                                  List<ActivityPrice> costList, ActivityType type) {
        if (Objects.isNull(city)) {
            throw new RestException(ErrorCode.FAILED, "????????????????????????");
        }
        return new Activity(title, subTitle, desc, tags, duration, maxPeopleCount, images, language, area, address, city, costList, type);
    }

    public void update(String title, String subTitle, String desc, String tags, String duration, int maxPeopleCount,
                       String images, String language, String area, String address,
                       List<ActivityPrice> costList, City city) {
        this.title = title;
        this.subTitle = subTitle;
        this.description = desc;
        this.duration = duration;
        this.maxPeopleLimit = maxPeopleCount;
        this.images = images;
        this.language = language;
        this.area = area;
        this.address = address;
        this.priceList = costList;
        this.city = city;
        this.tags = tags;
    }

    public void pass() {
        this.status = ActivityStatus.PASSED;
    }

    public void reject() {
        this.status = ActivityStatus.REJECTED;
    }

    public double getPrice(int count) {
        if (priceList == null) {
            throw new RestException(ErrorCode.REFUSED, "?????????????????????");
        }
        return priceList.stream()
                .filter(activityPrice ->  activityPrice.getReserveCount() == count)
                .findFirst()
                .map(ActivityPrice::getPrice)
                .orElseThrow(() -> new RestException(ErrorCode.REFUSED, "???????????????????????????"));
    }

    public void updateScheduling(List<ServiceScheduling> serviceSchedulingList) {
        this.serviceSchedulingList = serviceSchedulingList;
    }

    public void updateReserve(String serviceDate, String startTime, int count) {
        ServiceScheduling scheduling = serviceSchedulingList.stream()

                .filter(serviceScheduling ->
                        DateUtil.format(serviceScheduling.getServiceDate(), "yyyy-MM-dd").equals(serviceDate))
                .findFirst()
                .orElseThrow(() -> new RestException(ErrorCode.FAILED, "?????????????????????"));

        scheduling.updateReserve(startTime, count, maxPeopleLimit);
    }

    public void top() {
        this.sort = 1L;
    }
}
