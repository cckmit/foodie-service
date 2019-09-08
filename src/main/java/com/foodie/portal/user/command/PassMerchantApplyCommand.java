package com.foodie.portal.user.command;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PassMerchantApplyCommand {

    private BigDecimal extractRatio;
}
