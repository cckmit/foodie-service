package com.foodie.portal.order;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.foodie.portal.activity.Activity;
import com.foodie.portal.activity.ActivityStatus;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

import static java.time.Instant.now;

@Data
@NoArgsConstructor
public class Order {
    private String id;
    private String number;
    private Activity activity;
    private int count;
    private BigDecimal price;
    private User user;
    private OrderStatus status;
    private String payNo;
    private String rejectReason;
    private Merchant merchant;
    private Instant createdAt;

    public Order(Activity activity, int count) {
        this.id = IdUtil.fastSimpleUUID();
        this.number = IdUtil.objectId();
        this.activity = activity;
        this.count = count;
        this.price = activity.getPrice(count);
        this.status = OrderStatus.CREATED;
        this.payNo = RandomUtil.randomNumbers(6);
        this.merchant = activity.getMerchant();
        this.createdAt = now();
    }

    public static Order create(Activity activity, int count) {
        if (Objects.isNull(activity)) {
            throw new RestException(ErrorCode.NO_RESULT_FOUND.getCode(), "活动不存在");
        }else if(activity.getStatus() != ActivityStatus.PASSED) {
            throw new RestException(ErrorCode.NO_RESULT_FOUND.getCode(), "活动未审核");
        }
        return new Order(activity, count);
    }

    public void pay(BigDecimal paidPrice) {
        if(!paidPrice.equals(calculateTotalPrice())) {
            throw new RestException(ErrorCode.FAILED, "支付价格与订单实际价格不符");
        }
        this.status = OrderStatus.PAID;
    }

    private BigDecimal calculateTotalPrice() {
        return price.multiply(BigDecimal.valueOf(count));
    }

    public void accept(Merchant merchant) {
        checkOrder(merchant);
        this.status = OrderStatus.ACCEPTED;
    }

    public void reject(String reason, Merchant merchant) {
        checkOrder(merchant);
        this.status = OrderStatus.REJECTED;
        this.rejectReason = reason;
    }

    public void startService(String payNo, Merchant merchant) {
        checkOrder(merchant);
        if (!payNo.equals(this.payNo)) {
            throw new RestException(ErrorCode.FAILED, "消费码不正确");
        }
        this.status = OrderStatus.SERVICING;
    }

    private void checkOrder(Merchant merchant) {
        if (!this.activity.getMerchant().getId().equals(merchant.getId())) {
            throw new RestException(ErrorCode.FAILED, "非本商家订单");
        }
    }
}
