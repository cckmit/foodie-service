package com.foodie.portal.restaurant;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.city.City;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private RestaurantType type;
    private Date createdAt;

    private Restaurant(String title, String subTitle,String images,
                       String content, double price, City city, RestaurantType type) {
        this.id = IdUtil.fastSimpleUUID();
        this.title = title;
        this.subTitle = subTitle;
        this.images = images;
        this.content = content;
        this.price = price;
        this.city = city;
        this.type = type;
        this.createdAt = new Date();
    }

    public static Restaurant create(String title, String subTitle, String images,
                                    String content, double price, City city, RestaurantType type) {
        return new Restaurant(title, subTitle, images, content, price, city, type);
    }

    public void update(String title, String subTitle, String images, String content,
                       double price, City city, RestaurantType type) {
        this.title = title;
        this.subTitle = subTitle;
        this.images = images;
        this.content = content;
        this.price = price;
        this.city = city;
        this.type = type;
    }
}
