package com.foodie.portal.web.service;

import com.foodie.portal.article.ArticleType;
import com.foodie.portal.article.repository.ArticleEntity;
import com.foodie.portal.article.repository.ArticleJpaRepository;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.utils.PaginationUtils;
import com.foodie.portal.web.model.ArticleDetailRepresentation;
import com.foodie.portal.web.model.ArticleRepresentation;
import com.google.common.collect.ImmutableMap;
import lombok.var;
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

    public ArticleDetailRepresentation detail(String id) {
        String sql = "select * from FOODIE_ARTICLE t where t.id=:id";
        return jdbcTemplate.queryForObject(sql, ImmutableMap.of("id",id), new BeanPropertyRowMapper<>(ArticleDetailRepresentation.class));
    }
}
