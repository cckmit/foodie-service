package com.foodie.portal.wallet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeItemJpaRepository extends JpaRepository<IncomeItemEntity, Long> {

    Page<IncomeItemEntity> findAllByMerchantId(String merchantId, Pageable pageable);
}
