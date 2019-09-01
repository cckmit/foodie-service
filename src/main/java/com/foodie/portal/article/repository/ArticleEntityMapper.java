package com.foodie.portal.article.repository;

import com.foodie.portal.article.Article;
import com.foodie.portal.city.City;
import com.foodie.portal.commons.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleEntityMapper extends BaseMapper<Article, ArticleEntity> {

    ArticleEntityMapper instance = Mappers.getMapper(ArticleEntityMapper.class);

}
