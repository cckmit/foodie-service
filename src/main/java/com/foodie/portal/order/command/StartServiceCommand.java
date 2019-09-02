package com.foodie.portal.order.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StartServiceCommand {
    @NotBlank(message = "服务码不能为空")
    private String payNo;
}
