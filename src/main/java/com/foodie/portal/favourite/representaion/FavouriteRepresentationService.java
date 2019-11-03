package com.foodie.portal.favourite.representaion;

import com.foodie.portal.favourite.FavouriteType;
import com.foodie.portal.web.po.RestaurantRepresentationPo;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavouriteRepresentationService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<ActivityRepresentation> findFavouriteActivityByUserId(String userId) {
        String sql = "select a.* , a.PRICE_LIST as priceListStr from FOODIE_ACTIVITY a left join FOODIE_FAVOURITE f on a.ID=f.OBJECT_ID where f.USER_ID=:userId and f.TYPE=:type";
        return jdbcTemplate.query(sql, ImmutableMap.of("userId", userId, "type", FavouriteType.ACTIVITY.name()), new BeanPropertyRowMapper<>(ActivityRepresentation.class));
    }

    public List<RestaurantRepresentation> findFavouriteRestaurantByUserId(String userId) {
        String sql = "select * from FOODIE_RESTAURANT a left join FOODIE_FAVOURITE f on a.ID=f.OBJECT_ID where f.USER_ID=:userId and f.TYPE=:type";
        return jdbcTemplate.query(sql, ImmutableMap.of("userId", userId, "type", FavouriteType.RESTAURANT.name()), new BeanPropertyRowMapper<>(RestaurantRepresentationPo.class))
                .stream()
                .map(RestaurantRepresentation::from)
                .collect(Collectors.toList());
    }

    public List<ArticleRepresentation> findFavouriteFoodGuideByUserId(String userId) {
        String sql = "select * from FOODIE_ARTICLE a left join FOODIE_FAVOURITE f on a.ID=f.OBJECT_ID where f.USER_ID=:userId and f.TYPE=:type";
        return jdbcTemplate.query(sql, ImmutableMap.of("userId", userId, "type", FavouriteType.FOOD_GUIDE.name()), new BeanPropertyRowMapper<>(ArticleRepresentation.class));

    }
}
