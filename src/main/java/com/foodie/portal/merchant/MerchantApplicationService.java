package com.foodie.portal.merchant;

import com.foodie.portal.commons.Pagination;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantApplicationService {

    @Autowired
    private MerchantRepository merchantRepository;

    public Pagination<Merchant> merchants(int page, int size) {
        return merchantRepository.findByPage(page - 1, size);
    }

    public void addMerchant(CreateMerchantCommand merchantCommand) {
        var merchant = Merchant.create(merchantCommand.getName(), merchantCommand.getEmail(), merchantCommand.getCity(),
                merchantCommand.getDescription(), merchantCommand.getActiveDesc(), merchantCommand.getImages());
        merchantRepository.save(merchant);
    }

    public Merchant detail(String id) {
        return merchantRepository.findById(id);
    }

    public Merchant updateMerchant(String id, CreateMerchantCommand merchantCommand) {
        var merchant = merchantRepository.findById(id);
        merchant.update(merchantCommand.getName(), merchantCommand.getEmail(), merchantCommand.getCity(),
                merchantCommand.getDescription(), merchantCommand.getCity(), merchantCommand.getImages());
        merchantRepository.save(merchant);
        return merchant;
    }

    public void deleteMerchant(String id) {
        merchantRepository.delete(id);
    }

    public void pass(String id) {
        Merchant merchant = merchantRepository.findById(id);
        merchant.pass();
        merchantRepository.save(merchant);
    }

    public void reject(String id) {
        Merchant merchant = merchantRepository.findById(id);
        merchant.reject();
        merchantRepository.save(merchant);
    }

    public Pagination<Merchant> waitForApprovedMerchant(int page , int size) {
        return merchantRepository.findNonApprovedMerchant(page - 1, size);
    }
}
