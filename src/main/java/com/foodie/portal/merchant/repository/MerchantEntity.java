package com.foodie.portal.merchant.repository;

import com.foodie.portal.merchant.MerchantStatus;
import io.swagger.annotations.ApiModelProperty;
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
    private String email;
    private String city;
    private String description;
    @Column(name = "activeDescription")
    private String activeDesc;
    private String images;
    @Enumerated(EnumType.STRING)
    private MerchantStatus status;
}
