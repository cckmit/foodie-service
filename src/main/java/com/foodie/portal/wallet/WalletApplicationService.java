package com.foodie.portal.wallet;

import com.foodie.portal.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WalletApplicationService {

    @Autowired
    private MerchantWalletRepository repository;


    public void addMerchantOpenAccount(Order order) {
        var merchantWallet = repository.byId(order.getMerchant().getId());
        merchantWallet.increaseOpenAccount(order);
        repository.save(merchantWallet);
    }
}
