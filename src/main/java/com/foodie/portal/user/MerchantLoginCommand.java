package com.foodie.portal.user;

import lombok.Data;

@Data
public class MerchantLoginCommand {

    private String email;
    private String password;
}
