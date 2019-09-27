package com.foodie.portal.order;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.User;
import com.foodie.portal.utils.IdGenerator;
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
    private OrderInfo orderInfo;
    private User user;
    private OrderStatus status;
    private String payNo;
    private String rejectReason;
    private Merchant merchant;
    private double extractRatio;
    private BigDecimal benefitExtractRatio;
    private String paymentId;
    private Instant createdAt;

    public Order(Activity activity, int count, OrderInfo orderInfo) {
        this.id = IdUtil.fastSimpleUUID();
        this.number = IdGenerator.getTimeId();
        this.activity = activity;
        this.count = count;
        this.price = activity.getPrice(count);
        this.status = OrderStatus.CREATED;
        this.payNo = RandomUtil.randomNumbers(6);
        this.orderInfo = orderInfo;
        this.merchant = activity.getMerchant();
        this.extractRatio = merchant.getExtractRatio();
        this.benefitExtractRatio = merchant.getBenefitExtractRatio();
        this.createdAt = now();
    }

    public static Order create(Activity activity, int count, OrderInfo orderInfo) {
        if (Objects.isNull(activity)) {
            throw new RestException(ErrorCode.NO_RESULT_FOUND.getCode(), "活动不存在");
        }else if(activity.getStatus() != ActivityStatus.PASSED) {
            throw new RestException(ErrorCode.NO_RESULT_FOUND.getCode(), "活动未审核");
        }
        return new Order(activity, count, orderInfo);
    }

    public void prePay(BigDecimal paidPrice) {
        if(!paidPrice.equals(calculateTotalPrice())) {
            throw new RestException(ErrorCode.FAILED, "支付价格与订单实际价格不符");
        }
    }

    public void pay() {
       this.status = OrderStatus.PAID;
    }

    private BigDecimal calculateTotalPrice() {
        return price.multiply(BigDecimal.valueOf(count));
    }

    public void accept(Merchant merchant) {
        checkOrder(merchant);
        if(status != OrderStatus.PAID) {
            throw new RestException(ErrorCode.FAILED, "订单未支付");
        }
        this.status = OrderStatus.ACCEPTED;
    }

    public void reject(String reason, Merchant merchant) {
        checkOrder(merchant);
        if(status != OrderStatus.PAID) {
            throw new RestException(ErrorCode.FAILED, "订单未支付");
        }
        this.status = OrderStatus.REJECTED;
        this.rejectReason = reason;
    }

    public void startService(String payNo, Merchant merchant) {
        checkOrder(merchant);
        if(status != OrderStatus.ACCEPTED) {
            throw new RestException(ErrorCode.FAILED, "订单未通过审核");
        }
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
