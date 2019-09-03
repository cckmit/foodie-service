package com.foodie.portal.webmanage;

import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.activity.model.ActivityType;
import com.foodie.portal.article.Article;
import com.foodie.portal.article.ArticleApplicationService;
import com.foodie.portal.article.ArticleType;
import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.webmanage.command.CityDetailDto;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WebManageApplicationService {

    private Map<String, List<String>> recommendCityActivities = Maps.newHashMap();

    private List<String> recommendArticleIds = Lists.newArrayList();

    private List<String> recommendActivityIds = Lists.newArrayList();

    @Autowired
    private ActivityApplicationService activityApplicationService;
    @Autowired
    private CityApplicationService cityApplicationService;
    @Autowired
    private ArticleApplicationService articleApplicationService;


    /**
     * 城市详情
     * @param id
     * @return
     */
    public CityDetailDto cityDetail(String id) {
        var city = cityApplicationService.retrieve(id);
        var article = articleApplicationService.findArticlesByIds(recommendArticleIds);
        return CityDetailDto.toDto(city, article);
    }

    /**
     * 城市活动
     * @param id
     * @param type
     * @return
     */
    public List<Activity> cityActivities(String id , ActivityType type) {
        return activityApplicationService.topCityActivities(id, type,6);
    }

    /**
     * 美食指南
     * @param cityId
     * @param type
     * @param page
     * @param size
     * @return
     */
    public Pagination<Article> foodGuide(String cityId, ArticleType type, int page, int size) {
        return articleApplicationService.findArticleByCityIdAndType(cityId, type, page, size);
    }

    /**
     * 感兴趣城市
     * @param cityId
     * @return
     */
    public FeaturedAreasDto featuredAreas(String cityId) {
        var city = cityApplicationService.retrieve(cityId);
        var activities = activityApplicationService.fetchActivitiesByIds(recommendCityActivities.get(cityId));
        return FeaturedAreasDto.toDto(city, activities);
    }

    /**
     * 推荐活动
     * @return
     */
    public List<Activity> topRatedActivities() {
        return activityApplicationService.fetchActivitiesByIds(recommendActivityIds);
    }

    public List<Article> recommendFoodGuide() {
        return articleApplicationService.findArticlesByIds(recommendArticleIds);
    }
}
