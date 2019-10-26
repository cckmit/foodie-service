package com.foodie.portal.web.service;

import com.foodie.portal.article.repository.ArticleJpaRepository;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.restaurant.RestaurantType;
import com.foodie.portal.restaurant.repository.RestaurantJpaRepository;
import com.foodie.portal.utils.PaginationUtils;
import com.foodie.portal.web.model.ArticleDetailRepresentation;
import com.foodie.portal.web.model.ArticleRepresentation;
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

    public RestaurantRepresentation detail(String id) {
        String sql = "select * from FOODIE_RESTAURANT t where t.id=:id";
        return jdbcTemplate.queryForObject(sql, ImmutableMap.of("id",id), new BeanPropertyRowMapper<>(RestaurantRepresentation.class));
    }
}
