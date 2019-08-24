package com.foodie.portal.city;

import cn.hutool.core.util.IdUtil;
import lombok.Data;
import org.springframework.cloud.commons.util.IdUtils;

@Data
public class City {

    private String id;
    private String name;
    private String desc;
    private String images;

    public City() {
        this.id = IdUtil.fastSimpleUUID();
    }
}
