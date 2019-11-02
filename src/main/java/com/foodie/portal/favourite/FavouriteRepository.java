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
}
