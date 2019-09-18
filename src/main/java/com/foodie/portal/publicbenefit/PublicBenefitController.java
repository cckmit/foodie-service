package com.foodie.portal.publicbenefit;

import com.foodie.portal.order.Order;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/public-benefit")
public class PublicBenefitController {

    private PublicBenefitApplicationService publicBenefitApplicationService;

    @PostMapping
    public PublicBenefit onOrderFinished(CreatePublicBenefitCommand command) {
        return publicBenefitApplicationService.create(command.getTitle(), command.getContent(), command.getTotalFoundation());
    }
}
