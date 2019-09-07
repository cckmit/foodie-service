package com.foodie.portal.public_benefit;

import com.foodie.portal.commons.event.OrderFinishedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PublicBenefitListener {

    @Autowired
    private PublicBenefitApplicationService publicBenefitApplicationService;

    @EventListener
    public void onOrderFinished(OrderFinishedEvent event){
        publicBenefitApplicationService.extract(event.getOrder());
    }
}
