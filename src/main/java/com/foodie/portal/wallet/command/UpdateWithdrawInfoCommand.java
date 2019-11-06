package com.foodie.portal.wallet.command;

import lombok.Data;

@Data
public class UpdateWithdrawInfoCommand {
    private String account;
    private String name;
}
