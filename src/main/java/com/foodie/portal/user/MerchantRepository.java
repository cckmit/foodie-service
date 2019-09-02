package com.foodie.portal.user;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.user.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class MerchantRepository {

    @Autowired
    private MerchantJpaRepository merchantJpaRepository;

    public void save(Merchant merchant) {
        merchantJpaRepository.save(MerchantEntityMapper.instance.from(merchant));
    }

    public Pagination<Merchant> findByPage(int page, int size) {
        return MerchantEntityMapper.instance.to(merchantJpaRepository.findAll(PageRequest.of(page, size)));
    }

    public Merchant findById(String id) {
        return MerchantEntityMapper.instance.to(merchantJpaRepository.getOne(id));
    }

    public void delete(String id) {
        merchantJpaRepository.deleteById(id);
    }

    public Pagination<Merchant> findNonApprovedMerchant(int page, int size) {
        return MerchantEntityMapper.instance.to(merchantJpaRepository.findByStatus(MerchantStatus.NON_APPROVE, PageRequest.of(page, size)));
    }

    public Merchant findByEmail(String email) {
        return MerchantEntityMapper.instance.to(merchantJpaRepository.findByEmail(email));
    }
}
