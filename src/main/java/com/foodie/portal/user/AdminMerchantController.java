package com.foodie.portal.user;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.user.command.CreateMerchantCommand;
import com.foodie.portal.user.command.PassMerchantApplyCommand;
import com.foodie.portal.user.model.Merchant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "（管理员）用户/商家管理")
@RestController
@RequestMapping("admin/merchants")
public class AdminMerchantController {

    @Autowired
    private MerchantApplicationService merchantApplicationService;

    @ApiOperation("商家列表")
    @GetMapping
    public Pagination<Merchant> merchants(PageCommand pageCommand) {
        return merchantApplicationService.merchants(pageCommand.getPage(), pageCommand.getSize());
    }

    @ApiOperation("添加商家")
    @PostMapping
    public void addMerchant(@RequestBody CreateMerchantCommand merchantCommand) {
        merchantApplicationService.addMerchant(merchantCommand);
    }

    @ApiOperation("商家详情")
    @GetMapping("{id}")
    public Merchant detail(@PathVariable String id) {
        return merchantApplicationService.findById(id);
    }

    @ApiOperation("修改商家信息")
    @PatchMapping("{id}")
    public Merchant updateMerchant(@PathVariable String id, @RequestBody CreateMerchantCommand merchantCommand) {
        return merchantApplicationService.updateMerchant(id, merchantCommand);
    }

    @ApiOperation("删除商家")
    @DeleteMapping("{id}")
    public void deleteMerchant(@PathVariable String id) {
        merchantApplicationService.deleteMerchant(id);
    }

    @ApiOperation("商家审批通过")
    @PostMapping("{id}/pass")
    public void pass(@PathVariable String id, @RequestBody @Valid PassMerchantApplyCommand command) {
        merchantApplicationService.pass(id, command.getExtractRatio());
    }

    @ApiOperation("商家审批拒绝")
    @PostMapping("{id}/reject")
    public void reject(@PathVariable String id) {
        merchantApplicationService.reject(id);
    }

    @ApiOperation("待审核商家列表")
    @GetMapping("non-approval")
    public Pagination<Merchant> waitForApprovedMerchant(PageCommand pageCommand) {
        return merchantApplicationService.waitForApprovedMerchant(pageCommand.getPage(), pageCommand.getSize());
    }
}

