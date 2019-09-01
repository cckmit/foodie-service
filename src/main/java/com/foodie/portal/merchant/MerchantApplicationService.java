package com.foodie.portal.merchant;

import com.foodie.portal.commons.Pagination;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantApplicationService {

    @Autowired
    private MerchantRepository merchantRepository;

    public Pagination<Merchant> merchants(int page, int size) {
        return merchantRepository.findByPage(page - 1, size);
    }

    public void addMerchant(Merchant merchantCommand) {
        var merchant = Merchant.create(merchantCommand.getName(), merchantCommand.getEmail(), merchantCommand.getCity(),
                merchantCommand.getDescription(), merchantCommand.getActiveDesc(), merchantCommand.getImages());
        merchantRepository.save(merchant);
    }

    public Merchant detail(String id) {
        return merchantRepository.findById(id);
    }

    public Merchant updateMerchant(String id, Merchant merchantCommand) {
        merchantCommand.setId(id);
        merchantRepository.save(merchantCommand);
        return merchantCommand;
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
}
