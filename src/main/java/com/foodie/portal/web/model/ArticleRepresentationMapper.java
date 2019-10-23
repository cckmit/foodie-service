package com.foodie.portal.web.model;

import com.foodie.portal.activity.model.ActivityPrice;
import com.foodie.portal.activity.repository.ActivityEntity;
import com.foodie.portal.article.repository.ArticleEntity;
import com.foodie.portal.commons.BaseMapper;
import org.apache.commons.collections.CollectionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ArticleRepresentationMapper extends BaseMapper<ArticleEntity, ArticleRepresentation> {

    ArticleRepresentationMapper INSTANCE = Mappers.getMapper(ArticleRepresentationMapper.class);

    @Override
    @Mapping(target = "cityName", source = "city.name")
    ArticleRepresentation from(ArticleEntity from);
}
