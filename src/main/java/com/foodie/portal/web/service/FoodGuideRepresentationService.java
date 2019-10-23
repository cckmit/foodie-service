package com.foodie.portal.web.service;

import com.foodie.portal.article.repository.ArticleJpaRepository;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.utils.PaginationUtils;
import com.foodie.portal.web.model.ArticleRepresentation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class FoodGuideRepresentationService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ArticleJpaRepository articleJpaRepository;

    public Pagination<ArticleRepresentation> findAllByCity(int page, int size, String cityId) {
        var entities = articleJpaRepository.findByCityId(cityId, PageRequest.of(page - 1, size));
        return PaginationUtils.map(entities, ArticleRepresentation::from);
    }

    public ArticleRepresentation detail(String id) {
        return articleJpaRepository.findById(id).map(ArticleRepresentation::from).orElse(null);
    }
}
