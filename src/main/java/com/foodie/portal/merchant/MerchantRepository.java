package com.foodie.portal.merchant;

import com.foodie.portal.merchant.repository.MerchantEntityMapper;
import com.foodie.portal.merchant.repository.MerchantJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MerchantRepository {

    @Autowired
    private MerchantJpaRepository merchantJpaRepository;

    public void save(Merchant merchant) {
        merchantJpaRepository.save(MerchantEntityMapper.instance.from(merchant));
    }

}
