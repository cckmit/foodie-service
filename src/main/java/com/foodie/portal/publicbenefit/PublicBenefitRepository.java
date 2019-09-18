package com.foodie.portal.publicbenefit;

import com.foodie.portal.publicbenefit.repository.PublicBenefitJpaRepository;
import com.foodie.portal.publicbenefit.repository.PublicBenefitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicBenefitRepository {

    @Autowired
    private PublicBenefitJpaRepository publicBenefitJpaRepository;
    private PublicBenefitMapper publicBenefitMapper = PublicBenefitMapper.INSTANCE;

    public void save(PublicBenefit publicBenefit) {
        publicBenefitJpaRepository.save(publicBenefitMapper.from(publicBenefit));
    }
}
