package com.foodie.portal.order.representation;

import com.foodie.portal.order.OrderInfo;
import com.foodie.portal.order.OrderStatus;
import lombok.Data;

import java.time.Instant;

@Data
public class OrderDetailRepresentation {

    private String id;
    private String number;
    private String activityImages;
    private String activityTitle;
    private String activityAddress;
    private String activityLanguage;
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
