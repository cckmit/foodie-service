package com.foodie.portal.activity;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.user.model.Merchant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（商家）活动管理")
@RestController
@RequestMapping("merchant/activities")
public class ActivityMerchantController {

    @Autowired
    private ActivityApplicationService activityApplicationService;

    @ApiOperation("发布我的活动")
    @PostMapping
    public void addActivity(@RequestBody CreateActivityCommand activityCommand) {
        var merchant = (Merchant)SecurityUtils.getSubject().getPrincipal();
        activityApplicationService.addActivity(activityCommand, merchant);
    }

    @ApiOperation("我的活动")
    @GetMapping
    public Pagination<Activity> activities(PageCommand pageCommand) {
        var merchant = (Merchant)SecurityUtils.getSubject().getPrincipal();
        return  activityApplicationService.findOwnerActivity(merchant.getId(), pageCommand.getPage(), pageCommand.getSize());
    }

    @ApiOperation("我的活动详情")
    @GetMapping("{id}")
    public Activity detail(@PathVariable String id) {
        return activityApplicationService.findById(id);
    }

    @ApiOperation("修改我的活动")
    @PatchMapping("{id}")
    public void updateActivity(@PathVariable String id, @RequestBody CreateActivityCommand activityCommand) {
        activityApplicationService.updateActivity(id, activityCommand);
    }

    @ApiOperation("删除我的活动")
    @DeleteMapping("{id}")
    public void deleteActivity(@PathVariable String id) {
        activityApplicationService.delete(id);
    }

}
