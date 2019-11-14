package com.foodie.portal.web.model;

import com.foodie.portal.activity.model.ActivityPrice;
import com.foodie.portal.activity.model.ActivityType;
import com.foodie.portal.activity.repository.ActivityEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ActivityDetailRepresentation {

    private String id;
    private String title;
    private String subTitle;
    private String description;
    private String duration;
    private int maxPeopleLimit;
    private double price;
    private String images;
    private String language;
    private String area;
    private String address;
    private String cityId;
    private String cityName;
    private List<ActivityPrice> priceList;
    private ActivityType type;
    private String merchantName;
    private boolean favourite;

    public static ActivityDetailRepresentation from(ActivityEntity entity) {
        return ActivityDetailRepresentationMapper.INSTANCE.from(entity);
    }
}
