package com.foodie.portal.merchant.repository;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
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
    private String activeDescription;
    private String images;
}
