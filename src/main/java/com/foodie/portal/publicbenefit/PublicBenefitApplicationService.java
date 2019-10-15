package com.foodie.portal.publicbenefit;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PublicBenefitApplicationService {

    @Autowired
    private PublicBenefitRepository repository;

    public PublicBenefit create(String title, String content, double totalFoundation) {
        PublicBenefit publicBenefit = PublicBenefit.create(title, content, totalFoundation);
        repository.save(publicBenefit);
        return publicBenefit;
    }

    public void extract(Order order) {
        PublicBenefit publicBenefit = new PublicBenefit();
        publicBenefit.extract(order);
    }


    public Pagination<PublicBenefit> list(int page, int size) {
        return repository.findAll(page - 1, size);
    }

    public PublicBenefit detail(String id) {
        return repository.byId(id);
    }
}
