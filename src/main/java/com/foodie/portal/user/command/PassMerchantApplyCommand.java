package com.foodie.portal.user.command;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Data
public class PassMerchantApplyCommand {

    @Min(value = 0, message = "不能小于0")
    @Max(value = 1, message = "不能大于1")
    private double extractRatio;
}
