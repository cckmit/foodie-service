package com.foodie.portal.activity.repository;

import com.foodie.portal.activity.ActivityDateTime;
import com.foodie.portal.activity.ActivityPrice;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "foodie_activity")
public class ActivityEntity {
    @Id
    private String id;
    private String title;
    private String subTitle;
    private String description;
    private String category;
    private String duration;
    private String maxPeopleCount;
    private String images;
    private String language;
    private String address;
    private String cityId;
    private String cityName;
    private String priceList;
    private String serviceTime;
    private String state;
}
