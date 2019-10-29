package com.foodie.portal.order.model;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
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

import java.time.Instant;
import java.util.Objects;

import static java.time.Instant.now;

@Data
public class Order {
    protected String id;
    protected String number;
    protected Activity activity;
    protected int count;
    protected double price;
    protected double unitPrice;
    protected String serviceDate;
    protected String startTime;
    protected OrderInfo orderInfo;
    protected User user;
    protected OrderStatus status;
    protected String payNo;
    protected String rejectReason;
    protected Merchant merchant;
    protected double totalExtract;
    protected double benefitExtract;
    protected String paymentId;
    protected Instant createdAt;

    public Order() {
        this.id = IdUtil.fastSimpleUUID();
        this.number = IdGenerator.getTimeId();
        this.status = OrderStatus.CREATED;
        this.createdAt = now();
        this.payNo = RandomUtil.randomNumbers(6);
    }

    public Order(Activity activity, int count, String serviceDate, String startTime, OrderInfo orderInfo) {
        this();
        this.activity = activity;
        this.count = count;
        this.serviceDate = serviceDate;
        this.startTime = startTime;
        this.unitPrice = activity.getPrice(count);
        this.price = NumberUtil.mul(activity.getPrice(count), count);
        this.orderInfo = orderInfo;
        this.merchant = activity.getMerchant();
        this.totalExtract = NumberUtil.mul(price, merchant.getExtractRatio());
        this.benefitExtract = NumberUtil.mul(price, merchant.getBenefitExtractRatio());
    }

    public static Order create(Activity activity, int count, String serviceDate, String startTime, OrderInfo orderInfo) {
        if (Objects.isNull(activity)) {
            throw new RestException(ErrorCode.NO_RESULT_FOUND.getCode(), "活动不存在");
        } else if (activity.getStatus() != ActivityStatus.PASSED) {
            throw new RestException(ErrorCode.NO_RESULT_FOUND.getCode(), "活动未审核");
        }
        return new Order(activity, count, serviceDate, startTime, orderInfo);
    }

    public void prePay(double paidPrice) {
        if (paidPrice != price) {
            throw new RestException(ErrorCode.FAILED, "支付价格与订单实际价格不符");
        }
    }

    public void pay() {
        this.status = OrderStatus.PAID;
    }


    public void accept(Merchant merchant) {
        checkOrder(merchant);
        if (status != OrderStatus.PAID) {
            throw new RestException(ErrorCode.FAILED, "订单未支付");
        }
        this.status = OrderStatus.ACCEPTED;
    }

    public void reject(String reason, Merchant merchant) {
        checkOrder(merchant);
        if (status != OrderStatus.PAID) {
            throw new RestException(ErrorCode.FAILED, "订单未支付");
        }
        this.status = OrderStatus.REJECTED;
        this.rejectReason = reason;
    }

    public void startService(String payNo, Merchant merchant) {
        checkOrder(merchant);
        if (status != OrderStatus.ACCEPTED) {
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

    public void cancel() {
        if(status == OrderStatus.CREATED) {
            this.status = OrderStatus.CANCEL;
        }
       throw new RestException(ErrorCode.FAILED, "状态异常");
    }
}
