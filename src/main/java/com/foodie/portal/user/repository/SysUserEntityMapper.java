package com.foodie.portal.user.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.user.model.SysUser;
import com.foodie.portal.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserEntityMapper extends BaseMapper<SysUser, SysUserEntity> {

    SysUserEntityMapper instance = Mappers.getMapper(SysUserEntityMapper.class);

}
