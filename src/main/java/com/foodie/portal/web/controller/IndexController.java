package com.foodie.portal.web.controller;

import com.foodie.portal.web.model.ActivityRepresentation;
import com.foodie.portal.web.model.InterestedCityActivities;
import com.foodie.portal.web.service.IndexRepresentationService;
import com.foodie.portal.webmanage.model.Banner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户页面接口")
@RestController
public class IndexController {

    @Autowired
    private IndexRepresentationService indexRepresentationService;

    @ApiOperation("首页banner列表")
    @GetMapping("banners")
    public List<Banner> banners() {
        return indexRepresentationService.listBanner();
    }

//    @ApiOperation("首页推荐城市活动")
//    @GetMapping("featured-activity")
//    public List<FeaturedAreasDto> featuredCityActivity() {
//        return indexRepresentationService.featuredActivity();
//    }
//
//
//    @ApiOperation("首页推荐美食指南")
//    @GetMapping("top-rated-food-guide")
//    public List<Article> recommendFoodGuide() {
//        return indexRepresentationService.featuredCityFoodGuide();
//    }
//

    @ApiOperation("感兴趣活动")
    @GetMapping("interested-activities")
    public InterestedCityActivities listCityInterestedActivities(String cityId) {
        return indexRepresentationService.findByInterestedByCityId(cityId);
    }


}
