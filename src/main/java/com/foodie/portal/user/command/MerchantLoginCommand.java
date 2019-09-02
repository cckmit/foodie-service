package com.foodie.portal.user.command;

import lombok.Data;

@Data
public class MerchantLoginCommand {

    private String email;
    private String password;
}
