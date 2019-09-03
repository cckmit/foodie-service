package com.foodie.portal.webmanage;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.article.Article;
import com.foodie.portal.article.ArticleType;
import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private WebManageApplicationService webManageApplicationService;

    @GetMapping("featured-areas")
    public FeaturedAreasDto featuredAreas(String cityId) {
        return webManageApplicationService.featuredAreas(cityId);
    }

    @GetMapping("recommend-food-guide")
    public List<Article> recommendFoodGuide() {
        return webManageApplicationService.recommendFoodGuide();
    }

    @GetMapping("top-rated-activities")
    public List<Activity> topRatedActivities() {
        return webManageApplicationService.topRatedActivities();
    }

}
