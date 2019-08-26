package com.foodie.portal.activity;

import com.foodie.portal.city.City;
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
    public Collection<Activity> activities() {
        return  activityApplicationService.find();
    }
}
