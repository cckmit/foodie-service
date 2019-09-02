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

    @ApiOperation("商家登陆")
    @PostMapping("merchant/login")
    public String merchantLogin(@RequestBody SysUser user) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new LoginToken(user.getUsername(), user.getPassword(), LoginToken.LoginType.MERCHANT);
        try {
            subject.login(token);
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            e.printStackTrace();
            throw new RestException(ErrorCode.NO_RESULT_FOUND.getCode(), "用户名或密码不存在!");
        } catch (LockedAccountException e) {
            throw new RestException(ErrorCode.FAILED.getCode(), "用户被锁定!");
        } catch (DisabledAccountException e) {
            throw new RestException(ErrorCode.FAILED.getCode(), "用户已失效!");
        } catch (ExcessiveAttemptsException e) {
            throw new RestException(ErrorCode.FAILED.getCode(), "尝试输入错误次数过多，最多可以登录5次，请10分钟后重试。!");
        }
        return "success";
    }

}
