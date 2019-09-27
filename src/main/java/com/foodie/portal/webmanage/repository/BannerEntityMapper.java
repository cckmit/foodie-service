package com.foodie.portal.webmanage.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.webmanage.model.Banner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BannerEntityMapper extends BaseMapper<Banner, BannerEntity> {

    BannerEntityMapper instance = Mappers.getMapper(BannerEntityMapper.class);

}
