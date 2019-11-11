package com.foodie.portal.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.activity.model.ActivityPrice;
import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.activity.model.ActivityType;
import com.foodie.portal.activity.model.ServiceScheduling;
import com.foodie.portal.activity.repository.ActivityEntity;
import com.foodie.portal.commons.utils.JsonUtils;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.collections.CollectionUtils;

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
    private List<ServiceScheduling> serviceSchedulingList;
    private ActivityType type;
    private String merchantName;
    private boolean favourite;

    public static ActivityDetailRepresentation from(ActivityEntity entity) {
        return ActivityDetailRepresentationMapper.INSTANCE.from(entity);
    }
}
