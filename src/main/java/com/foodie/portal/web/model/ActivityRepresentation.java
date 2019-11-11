package com.foodie.portal.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.activity.model.ActivityPrice;
import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.activity.model.ActivityType;
import com.foodie.portal.commons.utils.JsonUtils;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Data
public class ActivityRepresentation {

    private String id;
    private String title;
    private String subTitle;
    private String description;
    private String duration;
    private int maxPeopleLimit;
    @JsonIgnore
    private String priceListStr;
    private String images;
    private String language;
    private String address;
    private String cityId;
    private String cityName;
    private String area;
    private ActivityType type;
    private String merchantName;

    public double getPrice() {
        List<ActivityPrice> list = JsonUtils.toBean(priceListStr, new TypeReference<List<ActivityPrice>>() {});
        if(CollectionUtils.isEmpty(list)) {
            return 0;
        }
        return list.stream().mapToDouble(ActivityPrice::getPrice).min().getAsDouble();
    }
}
