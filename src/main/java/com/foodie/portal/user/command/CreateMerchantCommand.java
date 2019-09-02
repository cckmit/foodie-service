package com.foodie.portal.user.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class CreateMerchantCommand {
    @ApiModelProperty(value = "商家名称")
    private String name;
    @ApiModelProperty(value = "商家邮箱")
    private String email;
    @ApiModelProperty(value = "商家城市")
    private String city;
    @ApiModelProperty(value = "商家描述")
    private String description;
    @ApiModelProperty(value = "活动描述")
    private String activeDesc;
    @ApiModelProperty(value = "商家图片")
    private String images;
}
