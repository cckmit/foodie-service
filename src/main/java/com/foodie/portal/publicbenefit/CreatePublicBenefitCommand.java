package com.foodie.portal.publicbenefit;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.order.Order;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
public class CreatePublicBenefitCommand {

    private String title;
    private String content;
    private BigDecimal totalFoundation;
}
