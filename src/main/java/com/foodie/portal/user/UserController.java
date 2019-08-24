package com.foodie.portal.user;

import com.foodie.portal.commons.RestException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.foodie.portal.commons.ErrorCode.UNAUTHORIZED;

@Api
@RestController
public class UserController {

    @PostMapping("login")
    public String login(@RequestBody User user) {

        if (user.getPassword().endsWith("123456")) {
            return "success";
        } else {
            throw new RestException(UNAUTHORIZED.getCode(), "用户名或密码错误");
        }
    }

}
