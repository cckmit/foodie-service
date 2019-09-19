package com.foodie.portal.wallet;

import com.foodie.portal.order.Order;
import com.foodie.portal.user.model.Merchant;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MerchantWallet {
    private Merchant merchant;
    private List<Order> orders;
    private BigDecimal balance;

    public void increase(Order order) {
        orders.add(order);
        balance = balance.add(order.getPrice().multiply(BigDecimal.valueOf(1 - merchant.getExtractRatio())));
    }
}
