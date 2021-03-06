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
import com.foodie.portal.commons.utils.IdGenerator;
import lombok.Data;

import java.time.Instant;
import java.util.Objects;

import static java.time.Instant.now;

@Data
public class Order {
    protected String id;
    protected String number;
    protected Activity activity;
    protected int count;
    private double price;
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
    }

    public Order(Activity activity, int count, String serviceDate, String startTime, OrderInfo orderInfo) {
        this();
        this.activity = activity;
        this.count = count;
        this.serviceDate = serviceDate;
        this.startTime = startTime;
        this.unitPrice = activity.getPrice(count);
        this.price = NumberUtil.mul(this.unitPrice, count);
        this.orderInfo = orderInfo;
        this.merchant = activity.getMerchant();
        this.totalExtract = NumberUtil.mul(price, merchant.getExtractRatio());
        this.benefitExtract = NumberUtil.mul(price, merchant.getBenefitExtractRatio());
    }

    public static Order create(Activity activity, int count, String serviceDate, String startTime, OrderInfo orderInfo) {
        if (Objects.isNull(activity)) {
            throw new RestException(ErrorCode.NO_RESULT_FOUND.getCode(), "???????????????");
        } else if (activity.getStatus() != ActivityStatus.PASSED) {
            throw new RestException(ErrorCode.NO_RESULT_FOUND.getCode(), "???????????????");
        }
        return new Order(activity, count, serviceDate, startTime, orderInfo);
    }

    public void prePay(double paidPrice) {
        if (paidPrice != price) {
            throw new RestException(ErrorCode.FAILED, "???????????????????????????????????????");
        }
    }

    public void pay() {
        this.status = OrderStatus.PAID;
    }


    public void accept(Merchant merchant) {
        checkOrder(merchant);
        if (status != OrderStatus.PAID) {
            throw new RestException(ErrorCode.FAILED, "???????????????");
        }
        generatePayNo();
        this.status = OrderStatus.ACCEPTED;
    }

    protected void generatePayNo() {
        this.payNo = RandomUtil.randomNumbers(6);
    }

    public void reject(String reason, Merchant merchant) {
        checkOrder(merchant);
        if (status != OrderStatus.PAID) {
            throw new RestException(ErrorCode.FAILED, "???????????????");
        }
        this.status = OrderStatus.REJECTED;
        this.rejectReason = reason;
    }

    public void startService(String payNo, Merchant merchant) {
        checkOrder(merchant);
        if (status != OrderStatus.ACCEPTED) {
            throw new RestException(ErrorCode.FAILED, "?????????????????????");
        }
        if (!payNo.equals(this.payNo)) {
            throw new RestException(ErrorCode.FAILED, "??????????????????");
        }
        this.status = OrderStatus.SERVICING;
    }

    private void checkOrder(Merchant merchant) {
        if (!this.activity.getMerchant().getId().equals(merchant.getId())) {
            throw new RestException(ErrorCode.FAILED, "??????????????????");
        }
    }

    public void cancel() {
        if(status != OrderStatus.CREATED) {
            throw new RestException(ErrorCode.FAILED, "????????????");
        }
        this.status = OrderStatus.CANCEL;
    }

    public void endService(Merchant merchant) {
        checkOrder(merchant);
        if (status != OrderStatus.SERVICING) {
            throw new RestException(ErrorCode.FAILED, "???????????????");
        }
        this.status = OrderStatus.FINISHED;
    }
}
