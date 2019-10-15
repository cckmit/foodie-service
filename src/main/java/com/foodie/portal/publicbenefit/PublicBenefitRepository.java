package com.foodie.portal.publicbenefit;

import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.publicbenefit.repository.PublicBenefitEntity;
import com.foodie.portal.publicbenefit.repository.PublicBenefitJpaRepository;
import com.foodie.portal.publicbenefit.repository.PublicBenefitMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
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

    public PublicBenefit findActivated() {
        List<PublicBenefitEntity> publicBenefits = publicBenefitJpaRepository.findByStatus(PublicBenefitStatus.ACTIVATED);
        if (publicBenefits.size() != 1) {
            log.error("激活公益只能有1个，实际有{}个; content: {}", publicBenefits.size(), publicBenefits);
            throw new RestException(ErrorCode.REFUSED, "激活公益不对");
        }
        return publicBenefitMapper.to(publicBenefits.get(0));
    }
}
