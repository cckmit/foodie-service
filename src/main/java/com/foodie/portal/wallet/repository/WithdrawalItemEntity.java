package com.foodie.portal.wallet.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Table(name = "foodie_withdrawal_item")
public class WithdrawalItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String merchantId;
    private String name;
    private Double amount;
    private Instant createdAt;
}
