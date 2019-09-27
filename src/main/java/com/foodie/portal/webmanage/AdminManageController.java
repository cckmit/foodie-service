package com.foodie.portal.webmanage;

import com.foodie.portal.webmanage.command.AddBannerCommand;
import com.foodie.portal.webmanage.model.Banner;
import com.foodie.portal.webmanage.representation.RecommendActivityRepresentation;
import com.foodie.portal.webmanage.representation.WebManagerRepresentationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Api(tags = "（管理员）网站管理")
@RestController
@RequestMapping("admin/manage")
public class AdminManageController {


    @Autowired
    private WebManageApplicationService webManageApplicationService;
    @Autowired
    private WebManagerRepresentationService webManagerRepresentationService;

    @ApiOperation("添加banner")
    @PostMapping("banner")
    public Banner addBanner(AddBannerCommand bannerCommand) {
        return webManageApplicationService.addBanner(bannerCommand);
    }

    @ApiOperation("删除banner")
    @DeleteMapping("banner")
    public String removeBanner(String bannerId) {
        webManageApplicationService.removeBanner(bannerId);
        return bannerId;
    }

    @ApiOperation("添加推荐活动")
    @PostMapping("activity-recommend")
    public void addRecommendActivity(String activityId) {
        webManageApplicationService.addRecommendActivity(activityId);
    }

    @ApiOperation("获取推荐活动列表")
    @GetMapping("activities-recommend")
    public List<RecommendActivityRepresentation> listRecommendActivities() {
        return webManagerRepresentationService.listRecommendActivities();
    }

//    @ApiOperation("推荐美食指南列表")
//    @GetMapping("food-guide-recommend")
//    public List<Article> listRecommendFoodGuides() {
//        return webManageApplicationService.listFoodGuides();
//    }
//
//    @ApiOperation("TOP活动列表")
//    @GetMapping("top-activities")
//    public List<RecommendActivityRepresentation> listTopActivities() {
//        return webManagerRepresentationService.listTopActivities();
//    }
//
//    @ApiOperation("添加活动推荐")
//    @PostMapping("add-activities-recommend")
//    public void addRecommendActivities(@RequestBody AddRecommendActivitiesCommand command) {
//        webManageApplicationService.addRecommendActivity(command.getActivityIds());
//
//    }
//
//    @ApiOperation("移除活动推荐")
//    @PostMapping("delete-activities-recommend")
//    public void removeRecommendActivities(@RequestBody DeleteRecommendActivityCommand command) {
//        webManageApplicationService.removeRecommendActivity(command.getActivityId());
//    }
//
//    @ApiOperation("添加美食指南推荐")
//    @PostMapping("add-food-guide-recommend")
//    public void configRecommendArticle(@RequestBody AddRecommendArticlesCommand command) {
//        webManageApplicationService.addRecommendFoodGuides(command.getArticleIds());
//    }
//
//    @ApiOperation("移除美食指南推荐")
//    @PostMapping("delete-food-guide-recommend")
//    public void removeRecommendFoodGuide(@RequestBody DeleteRecommendActivityCommand command) {
//        webManageApplicationService.removeRecommendFoodGuide(command.getActivityId());
//    }
//
//
//    @ApiOperation("添加TOP活动推荐")
//    @PostMapping("add-top-activities")
//    public void addTopActivities(@RequestBody AddTopActivitiesCommand command) {
//        webManageApplicationService.addTopActivities(command.getActivityIds());
//    }
//
//    @ApiOperation("移除TOP活动推荐")
//    @PostMapping("delete-top-articles")
//    public void removeTopArticles(@RequestBody DeleteTopActivityCommand command) {
//        webManageApplicationService.removeTopActivity(command.getActivityId());
//    }



}
