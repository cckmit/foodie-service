package com.foodie.portal.activity;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（用户）活动管理")
@RestController
@RequestMapping("activity")
public class UserActivityController {

    @Autowired
    private ActivityApplicationService activityApplicationService;

    @ApiOperation("所有活动")
    @GetMapping
    public Pagination<Activity> activities(PageCommand pageCommand) {
        return  activityApplicationService.find(pageCommand.getPage(), pageCommand.getSize());
    }

    @ApiOperation("活动详情")
    @GetMapping("{id}")
    public Activity detail(@PathVariable String id) {
        return activityApplicationService.findById(id);
    }
}
