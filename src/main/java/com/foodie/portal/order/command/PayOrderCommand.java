package com.foodie.portal.order.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class PayOrderCommand {
    @NotNull(message = "支付金额不能为空")
    private BigDecimal paidPrice;
}
