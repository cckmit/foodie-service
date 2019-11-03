package com.foodie.portal.user;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.user.model.SysUser;
import com.foodie.portal.user.model.User;
import com.foodie.portal.user.repository.SysUserEntityMapper;
import com.foodie.portal.user.repository.SysUserJpaRepository;
import com.foodie.portal.user.repository.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class SysUserRepository {

    @Autowired
    private SysUserJpaRepository sysUserJpaRepository;

    public void save(SysUser user) {
        sysUserJpaRepository.save(SysUserEntityMapper.instance.from(user));
    }

    public SysUser findByUsername(String username) {
        return SysUserEntityMapper.instance.to(sysUserJpaRepository.findByUsername(username));
    }


}
