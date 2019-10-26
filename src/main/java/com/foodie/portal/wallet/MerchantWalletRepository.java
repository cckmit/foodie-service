package com.foodie.portal.wallet;

import com.foodie.portal.wallet.repository.MerchantWalletEntityMapper;
import com.foodie.portal.wallet.repository.MerchantWalletJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MerchantWalletRepository {

    @Autowired
    private MerchantWalletJpaRepository repository;

    public MerchantWallet byId(String id) {
        return repository.findById(id)
                .map(MerchantWalletEntityMapper.INSTANCE::to)
                .orElse(null);

    }

    public void save(MerchantWallet merchantWallet) {
        repository.save(MerchantWalletEntityMapper.INSTANCE.from(merchantWallet));
    }
}
