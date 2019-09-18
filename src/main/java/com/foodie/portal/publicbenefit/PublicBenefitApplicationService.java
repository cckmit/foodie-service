package com.foodie.portal.publicbenefit;

import com.foodie.portal.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PublicBenefitApplicationService {

    @Autowired
    private PublicBenefitRepository repository;

    public PublicBenefit create(String title, String content, BigDecimal totalFoundation) {
        PublicBenefit publicBenefit = PublicBenefit.create(title, content, totalFoundation);
        repository.save(publicBenefit);
        return publicBenefit;
    }

    public void extract(Order order) {
        PublicBenefit publicBenefit = new PublicBenefit();
        publicBenefit.extract(order);
    }





}
