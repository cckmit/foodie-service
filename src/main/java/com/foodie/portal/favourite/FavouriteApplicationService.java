package com.foodie.portal.favourite;

import com.foodie.portal.user.model.User;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouriteApplicationService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    public void favouriteActivity(String activityId, User user) {
        var favourite = Favourite.createActivityFavourite(activityId, user);
        favouriteRepository.save(favourite);
    }

    public void favouriteRestaurant(String restaurantId, User user) {
        var favourite = Favourite.createRestaurantFavourite(restaurantId, user);
        favouriteRepository.save(favourite);
    }

    public void favouriteFoodGuide(String foodieGuideId, User user) {
        var favourite = Favourite.createFoodGuideFavourite(foodieGuideId, user);
        favouriteRepository.save(favourite);
    }
}
