package com.foodie.portal.city;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateCityCommand {

    @ApiModelProperty("城市名称")
    private String name;
    @ApiModelProperty("城市描述")
    private String desc;
    @ApiModelProperty("城市图片")
    private String images;
}
