package com.foodie.portal.user.repository;

import com.foodie.portal.user.model.MerchantStatus;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "foodie_merchant")
public class MerchantEntity {

    @Id
    private String id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String city;
    private String description;
    @Column(name = "activeDescription")
    private String activeDesc;
    private String images;
    @Enumerated(EnumType.STRING)
    private MerchantStatus status;
}
