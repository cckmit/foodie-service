package com.foodie.portal.merchant;

import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Merchant {

    @ApiModelProperty(value = "ID")
    private String id;
    @ApiModelProperty(value = "商家名称")
    private String value;
    @ApiModelProperty(value = "商家邮箱")
    private String email;
    @ApiModelProperty(value = "商家城市")
    private String city;
    @ApiModelProperty(value = "商家描述")
    private String desc;
    @ApiModelProperty(value = "活动描述")
    private String activeDesc;
    @ApiModelProperty(value = "商家图片")
    private String images;

    public Merchant() {
        this.id = IdUtil.fastSimpleUUID();
    }

}
