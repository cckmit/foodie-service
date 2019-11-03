package com.foodie.portal.wallet;

import com.foodie.portal.wallet.model.IncomeItem;
import com.foodie.portal.wallet.repository.IncomeItemEntityMapper;
import com.foodie.portal.wallet.repository.IncomeItemJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncomeRepository {

    @Autowired
    private IncomeItemJpaRepository incomeItemJpaRepository;

    public void save(IncomeItem incomeItem) {
        incomeItemJpaRepository.save(IncomeItemEntityMapper.INSTANCE.from(incomeItem));
    }
}
