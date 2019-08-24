package com.foodie.portal.merchant;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

@Data
public class Merchant {

    private String id;
    private String name;
    private String email;
    private String city;
    private String desc;
    private String activeDesc;
    private String images;

    public Merchant() {
        this.id = IdUtil.fastSimpleUUID();
    }

}
