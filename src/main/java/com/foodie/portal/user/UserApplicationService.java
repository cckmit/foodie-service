package com.foodie.portal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApplicationService {

    @Autowired
    private MerchantApplicationService merchantApplicationService;

    public SysUser findByUserName(String username) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("string");
        sysUser.setPassword("123");
        return sysUser;
    }

    public Merchant findByMerchantEmail(String email) {
        return merchantApplicationService.findByEmail(email);
    }

    public List<String> selectPermissionByUserName(String username) {
        return null;
    }
}
