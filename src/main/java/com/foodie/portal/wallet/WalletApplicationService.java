package com.foodie.portal.wallet;

import com.foodie.portal.order.model.Order;
import com.foodie.portal.wallet.model.IncomeItem;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class WalletApplicationService {

    @Autowired
    private MerchantWalletRepository walletRepository;
    @Autowired
    private IncomeRepository incomeRepository;


    public synchronized void addMerchantOpenAccount(Order order) {
        var merchantWallet = walletRepository.byId(order.getMerchant().getId());
        merchantWallet.increaseOpenAccount(order);
        walletRepository.save(merchantWallet);
    }

    @Transactional
    public synchronized void addMerchantBalance(Order order) {
        var merchantWallet = walletRepository.byId(order.getMerchant().getId());
        merchantWallet.increaseBalance(order);
        walletRepository.save(merchantWallet);
        //保存收入记录
        IncomeItem incomeItem = IncomeItem.create(order.getMerchant(), order);
        incomeRepository.save(incomeItem);
    }
}
