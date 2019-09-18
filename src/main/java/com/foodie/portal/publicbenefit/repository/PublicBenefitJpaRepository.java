package com.foodie.portal.publicbenefit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicBenefitJpaRepository extends JpaRepository<PublicBenefitEntity, String> {
}
