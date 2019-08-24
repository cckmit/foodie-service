package com.foodie.portal.activity;

import com.foodie.portal.city.City;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@Api
@RequestMapping("activities")
public class ActivityController {

    private Map<String, Activity> activities = JMockData.mock(new TypeReference<Map<String, Activity>>() {
    });

    @ApiOperation("所有活动")
    @GetMapping
    public Collection<Activity> activities() {
        return  activities.values();
    }

    @PostMapping("发布活动")
    public Activity addActivity(Activity activityCommand) {
        Activity activity = new Activity();
        activities.put(activity.getId(), activity);
        return activity;
    }
}
