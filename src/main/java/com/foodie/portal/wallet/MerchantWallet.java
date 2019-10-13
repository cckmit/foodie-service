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
    private double balance;

    public void increase(Order order) {
        orders.add(order);
        balance = NumberUtil.add(balance, NumberUtil.mul(order.getPrice(),1 - merchant.getExtractRatio()));
    }
}
