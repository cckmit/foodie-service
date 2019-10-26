package com.foodie.portal.restaurant.model;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.city.City;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private double price;
    private City city;
    private String address;
    private List<SetMeal> setMeals;
    private RestaurantType type;
    private Date createdAt;

    private Restaurant(String title, String subTitle,String images,
                       String content, double price, City city, RestaurantType type,List<SetMeal> setMeals) {
        this.id = IdUtil.fastSimpleUUID();
        this.title = title;
        this.subTitle = subTitle;
        this.images = images;
        this.content = content;
        this.price = price;
        this.city = city;
        this.type = type;
        this.setMeals = setMeals;
        this.createdAt = new Date();
    }

    public static Restaurant create(String title, String subTitle, String images,
                                    String content, double price, City city, RestaurantType type, List<SetMeal> setMeals) {
        return new Restaurant(title, subTitle, images, content, price, city, type, setMeals);
    }

    public void update(String title, String subTitle, String images, String content,
                       double price, City city, RestaurantType type, List<SetMeal> setMeals) {
        this.title = title;
        this.subTitle = subTitle;
        this.images = images;
        this.content = content;
        this.price = price;
        this.city = city;
        this.type = type;
        this.setMeals = setMeals;
    }
}
