package com.foodie.portal.wallet.model;

import cn.hutool.core.util.NumberUtil;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.user.model.Merchant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class IncomeItem {
    private Merchant merchant;
    private Order order;
    private String name;
    private Double amount;
    private Instant createdAt;

    public IncomeItem(Merchant merchant, Order order) {
        this.merchant = merchant;
        this.order = order;
        this.createdAt = Instant.now();
        this.amount = NumberUtil.sub(order.getPrice(), order.getTotalExtract());
        this.name = "服务收入";
    }

    public static IncomeItem create(Merchant merchant, Order order) {
        return new IncomeItem(merchant, order);
    }
}
