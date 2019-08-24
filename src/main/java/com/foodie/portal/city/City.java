package com.foodie.portal.city;

import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class City {

    @ApiModelProperty("城市ID")
    private String id;
    @ApiModelProperty("城市名称")
    private String name;
    @ApiModelProperty("城市描述")
    private String desc;
    @ApiModelProperty("城市图片")
    private String images;

    public City() {
        this.id = IdUtil.fastSimpleUUID();
    }
}
