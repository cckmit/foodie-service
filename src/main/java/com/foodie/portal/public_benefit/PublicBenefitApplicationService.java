package com.foodie.portal.public_benefit;

import com.foodie.portal.order.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PublicBenefitApplicationService {

    public PublicBenefit create(String title, String content, BigDecimal extractRatio, BigDecimal totalFoundation) {
        return PublicBenefit.create(title, content, extractRatio, totalFoundation);
    }

    public void extract(Order order) {
        PublicBenefit publicBenefit = new PublicBenefit();
        publicBenefit.extract(order);
    }





}
