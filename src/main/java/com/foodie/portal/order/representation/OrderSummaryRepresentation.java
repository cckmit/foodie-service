package com.foodie.portal.order.representation;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.Order;
import com.foodie.portal.order.OrderInfo;
import com.foodie.portal.order.OrderStatus;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.User;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Accessors(chain = true)
public class OrderSummaryRepresentation {
    private String id;
    private String number;
    private String activityTitle;
    private String activityAddress;
    private String activityLanguage;
    private String serviceDate;
    private String startTime;
    private int count;
    private BigDecimal price;
    private OrderInfo orderInfo;
    private OrderStatus status;
    private String payNo;
    private String rejectReason;
    private String merchantName;
    private double extractRatio;
    private BigDecimal benefitExtractRatio;
    private String paymentId;
    private Instant createdAt;

    public static OrderSummaryRepresentation from(Order order){
        return OrderRepresentationMapper.instance.from(order);
    }

    public static Pagination<OrderSummaryRepresentation> from(Pagination<Order> orders) {
        return OrderRepresentationMapper.instance.from(orders);
    }
}
