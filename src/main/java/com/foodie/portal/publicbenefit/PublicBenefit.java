package com.foodie.portal.publicbenefit;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.order.Order;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class PublicBenefit {

    private String id;
    private String title;
    private String content;
    private BigDecimal extractRatio;
    private BigDecimal totalFoundation;
    private BigDecimal currentFoundation;
    private List<Order> orders;


    public PublicBenefit(String title, String content, BigDecimal extractRatio,
                         BigDecimal totalFoundation) {
        this.id = IdUtil.fastSimpleUUID();
        this.title = title;
        this.content = content;
        this.extractRatio = extractRatio;
        this.totalFoundation = totalFoundation;
        this.currentFoundation = BigDecimal.ZERO;
        this.orders = Lists.newArrayList();
    }

    public static PublicBenefit create(String title, String content, BigDecimal extractRatio,
                                       BigDecimal totalFoundation) {
        return new PublicBenefit(title, content, extractRatio, totalFoundation);
    }

    public void extract(Order order) {
        this.orders.add(order);
        this.currentFoundation = currentFoundation.add(extractRatio.multiply(order.getPrice()));
    }

}
