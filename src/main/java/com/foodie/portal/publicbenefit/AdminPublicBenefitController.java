package com.foodie.portal.publicbenefit;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.publicbenefit.command.CreatePublicBenefitCommand;
import com.foodie.portal.publicbenefit.command.UpdatePublicBenefitCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（管理员）公益活动")
@RestController
@RequestMapping("admin/public-benefit")
public class AdminPublicBenefitController {

    @Autowired
    private PublicBenefitApplicationService publicBenefitApplicationService;

    @ApiOperation("创建公益")
    @PostMapping
    public PublicBenefit create(@RequestBody CreatePublicBenefitCommand command) {
        return publicBenefitApplicationService.create(command.getTitle(), command.getContent(), command.getTotalFoundation());
    }

    @ApiOperation("公益列表")
    @GetMapping
    public Pagination<PublicBenefit> list(PageCommand command) {
        return publicBenefitApplicationService.list(command.getPage(), command.getSize());
    }

    @ApiOperation("公益详情")
    @GetMapping("{id}")
    public PublicBenefit detail(@PathVariable String id) {
        return publicBenefitApplicationService.detail(id);
    }

    @ApiOperation("公益修改")
    @PatchMapping("{id}")
    public PublicBenefit update(@PathVariable String id, @RequestBody UpdatePublicBenefitCommand command) {
        return publicBenefitApplicationService.update(id, command);
    }

    @ApiOperation("激活公益")
    @PostMapping("{id}/activate")
    public void activate(@PathVariable String id) {
        publicBenefitApplicationService.activate(id);
    }
}
