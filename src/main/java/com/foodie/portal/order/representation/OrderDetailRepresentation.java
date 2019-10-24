package com.foodie.portal.order.representation;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.order.OrderInfo;
import com.foodie.portal.order.OrderStatus;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.User;
import lombok.Data;

import java.time.Instant;

@Data
public class OrderDetailRepresentation {

    private String id;
    private String number;
    private String activityTitle;
    private int count;
    private double price;
    private double unitPrice;
    private String serviceDate;
    private String startTime;
    private OrderInfo orderInfo;
    private OrderStatus status;
    private String payNo;
    private String rejectReason;
    private String merchantName;
    private Instant createdAt;
}
