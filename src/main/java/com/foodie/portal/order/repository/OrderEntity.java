package com.foodie.portal.order.repository;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.activity.Activity;
import com.foodie.portal.activity.repository.ActivityEntity;
import com.foodie.portal.order.OrderStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

import static java.time.Instant.now;

@Data
@Entity
@Table(name = "foodie_order")
public class OrderEntity {
    @Id
    private String id;
    private String number;
    @ManyToOne
    private ActivityEntity activity;
    private int count;
    private BigDecimal price;
    private OrderStatus status;
    private Instant createdAt;

}
