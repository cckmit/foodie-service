package com.foodie.portal.webmanage.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.webmanage.model.ActivityRecommend;
import com.foodie.portal.webmanage.model.ArticleRecommend;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleRecommendEntityMapper extends BaseMapper<ArticleRecommend, ArticleRecommendEntity> {

    ArticleRecommendEntityMapper instance = Mappers.getMapper(ArticleRecommendEntityMapper.class);

}
