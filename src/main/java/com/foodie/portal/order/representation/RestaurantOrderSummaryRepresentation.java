package com.foodie.portal.order.representation;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.model.OrderInfo;
import com.foodie.portal.order.model.OrderStatus;
import com.foodie.portal.order.model.RestaurantOrder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Accessors(chain = true)
public class RestaurantOrderSummaryRepresentation {
    private String id;
    private String number;
    private String restaurantTitle;
    private String restaurantImages;
    private String restaurantAddress;
    private String setMealName;
    private double totalPrice;
    protected double itemPrice;
    private String reserveDate;
    private int count;
    private OrderInfo orderInfo;
    private OrderStatus status;
    private String payNo;
    private Instant createdAt;

    public static RestaurantOrderSummaryRepresentation from(RestaurantOrder order){
        return RestaurantOrderRepresentationMapper.instance.from(order);
    }

    public static Pagination<RestaurantOrderSummaryRepresentation> from(Pagination<RestaurantOrder> orders) {
        return RestaurantOrderRepresentationMapper.instance.from(orders);
    }
}
