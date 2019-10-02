package com.foodie.portal.activity.command;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class AdminCreateActivityCommand extends CreateActivityCommand {

    @NotNull(message = "商家Id不能为空")
    private String merchantId;
}
