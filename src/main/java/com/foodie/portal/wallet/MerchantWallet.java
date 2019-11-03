package com.foodie.portal.wallet;

import cn.hutool.core.util.NumberUtil;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.user.model.Merchant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
public class MerchantWallet {
    private Merchant merchant;
    private List<Order> orders;
    //余额
    private double balance;
    //未结算
    private double openAccount;
    //累计收益
    private double accumulatedEarnings;


    public void increaseBalance(Order order) {
        orders.add(order);
        double account = NumberUtil.sub(order.getPrice(), order.getTotalExtract());
        openAccount = NumberUtil.sub(openAccount, account);
        balance = NumberUtil.add(balance, account);
    }

    public void increaseOpenAccount(Order order) {
        double willOpenAccount = NumberUtil.sub(order.getPrice(), order.getTotalExtract());
        log.info("商家:{}, 增加未结算金额：{}" ,order.getMerchant().getId(), willOpenAccount);
        openAccount = NumberUtil.add(openAccount, willOpenAccount);
    }
}
