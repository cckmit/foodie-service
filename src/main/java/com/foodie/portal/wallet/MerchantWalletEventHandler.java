package com.foodie.portal.wallet;

import com.foodie.portal.commons.event.OrderFinishedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MerchantWalletEventHandler {

    @Autowired
    private WalletApplicationService walletApplicationService;

    @EventListener
    public void onOrderAccepted(OrderFinishedEvent event) {
        walletApplicationService.addMerchantOpenAccount(event.getOrder());
    }
}
