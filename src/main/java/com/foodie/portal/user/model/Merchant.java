package com.foodie.portal.user.model;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import lombok.Data;

import java.math.BigDecimal;

import static com.foodie.portal.user.model.MerchantStatus.PASSED;

@Data
public class Merchant {

    private String id;
    private String name;
    private String password;
    private String email;
    private String city;
    private String description;
    private String activeDesc;
    private String images;
    private MerchantStatus status;
    private double extractRatio;

    public Merchant() {
        this.id = IdUtil.fastSimpleUUID();
        this.status = MerchantStatus.NON_APPROVE;
    }

    public Merchant(String name, String email, String city, String desc, String activeDesc, String images) {
        this();
        this.name = name;
        this.email = email;
        this.city = city;
        this.description = desc;
        this.activeDesc = activeDesc;
        this.images = images;
    }

    public static Merchant create(String name, String email, String city, String desc, String activeDesc, String images){
        return new Merchant(name, email, city, desc, activeDesc, images);
    }

    public void update(String name, String email, String city, String desc, String activeDescription, String images){
        this.name = name;
        this.email = email;
        this.city = city;
        this.description = desc;
        this.activeDesc = activeDescription;
        this.images = images;
    }

    public void pass(double extractRatio, String password) {
        this.extractRatio = extractRatio;
        this.password = password;
        this.status = PASSED;
    }

    public void reject() {
        if(status == PASSED) {
            throw new RestException(ErrorCode.FAILED.getCode(), "状态不能改变");
        }
        this.status = MerchantStatus.REJECTED;
    }


    public double getBenefitExtractRatio() {
        return NumberUtil.mul(extractRatio, 0.2);
    }
}
