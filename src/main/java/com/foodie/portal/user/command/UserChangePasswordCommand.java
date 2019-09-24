package com.foodie.portal.user.command;

import lombok.Data;

@Data
public class UserChangePasswordCommand {

    private String oldPassword;
    private String newPassword;
}
