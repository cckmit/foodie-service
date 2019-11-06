package com.foodie.portal.wallet;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.wallet.command.UpdateWithdrawInfoCommand;
import com.foodie.portal.wallet.model.IncomeItem;
import com.foodie.portal.wallet.model.WithdrawalItem;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class WalletApplicationService {

    @Autowired
    private MerchantWalletRepository walletRepository;
    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private WithdrawalRepository withdrawalRepository;

    public Pagination<MerchantWallet> list(int page, int size) {
        return walletRepository.findAll(page - 1 , size);
    }


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

    @Transactional
    public synchronized void withdraw(String merchantId, double amount) {
        var merchantWallet = walletRepository.byId(merchantId);
        merchantWallet.withdraw(amount);
        walletRepository.save(merchantWallet);
        //保存提现明细
        WithdrawalItem withdrawalItem = WithdrawalItem.create(merchantId, amount);
        withdrawalRepository.save(withdrawalItem);
    }

    public void updateWithdrawInfo(String id, UpdateWithdrawInfoCommand command) {
        var merchantWallet = walletRepository.byId(id);
        merchantWallet.updateWithdrawInfo(command.getAccount(), command.getName());
        walletRepository.save(merchantWallet);
    }
}
