package com.foodie.portal.city;

import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class City {

    private String id;
    private String name;
    private String description;
    private String images;

    public City() {
        this.id = IdUtil.fastSimpleUUID();
    }

    public City(String name, String desc, String images) {
        this.id = IdUtil.fastSimpleUUID();
        this.name = name;
        this.description = desc;
        this.images = images;
    }

    public static City create(String name, String desc, String images) {
        return new City(name, desc, images);
    }
}
