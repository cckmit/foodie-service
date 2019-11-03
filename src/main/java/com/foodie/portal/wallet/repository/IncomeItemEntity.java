package com.foodie.portal.wallet.repository;

import com.foodie.portal.order.repository.OrderEntity;
import com.foodie.portal.user.repository.MerchantEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Table(name = "foodie_income_item")
public class IncomeItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private MerchantEntity merchant;
    private String name;
    @ManyToOne
    private OrderEntity order;
    private Double amount;
    private Instant createdAt;
}
