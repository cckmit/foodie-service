package com.foodie.portal.restaurant.model;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.city.City;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Restaurant {

    private String id;
    private String title;
    private String subTitle;
    private String images;
    private String content;
    private City city;
    private String area;
    private String address;
    private List<SetMeal> setMeals;
    private RestaurantType type;
    private Long sort;
    private Instant createdAt;

    private Restaurant(String title, String subTitle, String images,
                       String content, City city, String area, String address, RestaurantType type, List<SetMeal> setMeals) {
        this.id = IdUtil.fastSimpleUUID();
        this.title = title;
        this.subTitle = subTitle;
        this.images = images;
        this.content = content;
        this.city = city;
        this.area = area;
        this.address = address;
        this.type = type;
        this.setMeals = setMeals;
        this.sort = 999L;
        this.createdAt = Instant.now();
    }

    public static Restaurant create(String title, String subTitle, String images,
                                    String content, City city, String area, String address, RestaurantType type, List<SetMeal> setMeals) {
        return new Restaurant(title, subTitle, images, content, city, area, address, type, setMeals);
    }

    public void update(String title, String subTitle, String images, String content,
                       City city, String area, String address, RestaurantType type, List<SetMeal> setMeals) {
        this.title = title;
        this.subTitle = subTitle;
        this.images = images;
        this.content = content;
        this.city = city;
        this.area = area;
        this.address = address;
        this.type = type;
        this.setMeals = setMeals;
    }

    public void top() {
        this.sort = 1L;
    }
}
