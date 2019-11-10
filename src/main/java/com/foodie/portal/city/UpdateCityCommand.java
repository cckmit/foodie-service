package com.foodie.portal.city;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateCityCommand {
    private String images;
    @ApiModelProperty("城市简介")
    private String description;
    @ApiModelProperty("城市描述")
    private String introduction;
    private boolean showOnActivity;
    private boolean showOnRestaurant;
}
