package com.foodie.portal.activity;

import com.foodie.portal.activity.command.AdminCreateActivityCommand;
import com.foodie.portal.activity.command.CreateActivityCommand;
import com.foodie.portal.activity.command.UpdateActivityCommand;
import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "（管理员）活动管理")
@RestController
@RequestMapping("admin/activities")
public class AdminActivityController {

    @Autowired
    private ActivityApplicationService activityApplicationService;

    @ApiOperation("发布活动")
    @PostMapping
    public void addActivity(@Valid @RequestBody AdminCreateActivityCommand activityCommand) {
        activityApplicationService.addActivity(activityCommand);
    }

    @ApiOperation("所有活动")
    @GetMapping
    public Pagination<Activity> activities(PageCommand pageCommand, String cityId) {
        return  activityApplicationService.find(pageCommand.getPage(), pageCommand.getSize(), cityId);
    }

    @ApiOperation("活动详情")
    @GetMapping("{id}")
    public Activity detail(@PathVariable String id) {
        return activityApplicationService.findById(id);
    }

    @ApiOperation("修改活动")
    @PatchMapping("{id}")
    public void updateActivity(@PathVariable String id, @RequestBody UpdateActivityCommand activityCommand) {
        activityApplicationService.updateActivity(id, activityCommand);
    }

    @ApiOperation("置顶活动")
    @PostMapping("{id}/top")
    public void topActivity(@PathVariable String id) {
        activityApplicationService.topActivity(id);
    }

    @ApiOperation("删除活动")
    @DeleteMapping("{id}")
    public void deleteActivity(@PathVariable String id) {
        activityApplicationService.delete(id);
    }

    @ApiOperation("活动审批通过")
    @PostMapping("{id}/pass")
    public void pass(@PathVariable String id) {
        activityApplicationService.pass(id);
    }

    @ApiOperation("活动审批拒绝")
    @PostMapping("{id}/reject")
    public void reject(@PathVariable String id) {
        activityApplicationService.reject(id);
    }

    @ApiOperation("待审核活动列表")
    @GetMapping("non-approval")
    public Pagination<Activity> waitForApprovedActivities(PageCommand pageCommand) {
        return activityApplicationService.waitForApprovedActivities(pageCommand.getPage(), pageCommand.getSize());
    }
}
