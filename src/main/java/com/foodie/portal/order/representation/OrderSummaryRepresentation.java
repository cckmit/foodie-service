package com.foodie.portal.order.representation;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.model.OrderInfo;
import com.foodie.portal.order.model.OrderStatus;
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
    private String activityImages;
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
    private Instant createdAt;

    public static OrderSummaryRepresentation from(Order order){
        return OrderRepresentationMapper.instance.from(order);
    }

    public static Pagination<OrderSummaryRepresentation> from(Pagination<Order> orders) {
        return OrderRepresentationMapper.instance.from(orders);
    }
}
