package com.foodie.portal.wallet.representation;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.wallet.repository.IncomeItemJpaRepository;
import com.foodie.portal.wallet.repository.WithdrawalItemJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class WalletRepresentationService {

    @Autowired
    private IncomeItemJpaRepository incomeItemJpaRepository;
    @Autowired
    private WithdrawalItemJpaRepository withdrawalItemJpaRepository;
    public Pagination<IncomeItemRepresentation> listServiceIncome(String merchantId, int page, int size) {
        return IncomeItemRepresentationMapper.INSTANCE.to(
                incomeItemJpaRepository.findAllByMerchantId(merchantId, PageRequest.of(page -1, size)));
    }

    public Pagination<WithdrawalRepresentation> listWithdrawal(String merchantId, int page, int size) {
        return WithdrawalItemRepresentationMapper.INSTANCE.to(
                withdrawalItemJpaRepository.findAllByMerchantId(merchantId, PageRequest.of(page -1, size)));

    }

}
