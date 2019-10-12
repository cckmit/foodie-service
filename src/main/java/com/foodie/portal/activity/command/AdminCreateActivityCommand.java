package com.foodie.portal.activity.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AdminCreateActivityCommand extends CreateActivityCommand {
    @NotBlank(message = "商户ID不能为空")
    private String merchantId;
}
