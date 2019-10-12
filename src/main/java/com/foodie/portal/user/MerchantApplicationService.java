package com.foodie.portal.user;

import cn.hutool.core.util.RandomUtil;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.commons.event.MerchantApplyPassedEvent;
import com.foodie.portal.user.command.CreateMerchantCommand;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.web.command.ApplyMerchantCommand;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MerchantApplicationService {

    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private ApplicationContext applicationContext;

    public Pagination<Merchant> merchants(int page, int size) {
        return merchantRepository.findByPage(page - 1, size);
    }

    public void addMerchant(CreateMerchantCommand merchantCommand) {
        var merchant = Merchant.create(merchantCommand.getName(), merchantCommand.getEmail(), merchantCommand.getCity(),
                merchantCommand.getDescription(), merchantCommand.getActiveDesc(), merchantCommand.getImages());
        merchantRepository.save(merchant);
    }

    public Merchant findById(String id) {
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

    public void pass(String id, double extractRatio) {
        Merchant merchant = merchantRepository.findById(id);
        merchant.pass(extractRatio);
        String password = RandomUtil.randomString(10);
        merchant.setPassword(password);
        applicationContext.publishEvent(new MerchantApplyPassedEvent(merchant));
        merchantRepository.save(merchant);
    }

    public void reject(String id) {
        Merchant merchant = merchantRepository.findById(id);
        merchant.reject();
        merchantRepository.save(merchant);
    }

    public Pagination<Merchant> waitForApprovedMerchant(int page, int size) {
        return merchantRepository.findNonApprovedMerchant(page - 1, size);
    }

    public Merchant findByEmail(String email) {
        return merchantRepository.findByEmail(email);
    }

    public void changePassword(Merchant merchant, String password) {
        var merchantInDb = merchantRepository.findById(merchant.getId());
        merchantInDb.setPassword(password);
        merchantRepository.save(merchantInDb);
    }

    public void applyMerchant(ApplyMerchantCommand merchantCommand) {
        var merchant = Merchant.create(merchantCommand.getName(), merchantCommand.getEmail(), merchantCommand.getCity(),
                merchantCommand.getDescription(), merchantCommand.getActiveDesc(), merchantCommand.getImages());
        merchantRepository.save(merchant);
    }
}
