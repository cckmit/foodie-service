package com.foodie.portal.user;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.MerchantStatus;
import com.foodie.portal.user.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MerchantRepository {

    private final MerchantEntityMapper merchantEntityMapper = MerchantEntityMapper.instance;
    @Autowired
    private MerchantJpaRepository merchantJpaRepository;

    public void save(Merchant merchant) {
        merchantJpaRepository.save(merchantEntityMapper.from(merchant));
    }

    public Pagination<Merchant> findByPage(int page, int size) {
        return merchantEntityMapper.to(merchantJpaRepository.findAll(PageRequest.of(page, size)));
    }

    public Merchant findById(String id) {
        return merchantEntityMapper.to(merchantJpaRepository.getOne(id));
    }

    public void delete(String id) {
        merchantJpaRepository.deleteById(id);
    }

    public Pagination<Merchant> findNonApprovedMerchant(int page, int size) {
        return merchantEntityMapper.to(merchantJpaRepository.findByStatus(MerchantStatus.NON_APPROVE, PageRequest.of(page, size)));
    }

    public Merchant findByEmail(String email) {
        return merchantEntityMapper.to(merchantJpaRepository.findByEmail(email));
    }

    public List<Merchant> findAll() {
        return merchantEntityMapper.to(merchantJpaRepository.findAll());
    }
}
