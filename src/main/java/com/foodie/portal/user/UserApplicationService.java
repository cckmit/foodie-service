package com.foodie.portal.user;

import com.foodie.portal.user.model.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApplicationService {


    public SysUser findByUserName(String username) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("string");
        sysUser.setPassword("123");
        return sysUser;
    }

    public List<String> selectPermissionByUserName(String username) {
        return null;
    }
}
