package com.foodie.portal.webmanage.representation;

import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.article.Article;
import com.foodie.portal.article.ArticleApplicationService;
import com.foodie.portal.city.City;
import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.city.representation.CityRepresentationService;
import com.foodie.portal.city.representation.CitySummaryRepresentation;
import com.foodie.portal.webmanage.FeaturedAreasDto;
import com.foodie.portal.webmanage.RecommendRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexRepresentationService {

    @Autowired
    private CityApplicationService cityApplicationService;
    @Autowired
    private ActivityApplicationService activityApplicationService;
    @Autowired
    private RecommendRepository recommendRepository;
    @Autowired
    private CityRepresentationService cityRepresentationService;
    @Autowired
    private ArticleApplicationService articleApplicationService;

    /**
     * 感兴趣城市
     * @param cityId
     * @return
     */
    public FeaturedAreasDto featuredCityActivity(String cityId) {
        var city = cityApplicationService.retrieve(cityId);
        var activities = activityApplicationService.fetchActivitiesByIds(recommendRepository.findRecommendCityActivityIds().get(cityId));
        return FeaturedAreasDto.toDto(city, activities);
    }

    public List<Article> featuredCityFoodGuide(String cityId) {
        return articleApplicationService.findArticlesByIds(recommendRepository.findRecommendCityActivityIds().get(cityId));
    }

    public List<CitySummaryRepresentation> listRecommendCities() {
        return cityRepresentationService.listCitiesByIds(recommendRepository.findRecommendCityActivityIds().keySet());
    }


    /**
     * 推荐活动
     * @return
     */
    public List<Activity> topRatedActivities() {
        return activityApplicationService.fetchActivitiesByIds(recommendRepository.findTopActivityIds());
    }

    public List<Article> recommendFoodGuide() {
        return articleApplicationService.findArticlesByIds(recommendRepository.findTopFoodGuideIds());
    }


}
