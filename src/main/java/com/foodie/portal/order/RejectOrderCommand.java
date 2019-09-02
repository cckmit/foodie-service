package com.foodie.portal.order;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class RejectOrderCommand {
    @NotNull(message = "原因不能为空")
    private BigDecimal reason;
}
