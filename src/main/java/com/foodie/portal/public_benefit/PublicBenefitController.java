package com.foodie.portal.public_benefit;

import com.foodie.portal.order.Order;
import org.springframework.context.event.EventListener;

public class PublicBenefitController {

    @EventListener
    public void onOrderFinished(Order order) {
        PublicBenefit publicBenefit = new PublicBenefit();
        publicBenefit.extract(order);
    }
}
