package com.foodie.portal.restaurant.repository;

import com.foodie.portal.city.City;
import com.foodie.portal.city.repository.CityEntity;
import com.foodie.portal.restaurant.RestaurantType;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity(name = "FOODIE_RESTAURANT")
public class RestaurantEntity {

    @Id
    private String id;
    private String title;
    private String subTitle;
    private String images;
    private String content;
    private Double price;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private CityEntity city;
    @Enumerated(EnumType.STRING)
    private RestaurantType type;
    private Date createdAt;
}
