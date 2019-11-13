package com.foodie.portal.favourite.repository;

import com.foodie.portal.favourite.FavouriteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface FavouriteJpaRepository extends JpaRepository<FavouriteEntity, Long> {

    FavouriteEntity findByObjectIdAndTypeAndUserId(String objectId, FavouriteType type, String userId);

    @Transactional
    int deleteByObjectIdAndTypeAndUserId(String objectId, FavouriteType type, String userId);

}
