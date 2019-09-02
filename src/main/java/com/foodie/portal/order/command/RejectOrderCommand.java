package com.foodie.portal.order.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class RejectOrderCommand {
    @NotNull(message = "原因不能为空")
    private String reason;
}
