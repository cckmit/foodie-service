package com.foodie.portal.publicbenefit;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import com.foodie.portal.order.Order;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
public class PublicBenefit {

    private String id;
    private String title;
    private String image;
    private String description;
    private String content;
    private double totalFoundation;
    private double currentFoundation;
    private List<Order> orders;
    private PublicBenefitStatus status;
    private Instant createdAt;


    public PublicBenefit(String title, String image, String description, String content, double totalFoundation) {
        this.id = IdUtil.fastSimpleUUID();
        this.title = title;
        this.image = image;
        this.description = description;
        this.content = content;
        this.totalFoundation = totalFoundation;
        this.currentFoundation = 0;
        this.orders = Lists.newArrayList();
        this.status = PublicBenefitStatus.CREATED;
    }

    public static PublicBenefit create(String title, String image, String description, String content, double totalFoundation) {
        return new PublicBenefit(title, image, description, content, totalFoundation);
    }

    public void extract(Order order) {
        this.orders.add(order);
        this.currentFoundation = NumberUtil.add(currentFoundation,order.getBenefitExtract());
    }


    public void update(String title, String image, String description, String content, double totalFoundation) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.content = content;
        this.totalFoundation = totalFoundation;
    }

    public void activate() {
        this.status = PublicBenefitStatus.ACTIVATED;
    }

    public void pending() {
        this.status = PublicBenefitStatus.PENDING;
    }
}
