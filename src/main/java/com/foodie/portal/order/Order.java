package com.foodie.portal.order;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;
import com.foodie.portal.activity.Activity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

import static java.time.Instant.now;

@Data
@NoArgsConstructor
public class Order {
    private String id;
    private String number;
    private Activity activity;
    private int count;
    private BigDecimal price;
    private OrderStatus status;
    private Instant createdAt;

    public Order(Activity activity, int count, BigDecimal price) {
        this.id = IdUtil.fastSimpleUUID();
        this.number = IdUtil.objectId();
        this.activity = activity;
        this.count = count;
        this.price = price;
        this.status = OrderStatus.CREATED;
        this.createdAt = now();
    }

    public static Order create(Activity activity, int count, BigDecimal price) {
        return new Order(activity, count, price);
    }

}
