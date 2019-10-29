package com.foodie.portal.user.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserLoginCommand {

    @ApiModelProperty(example = "445999306@qq.com")
    private String email;
    @ApiModelProperty(example = "123456")
    private String password;
}
