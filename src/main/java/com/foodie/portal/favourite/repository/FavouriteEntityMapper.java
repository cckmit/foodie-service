package com.foodie.portal.favourite.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.favourite.Favourite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FavouriteEntityMapper extends BaseMapper<Favourite, FavouriteEntity> {
    FavouriteEntityMapper INSTANCE = Mappers.getMapper(FavouriteEntityMapper.class);
}
