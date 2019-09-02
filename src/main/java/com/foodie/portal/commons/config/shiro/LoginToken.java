package com.foodie.portal.commons.config.shiro;

import lombok.Data;
import org.apache.shiro.authc.UsernamePasswordToken;

@Data
public class LoginToken extends UsernamePasswordToken {
    private LoginType loginType;

    public LoginToken(String username, String password, LoginType loginType) {
        super(username, password);
        this.loginType = loginType;
    }

    public enum LoginType {
        MERCHANT,
        USER
    }
}
