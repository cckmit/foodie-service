package com.foodie.portal.order.repository;

import com.foodie.portal.activity.repository.ActivityEntity;
import com.foodie.portal.order.model.OrderStatus;
import com.foodie.portal.restaurant.repository.RestaurantEntity;
import com.foodie.portal.user.repository.MerchantEntity;
import com.foodie.portal.user.repository.UserEntity;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Table(name = "FOODIE_RESTAURANT_ORDER")
public class RestaurantOrderEntity {
    @Id
    private String id;
    private String number;
    @ManyToOne
    private RestaurantEntity restaurant;
    private String setMealName;
    private int count;
    private Double totalPrice;
    private Double itemPrice;
    private String reserveDate;
    private String orderInfo;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private UserEntity user;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String payNo;
    private String paymentId;
    private Instant createdAt;

}
