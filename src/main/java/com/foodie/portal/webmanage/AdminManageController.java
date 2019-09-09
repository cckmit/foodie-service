package com.foodie.portal.webmanage;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.article.Article;
import com.foodie.portal.webmanage.command.AddRecommendActivitiesCommand;
import com.foodie.portal.webmanage.command.AddRecommendArticlesCommand;
import com.foodie.portal.webmanage.command.AddTopActivitiesCommand;
import com.foodie.portal.webmanage.command.DeleteRecommendActivityCommand;
import com.foodie.portal.webmanage.command.DeleteTopActivityCommand;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "（管理员）网站管理")
@RestController
@RequestMapping("admin/manage")
public class AdminManageController {

    List<Banner> banners = JMockData.mock(new TypeReference<List<Banner>>() {
    });

    @Autowired
    private WebManageApplicationService webManageApplicationService;

    @ApiOperation("添加banner")
    @PostMapping("banner")
    public Banner addBanner(Banner bannerCommand) {
        Banner banner = Banner.create(bannerCommand.getUrl(), bannerCommand.getLink());
        banners.add(banner);
        return banner;
    }

    @ApiOperation("删除banner")
    @DeleteMapping("banner")
    public String removeBanner(String bannerId) {
        banners = banners.stream().filter(banner -> !banner.getId().equals(bannerId)).collect(Collectors.toList());
        return bannerId;
    }

    @ApiOperation("推荐活动列表")
    @GetMapping("activities-recommend")
    public List<Activity> listRecommendActivities() {
        return webManageApplicationService.listRecommendActivities();
    }

    @ApiOperation("推荐美食指南列表")
    @GetMapping("food-guide-recommend")
    public List<Article> listRecommendFoodGuides() {
        return webManageApplicationService.listFoodGuides();
    }

    @ApiOperation("TOP活动列表")
    @GetMapping("top-activities")
    public List<Activity> listTopActivities() {
        return webManageApplicationService.listTopActivities();
    }

    @ApiOperation("添加活动推荐")
    @PostMapping("add-activities-recommend")
    public void addRecommendActivities(@RequestBody AddRecommendActivitiesCommand command) {
        webManageApplicationService.addRecommendActivities(command.getActivityIds());

    }

    @ApiOperation("移除活动推荐")
    @PostMapping("delete-activities-recommend")
    public void removeRecommendActivities(@RequestBody DeleteRecommendActivityCommand command) {
        webManageApplicationService.removeRecommendActivity(command.getActivityId());
    }

    @ApiOperation("添加美食指南推荐")
    @PostMapping("add-food-guide-recommend")
    public void configRecommendArticle(@RequestBody AddRecommendArticlesCommand command) {
        webManageApplicationService.addRecommendFoodGuides(command.getArticleIds());
    }

    @ApiOperation("移除美食指南推荐")
    @PostMapping("delete-food-guide-recommend")
    public void removeRecommendFoodGuide(@RequestBody DeleteRecommendActivityCommand command) {
        webManageApplicationService.removeRecommendFoodGuide(command.getActivityId());
    }


    @ApiOperation("添加TOP活动推荐")
    @PostMapping("add-top-activities")
    public void addTopActivities(@RequestBody AddTopActivitiesCommand command) {
        webManageApplicationService.addTopActivities(command.getActivityIds());
    }

    @ApiOperation("移除TOP活动推荐")
    @PostMapping("delete-top-articles")
    public void removeTopArticles(@RequestBody DeleteTopActivityCommand command) {
        webManageApplicationService.removeTopActivity(command.getActivityId());
    }



}
