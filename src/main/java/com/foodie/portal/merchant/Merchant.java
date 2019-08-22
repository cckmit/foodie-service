package com.foodie.portal.merchant;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

@Data
public class Merchant {

    private String id;

    public Merchant() {
        this.id = IdUtil.fastSimpleUUID();
    }

}
