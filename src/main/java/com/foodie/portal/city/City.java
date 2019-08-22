package com.foodie.portal.city;

import cn.hutool.core.util.IdUtil;
import lombok.Data;
import org.springframework.cloud.commons.util.IdUtils;

@Data
public class City {

    private String id;

    public City() {
        this.id = IdUtil.fastSimpleUUID() ;
    }
}
