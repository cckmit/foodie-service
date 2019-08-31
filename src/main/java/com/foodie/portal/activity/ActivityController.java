package com.foodie.portal.activity;

import com.foodie.portal.city.City;
import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Api(tags = "活动管理")
@RestController
@RequestMapping("activities")
public class ActivityController {

    private Map<String, Activity> activities = JMockData.mock(new TypeReference<Map<String, Activity>>() {
    });

    @Autowired
    private ActivityApplicationService activityApplicationService;

    @ApiOperation("发布活动")
    @PostMapping
    public void addActivity(@RequestBody CreateActivityCommand activityCommand) {
        activityApplicationService.addActivity(activityCommand);
    }

    @ApiOperation("所有活动")
    @GetMapping
    public Pagination<Activity> activities(PageCommand pageCommand) {
        return  activityApplicationService.find(pageCommand.getPage(), pageCommand.getSize());
    }

    @ApiOperation("活动详情")
    @GetMapping("{id}")
    public Activity detail(@PathVariable String id) {
        return activityApplicationService.retrieveById(id);
    }

    @ApiOperation("修改活动")
    @PatchMapping("{id}")
    public void updateActivity(@PathVariable String id, @RequestBody CreateActivityCommand activityCommand) {
        activityApplicationService.updateActivity(id, activityCommand);
    }

    @ApiOperation("删除活动")
    @DeleteMapping("{id}")
    public void deleteActivity(@PathVariable String id) {
        activityApplicationService.delete(id);
    }
}
