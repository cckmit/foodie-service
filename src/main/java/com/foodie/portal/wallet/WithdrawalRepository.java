package com.foodie.portal.wallet;

import com.foodie.portal.wallet.model.IncomeItem;
import com.foodie.portal.wallet.model.WithdrawalItem;
import com.foodie.portal.wallet.repository.IncomeItemEntityMapper;
import com.foodie.portal.wallet.repository.IncomeItemJpaRepository;
import com.foodie.portal.wallet.repository.WithdrawalItemEntityMapper;
import com.foodie.portal.wallet.repository.WithdrawalItemJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WithdrawalRepository {

    @Autowired
    private WithdrawalItemJpaRepository withdrawalItemJpaRepository;

    public void save(WithdrawalItem withdrawalItem) {
        withdrawalItemJpaRepository.save(WithdrawalItemEntityMapper.INSTANCE.from(withdrawalItem));
    }
}
