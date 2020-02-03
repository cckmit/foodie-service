package com.foodie.portal.web.service;

import com.foodie.portal.city.repository.CityJpaRepository;
import com.foodie.portal.web.model.ActivityRepresentation;
import com.foodie.portal.web.model.ArticleRepresentation;
import com.foodie.portal.web.model.RestaurantRepresentation;
import com.foodie.portal.web.model.SearchRepresentation;
import com.foodie.portal.webmanage.repository.BannerEntityMapper;
import com.foodie.portal.webmanage.repository.BannerJpaRepository;
import com.google.common.collect.ImmutableMap;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SearchRepresentationService {

    private final static String ACTIVITY_SEARCH_SQL = "select * from foodie_activity a where a.title like '%:keyword%'";
    private final static String RESTAURANT_SEARCH_SQL = "select * from foodie_restaurant a where a.TITLE like '%:keyword%'";
    private final static String FOODIE_GUIDE_SEARCH_SQL = "select a.*, c.name as cityName from foodie_article a left join foodie_city c on a.city_id=c.id where a.TITLE like '%:keyword%'";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public SearchRepresentationService(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SearchRepresentation search(String keyword) {
        Map<String,String> params = ImmutableMap.of("keyword", keyword);
        var activities = jdbcTemplate.query(ACTIVITY_SEARCH_SQL, params, new BeanPropertyRowMapper<>(ActivityRepresentation.class));
        var restaurants = jdbcTemplate.query(RESTAURANT_SEARCH_SQL, params, new BeanPropertyRowMapper<>(RestaurantRepresentation.class));
        var foodieGuides = jdbcTemplate.query(FOODIE_GUIDE_SEARCH_SQL, params, new BeanPropertyRowMapper<>(ArticleRepresentation.class));
        return SearchRepresentation.of(activities, restaurants, foodieGuides);
    }
}
