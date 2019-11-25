package com.foodie.portal.user.command;

import lombok.Data;

@Data
public class ChangeMerchantPasswordCommand {
    private String oldPassword;
    private String password;
}
