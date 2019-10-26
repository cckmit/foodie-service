package com.foodie.portal.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantWalletJpaRepository extends JpaRepository<MerchantWalletEntity, String> {
}
