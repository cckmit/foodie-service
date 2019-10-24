package com.foodie.portal.webmanage.repository;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "foodie_restaurant")
public class RestaurantRecommendEntity {
    @Id
    private String id;
    private String title;
    private String subTitle;
    private String images;
    private String content;
    @Column(name = "city_id")
    private String cityId;
    private boolean interestedRecommend;
}
