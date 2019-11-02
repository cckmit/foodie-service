package com.foodie.portal.web.service;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.favourite.FavouriteType;
import com.foodie.portal.restaurant.model.RestaurantType;
import com.foodie.portal.restaurant.repository.RestaurantJpaRepository;
import com.foodie.portal.user.model.User;
import com.foodie.portal.utils.PaginationUtils;
import com.foodie.portal.web.model.RestaurantRepresentation;
import com.google.common.collect.ImmutableMap;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RestaurantRepresentationService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    public Pagination<RestaurantRepresentation> findAllByCityAndType(int page, int size, String cityId, RestaurantType type) {
        var entities = restaurantJpaRepository.findByCityIdAndType(cityId, type, PageRequest.of(page - 1, size));
        return PaginationUtils.map(entities, RestaurantRepresentation::from);
    }

    public RestaurantRepresentation detail(String id, User user) {
        String sql = "select * from FOODIE_RESTAURANT t where t.id=:id";
        RestaurantRepresentation restaurantRepresentation = jdbcTemplate.queryForObject(sql,
                ImmutableMap.of("id", id),
                new BeanPropertyRowMapper<>(RestaurantRepresentation.class));

        String favouriteSql = "select count(1) a from FOODIE_FAVOURITE f where f.OBJECT_ID=:id and f.TYPE=:type and f.USER_ID=:userId";
        Integer count = jdbcTemplate.queryForObject(favouriteSql, ImmutableMap.of("id", id, "type", FavouriteType.RESTAURANT.name(), "userId", user.getId()), Integer.class);
        if (count > 0) {
            restaurantRepresentation.setFavourite(true);
        }
        return restaurantRepresentation;
    }
}
