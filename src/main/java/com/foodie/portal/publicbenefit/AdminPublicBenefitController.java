package com.foodie.portal.publicbenefit;

import com.foodie.portal.order.Order;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（管理员）公益活动")
@RestController
@RequestMapping("admin/public-benefit")
public class AdminPublicBenefitController {

    @Autowired
    private PublicBenefitApplicationService publicBenefitApplicationService;

    @PostMapping
    public PublicBenefit create(CreatePublicBenefitCommand command) {
        return publicBenefitApplicationService.create(command.getTitle(), command.getContent(), command.getTotalFoundation());
    }
}
