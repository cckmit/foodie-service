package com.foodie.portal.publicbenefit.repository;

import com.foodie.portal.publicbenefit.PublicBenefitStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicBenefitJpaRepository extends JpaRepository<PublicBenefitEntity, String> {

    List<PublicBenefitEntity> findByStatus(PublicBenefitStatus status);
}
