package com.foodie.portal.publicbenefit;

import com.foodie.portal.order.Order;
import org.springframework.context.event.EventListener;

public class PublicBenefitController {

    @EventListener
    public void onOrderFinished(Order order) {
        PublicBenefit publicBenefit = new PublicBenefit();
        publicBenefit.extract(order);
    }
}
