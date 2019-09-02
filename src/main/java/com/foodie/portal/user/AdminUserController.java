package com.foodie.portal.user;

import com.foodie.portal.commons.RestException;
import com.foodie.portal.user.model.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.foodie.portal.commons.ErrorCode.UNAUTHORIZED;

@Api(tags = "（管理员）个人信息")
@RestController
public class AdminUserController {

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
