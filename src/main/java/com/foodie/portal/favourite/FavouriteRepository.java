package com.foodie.portal.favourite;

import com.foodie.portal.favourite.repository.FavouriteEntityMapper;
import com.foodie.portal.favourite.repository.FavouriteJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FavouriteRepository {

    @Autowired
    private FavouriteJpaRepository favouriteJpaRepository;

    public void save(Favourite favourite) {
        favouriteJpaRepository.save(FavouriteEntityMapper.INSTANCE.from(favourite));
    }

    public void deleteByObjectIdAndTypeAndUserId(String objectId, FavouriteType type, String userId) {
        favouriteJpaRepository.deleteByObjectIdAndTypeAndUserId(objectId,type,userId);
    }

    public Favourite findByObjectIdAndTypeAndUserId(String objectId, FavouriteType type, String userId) {
        return FavouriteEntityMapper.INSTANCE.to(favouriteJpaRepository.findByObjectIdAndTypeAndUserId(objectId, type, userId));
    }
}
