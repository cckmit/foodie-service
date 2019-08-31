package com.foodie.portal.merchant;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

@Data
public class Merchant {

    private String id;
    private String name;
    private String email;
    private String city;
    private String description;
    private String activeDesc;
    private String images;

    public Merchant() {
        this.id = IdUtil.fastSimpleUUID();
    }

    public Merchant(String name, String email, String city, String desc, String activeDesc, String images) {
        this();
        this.name = name;
        this.email = email;
        this.city = city;
        this.description = desc;
        this.activeDesc = activeDesc;
        this.images = images;
    }

    public static Merchant create(String name, String email, String city, String desc, String activeDesc, String images){
        return new Merchant(name, email, city, desc, activeDesc, images);
    }

}
