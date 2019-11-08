package com.foodie.portal.wallet.model;

import cn.hutool.core.util.NumberUtil;
import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.order.model.Order;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class MerchantWallet {
    private String id;
    private String name;
    //余额
    private double balance;
    //未结算
    private double openAccount;
    //累计收益
    private double accumulatedEarnings;
    private String withdrawAccount;
    private String withdrawName;


    public void increaseBalance(Order order) {
        double account = NumberUtil.sub(order.getPrice(), order.getTotalExtract());
        openAccount = NumberUtil.sub(openAccount, account);
        balance = NumberUtil.add(balance, account);
        accumulatedEarnings = NumberUtil.add(accumulatedEarnings, account);
    }

    public void increaseOpenAccount(Order order) {
        double willOpenAccount = NumberUtil.sub(order.getPrice(), order.getTotalExtract());
        log.info("商家:{}, 增加未结算金额：{}", order.getMerchant().getId(), willOpenAccount);
        openAccount = NumberUtil.add(openAccount, willOpenAccount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new RestException(ErrorCode.FAILED, "余额不足");
        }
        balance = NumberUtil.sub(balance, amount);
        log.info("商家:{}, 提现：{}", id, amount);
    }

    public void updateWithdrawInfo(String account, String name) {
        this.withdrawAccount = account;
        this.withdrawName = name;
    }
}
