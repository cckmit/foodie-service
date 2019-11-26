package com.foodie.portal.commons.event;

import com.foodie.portal.user.model.Merchant;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MerchantPasswordResetEvent extends DomainEvent{
    private Merchant merchant;
    private String password;
}
