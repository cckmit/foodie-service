package com.foodie.portal.restaurant.repository;

import com.foodie.portal.city.City;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class RestaurantEntity {

    @Id
    private String id;
    private String title;
    private String subTitle;
    private String content;
    private double price;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private City city;
}
