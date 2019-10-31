package com.foodie.portal.order.model;

import cn.hutool.core.util.NumberUtil;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.restaurant.model.Restaurant;
import com.foodie.portal.user.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestaurantOrder extends Order {

    private Restaurant restaurant;
    private String setMealName;
    private double totalPrice;
    protected double itemPrice;
    private String reserveDate;
    private int count;

    public RestaurantOrder(Restaurant restaurant, String setMealName, int count, String reserveDate, OrderInfo orderInfo, User user) {
        super();
        this.restaurant = restaurant;
        this.count = count;
        this.setMealName = setMealName;
        this.itemPrice = restaurant.getSetMeals().stream()
                .filter(setMeal -> setMeal.getName().equals(setMealName))
                .findFirst()
                .orElseThrow(() -> new RestException(ErrorCode.FAILED, "没有这个套餐"))
                .getPrice();
        this.totalPrice = NumberUtil.mul(this.itemPrice, count);
        this.reserveDate = reserveDate;
        this.orderInfo = orderInfo;
        this.user = user;
    }

    public static RestaurantOrder create(Restaurant restaurant, String setMealName, int count, String reserveDate, OrderInfo orderInfo, User user) {
        return new RestaurantOrder(restaurant, setMealName, count, reserveDate, orderInfo, user);
    }

    public void prePay(double paidPrice) {
        if (paidPrice != totalPrice) {
            throw new RestException(ErrorCode.FAILED, "支付价格与订单实际价格不符");
        }
    }
}
