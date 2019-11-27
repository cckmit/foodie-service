package com.foodie.portal.web.service;

import com.foodie.portal.article.ArticleType;
import com.foodie.portal.article.repository.ArticleEntity;
import com.foodie.portal.article.repository.ArticleJpaRepository;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.favourite.FavouriteType;
import com.foodie.portal.user.model.User;
import com.foodie.portal.commons.utils.PaginationUtils;
import com.foodie.portal.web.model.ArticleDetailRepresentation;
import com.foodie.portal.web.model.ArticleRepresentation;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FoodGuideRepresentationService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ArticleJpaRepository articleJpaRepository;

    public Pagination<ArticleRepresentation> findAllByCityAndType(int page, int size, String cityId, ArticleType type) {
        Page<ArticleEntity> entities = null;
        if (Objects.isNull(type)) {
            entities = articleJpaRepository.findByCityId(cityId, PageRequest.of(page - 1, size));
        }else{
            entities = articleJpaRepository.findByCityIdAndType(cityId, type,  PageRequest.of(page - 1, size));
        }
        return PaginationUtils.map(entities, ArticleRepresentation::from);
    }

    public ArticleDetailRepresentation detail(String id, User user) {
        String sql = "select t.*, c.NAME as cityName from FOODIE_ARTICLE t left join FOODIE_CITY c on t.CITY_ID=c.id where t.id=:id";
        ArticleDetailRepresentation representation = jdbcTemplate.queryForObject(sql, ImmutableMap.of("id", id), new BeanPropertyRowMapper<>(ArticleDetailRepresentation.class));

        if (Objects.isNull(user)) {
            return representation;
        }
        String favouriteSql = "select count(1) a from FOODIE_FAVOURITE f where f.OBJECT_ID=:id and f.TYPE=:type and f.USER_ID=:userId";
        Integer count = jdbcTemplate.queryForObject(favouriteSql, ImmutableMap.of("id", id, "type", FavouriteType.FOOD_GUIDE.name(), "userId", user.getId()), Integer.class);
        if (count > 0) {
            representation.setFavourite(true);
        }
        return representation;
    }


}
