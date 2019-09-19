package com.foodie.portal.user;

import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.commons.config.shiro.LoginToken;
import com.foodie.portal.user.command.MerchantLoginCommand;
import com.foodie.portal.user.command.UpdateUserInfoCommand;
import com.foodie.portal.user.command.UserRegisterCommand;
import com.foodie.portal.user.model.User;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（用户）个人信息")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserApplicationService userApplicationService;

    @ApiOperation("用户登陆")
    @PostMapping("login")
    public User userLogin(@RequestBody MerchantLoginCommand user) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new LoginToken(user.getEmail(), user.getPassword(), LoginToken.LoginType.USER);
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
        return (User) subject.getPrincipal();
    }

    @ApiOperation("用户注册")
    @PostMapping("register")
    public User userRegister(@RequestBody UserRegisterCommand userRegisterCommand) {
        return userApplicationService.register(userRegisterCommand);
    }

    @ApiOperation("用户注册")
    @GetMapping("user-info")
    public User userInfo() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    @ApiOperation("更新个人信息")
    @PostMapping("user-info")
    public void updateInfo(UpdateUserInfoCommand command) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        userApplicationService.updateInfo(user.getId(), command);

    }
}
