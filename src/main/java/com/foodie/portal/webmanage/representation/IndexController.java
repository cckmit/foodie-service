package com.foodie.portal.webmanage.representation;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.article.Article;
import com.foodie.portal.city.representation.CitySummaryRepresentation;
import com.foodie.portal.webmanage.FeaturedAreasDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户首页接口")
@RestController
public class IndexController {

    @Autowired
    private IndexRepresentationService indexRepresentationService;

    @ApiOperation("首页推荐城市列表")
    @GetMapping("recommend-cites")
    public List<CitySummaryRepresentation> listRecommendCities() {
        return indexRepresentationService.listRecommendCities();
    }

    @ApiOperation("首页推荐城市活动")
    @GetMapping("featured-city-activity")
    public FeaturedAreasDto featuredCityActivity(String cityId) {
        return indexRepresentationService.featuredCityActivity(cityId);
    }

    @ApiOperation("首页推荐城市美食指南")
    @GetMapping("featured-city-food-guide")
    public List<Article> featuredCityFoodGuide(String cityId) {
        return indexRepresentationService.featuredCityFoodGuide(cityId);
    }

    @ApiOperation("首页推荐美食指南")
    @GetMapping("top-rated-food-guide")
    public List<Article> recommendFoodGuide() {
        return indexRepresentationService.recommendFoodGuide();
    }

    @ApiOperation("首页推荐活动")
    @GetMapping("top-rated-activities")
    public List<Activity> topRatedActivities() {
        return indexRepresentationService.topRatedActivities();
    }

}
