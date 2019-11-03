package com.foodie.portal.user;

import com.foodie.portal.user.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserApplicationService {

    @Autowired
    private SysUserRepository sysUserRepository;

    public SysUser findByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }


}
