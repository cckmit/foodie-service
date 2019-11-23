package com.foodie.portal.city;

import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class City {

    private String id;
    private String name;
    private String description;
    private String introduction;
    private String images;
    private boolean showOnActivity;
    private boolean showOnRestaurant;

    public City() {
        this.id = IdUtil.fastSimpleUUID();
    }

    public City(String name, String desc, String introduction, String images) {
        this.id = IdUtil.fastSimpleUUID();
        this.name = name;
        this.introduction = introduction;
        this.description = desc;
        this.images = images;
        this.showOnActivity = true;
        this.showOnRestaurant = true;
    }

    public static City create(String name, String desc,String introduction, String images) {
        return new City(name, desc, introduction, images);
    }
}
