package com.foodie.portal.favourite;

import com.foodie.portal.user.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
public class Favourite {
    private Long id;
    private String objectId;
    private User user;
    private FavouriteType type;
    private Instant createdAt;

    public Favourite() {
        this.createdAt = Instant.now();
    }

    public Favourite(String objectId, User user, FavouriteType type) {
        this();
        this.objectId = objectId;
        this.user = user;
        this.type = type;
    }

    public static Favourite createActivityFavourite(String objectId , User user) {
        return new Favourite(objectId, user, FavouriteType.ACTIVITY);
    }

    public static Favourite createRestaurantFavourite(String restaurantId, User user) {
        return new Favourite(restaurantId, user, FavouriteType.RESTAURANT);
    }

    public static Favourite createFoodGuideFavourite(String foodieGuideId, User user) {
        return new Favourite(foodieGuideId, user, FavouriteType.FOOD_GUIDE);
    }
}
