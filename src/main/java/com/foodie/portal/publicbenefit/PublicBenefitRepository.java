package com.foodie.portal.publicbenefit;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.publicbenefit.repository.PublicBenefitJpaRepository;
import com.foodie.portal.publicbenefit.repository.PublicBenefitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class PublicBenefitRepository {

    @Autowired
    private PublicBenefitJpaRepository publicBenefitJpaRepository;
    private PublicBenefitMapper publicBenefitMapper = PublicBenefitMapper.INSTANCE;

    public void save(PublicBenefit publicBenefit) {
        publicBenefitJpaRepository.save(publicBenefitMapper.from(publicBenefit));
    }

    public Pagination<PublicBenefit> findAll(int page, int size) {
        return publicBenefitMapper.to(publicBenefitJpaRepository.findAll(PageRequest.of(page, size)));
    }

    public PublicBenefit byId(String id) {
        return publicBenefitMapper.to(publicBenefitJpaRepository.findById(id).orElse(null));
    }
}
