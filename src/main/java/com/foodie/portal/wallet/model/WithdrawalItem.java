package com.foodie.portal.wallet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class WithdrawalItem {
    private Long id;
    private String merchantId;
    private String name;
    private Double amount;
    private Instant createdAt;

    public WithdrawalItem(String merchantId, double amount) {
        this.merchantId = merchantId;
        this.createdAt = Instant.now();
        this.amount = amount;
        this.name = "管理员手动提现";
    }

    public static WithdrawalItem create(String merchantId, double amount) {
        return new WithdrawalItem(merchantId, amount);
    }
}
