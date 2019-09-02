package com.foodie.portal.user.command;

import lombok.Data;

@Data
public class UserRegisterCommand {

    private String email;
    private String password;
}
