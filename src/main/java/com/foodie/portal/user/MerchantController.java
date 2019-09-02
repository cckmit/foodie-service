package com.foodie.portal.user;

import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.commons.config.shiro.LoginToken;
import com.foodie.portal.user.command.ChangeMerchantPasswordCommand;
import com.foodie.portal.user.command.MerchantLoginCommand;
import com.foodie.portal.user.model.Merchant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
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

@Api(tags = "（商家）用户信息")
@RestController
@RequestMapping("merchant")
public class MerchantController {

    @Autowired
    private MerchantApplicationService merchantApplicationService;

    @ApiOperation("商家登陆")
    @PostMapping("login")
    public MerchantDto merchantLogin(@RequestBody MerchantLoginCommand user) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new LoginToken(user.getEmail(), user.getPassword(), LoginToken.LoginType.MERCHANT);
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
       return MerchantDto.toDto((Merchant) subject.getPrincipal());
    }


    @ApiOperation("商家个人信息")
    @GetMapping("user-info")
    public MerchantDto merchantInfo() {
        Subject subject = SecurityUtils.getSubject();
        return MerchantDto.toDto((Merchant) subject.getPrincipal());
    }

    @ApiOperation("修改商家密码")
    @PostMapping("change-password")
    public void changePassword(@RequestBody ChangeMerchantPasswordCommand command) {
        var merchant = (Merchant)SecurityUtils.getSubject().getPrincipal();
        merchantApplicationService.changePassword(merchant, command.getPassword());
    }

}
