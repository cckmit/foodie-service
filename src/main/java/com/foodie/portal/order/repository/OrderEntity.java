package com.foodie.portal.order.repository;

import com.foodie.portal.activity.repository.ActivityEntity;
import com.foodie.portal.order.OrderStatus;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.repository.MerchantEntity;
import com.foodie.portal.user.repository.UserEntity;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "foodie_order")
public class OrderEntity {
    @Id
    private String id;
    private String number;
    @ManyToOne
    private ActivityEntity activity;
    private int count;
    private BigDecimal price;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private UserEntity user;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String payNo;
    private String rejectReason;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private MerchantEntity merchant;
    private Instant createdAt;

}
