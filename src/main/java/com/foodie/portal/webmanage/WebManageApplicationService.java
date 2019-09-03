package com.foodie.portal.webmanage;

import com.foodie.portal.activity.Activity;
import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.city.City;
import com.foodie.portal.city.CityApplicationService;
import com.google.common.collect.ImmutableList;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebManageApplicationService {

    private List<String> activities = ImmutableList.of();

    @Autowired
    private ActivityApplicationService activityApplicationService;
    @Autowired
    private CityApplicationService cityApplicationService;

    public List<Activity> fetchRecommendCityActivities(String cityId) {
        return activityApplicationService.fetchActivitiesByIds(activities);
    }

    public void cityDetail(String id) {
        City city = cityApplicationService.retrieve(id);
        var activities = activityApplicationService.topCityActivities(id, 6);

    }
}
