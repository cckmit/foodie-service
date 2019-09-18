package com.foodie.portal.publicbenefit.repository;

import com.foodie.portal.order.Order;
import com.foodie.portal.order.repository.OrderEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "foodie_public_benefit")
public class PublicBenefitEntity {
    @Id
    private String id;
    private String title;
    private String content;
    private BigDecimal totalFoundation;
    private BigDecimal currentFoundation;
    @OneToMany
    @JoinColumn(name = "public_benefit_id")
    private List<OrderEntity> orders;
    private Instant createdAt;
}
