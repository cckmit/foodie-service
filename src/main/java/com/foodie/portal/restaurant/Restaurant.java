package com.foodie.portal.restaurant;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.city.City;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date createdAt;

    private Restaurant(String title, String subTitle,String images,  String content, double price, City city) {
        this.id = IdUtil.fastSimpleUUID();
        this.title = title;
        this.subTitle = subTitle;
        this.images = images;
        this.content = content;
        this.price = price;
        this.city = city;
        this.createdAt = new Date();
    }

    public static Restaurant create(String title, String subTitle,String images, String content, double price, City city) {
        return new Restaurant(title, subTitle, images, content, price, city);
    }

    public void update(String title, String subTitle, String images, String content, double price, City city) {
        this.title = title;
        this.subTitle = subTitle;
        this.images = images;
        this.content = content;
        this.price = price;
        this.city = city;
    }
}
