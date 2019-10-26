package com.foodie.portal.wallet;

import cn.hutool.core.util.NumberUtil;
import com.foodie.portal.order.Order;
import com.foodie.portal.user.model.Merchant;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MerchantWallet {
    private Merchant merchant;
    private List<Order> orders;
    //余额
    private double balance;
    //未结算
    private double openAccount;
    //累计收益
    private double accumulatedEarnings;


    public void increase(Order order) {
        orders.add(order);
        balance = NumberUtil.add(balance, NumberUtil.mul(order.getPrice(),1 - merchant.getExtractRatio()));
    }
}
