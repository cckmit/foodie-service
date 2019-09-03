package com.foodie.portal.webmanage;

import com.foodie.portal.activity.Activity;
import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.article.ArticleApplicationService;
import com.foodie.portal.city.City;
import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.webmanage.command.CityDetailDto;
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
    @Autowired
    private ArticleApplicationService articleApplicationService;

    public List<Activity> fetchRecommendCityActivities(String cityId) {
        return activityApplicationService.fetchActivitiesByIds(activities);
    }

    public CityDetailDto cityDetail(String id) {
        var city = cityApplicationService.retrieve(id);
        var activities = activityApplicationService.topCityActivities(id, 6);
        var article = articleApplicationService.toCityArticles(id, 3);
        return CityDetailDto.toDto(city, activities, article);
    }
}
