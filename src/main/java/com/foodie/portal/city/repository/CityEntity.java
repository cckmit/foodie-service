package com.foodie.portal.city.repository;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "foodie_city")
public class CityEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private String introduction;
    private String images;
}
