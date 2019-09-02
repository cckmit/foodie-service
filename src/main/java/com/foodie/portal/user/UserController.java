package com.foodie.portal.user;

import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.commons.config.shiro.LoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.foodie.portal.commons.ErrorCode.UNAUTHORIZED;

@Api(tags = "用户管理")
@RestController
public class UserController {

    @ApiOperation("登陆")
    @PostMapping("login")
    public String login(@RequestBody SysUser user) {

        if (user.getPassword().equals("123456")) {
            return "success";
        } else {
            throw new RestException(UNAUTHORIZED.getCode(), "用户名或密码错误");
        }
    }
}
