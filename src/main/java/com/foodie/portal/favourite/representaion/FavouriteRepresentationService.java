package com.foodie.portal.favourite.representaion;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.favourite.FavouriteType;
import com.foodie.portal.web.po.RestaurantRepresentationPo;
import com.google.common.collect.ImmutableMap;
import lombok.var;
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

    private String limitSql = " LIMIT :limit OFFSET :offset";

    public Pagination<ActivityRepresentation> findFavouriteActivityByUserId(String userId, int page, int size) {
        String sql = "select a.* , a.PRICE_LIST as priceListStr from FOODIE_ACTIVITY a left join FOODIE_FAVOURITE f on a.ID=f.OBJECT_ID where f.USER_ID=:userId and f.TYPE=:type"
                .concat(limitSql);
        var content = jdbcTemplate.query(sql, ImmutableMap.of("userId", userId,
                "type", FavouriteType.ACTIVITY.name(),
                "limit", size,
                "offset", (page - 1) * size),
                new BeanPropertyRowMapper<>(ActivityRepresentation.class));

        String countSql = "select count(1) from FOODIE_ACTIVITY a left join FOODIE_FAVOURITE f on a.ID=f.OBJECT_ID where f.USER_ID=:userId and f.TYPE=:type";
        int total = jdbcTemplate.queryForObject(countSql, ImmutableMap.of("userId", userId,
                "type", FavouriteType.ACTIVITY.name()),
                Integer.class);
        return Pagination.of(total, page, size, content);
    }

    public Pagination<RestaurantRepresentation> findFavouriteRestaurantByUserId(String userId, int page, int size) {
        String sql = "select * from FOODIE_RESTAURANT a left join FOODIE_FAVOURITE f on a.ID=f.OBJECT_ID where f.USER_ID=:userId and f.TYPE=:type"
                .concat(limitSql);;
        var content = jdbcTemplate.query(sql,
                ImmutableMap.of("userId", userId,
                        "type", FavouriteType.RESTAURANT.name(),
                        "limit", size,
                        "offset", (page - 1) * size),
                new BeanPropertyRowMapper<>(RestaurantRepresentationPo.class))
                .stream()
                .map(RestaurantRepresentation::from)
                .collect(Collectors.toList());

        String countSql = "select count(1) from FOODIE_ACTIVITY a left join FOODIE_FAVOURITE f on a.ID=f.OBJECT_ID where f.USER_ID=:userId and f.TYPE=:type";
        int total = jdbcTemplate.queryForObject(countSql, ImmutableMap.of("userId", userId,
                "type", FavouriteType.ACTIVITY.name()),
                Integer.class);
        return Pagination.of(total, page, size, content);
    }

    public Pagination<ArticleRepresentation> findFavouriteFoodGuideByUserId(String userId, int page, int size) {
        String sql = "select * from FOODIE_ARTICLE a left join FOODIE_FAVOURITE f on a.ID=f.OBJECT_ID where f.USER_ID=:userId and f.TYPE=:type"
                .concat(limitSql);
        var content = jdbcTemplate.query(sql,
                ImmutableMap.of("userId", userId,
                        "type", FavouriteType.FOOD_GUIDE.name(),
                        "limit", size,
                        "offset", (page - 1) * size),
                new BeanPropertyRowMapper<>(ArticleRepresentation.class));

        String countSql = "select count(1) from FOODIE_ARTICLE a left join FOODIE_FAVOURITE f on a.ID=f.OBJECT_ID where f.USER_ID=:userId and f.TYPE=:type";
        int total = jdbcTemplate.queryForObject(countSql, ImmutableMap.of("userId", userId,
                "type", FavouriteType.ACTIVITY.name()),
                Integer.class);
        return Pagination.of(total, page, size, content);

    }
}
