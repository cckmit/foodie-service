package com.foodie.portal.wallet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalItemJpaRepository extends JpaRepository<WithdrawalItemEntity, Long> {

    Page<WithdrawalItemEntity> findAllByMerchantId(String merchantId, Pageable pageable);
}
