package com.foodie.portal.wallet.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "foodie_merchant")
public class MerchantWalletEntity {
    @Id
    private String id;
    private String name;
    private Double extractRatio;
    //余额
    private Double balance;
    //未结算
    private Double openAccount;
    //累计收益
    private Double accumulatedEarnings;

}
