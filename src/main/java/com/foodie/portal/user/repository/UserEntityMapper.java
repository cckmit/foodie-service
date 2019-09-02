package com.foodie.portal.user.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapper extends BaseMapper<User, UserEntity> {

    UserEntityMapper instance = Mappers.getMapper(UserEntityMapper.class);

}
