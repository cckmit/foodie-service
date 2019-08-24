package com.foodie.portal.webmanage;

import com.foodie.portal.activity.Activity;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "网站管理")
@RestController
@RequestMapping("manage")
public class AdminManageController {

    List<Banner> banners = JMockData.mock(new TypeReference<List<Banner>>() {
    });
    List<Activity> topActivities = JMockData.mock(new TypeReference<List<Activity>>() {
    });

    Map<String, List<String>> recommendActivities = new HashMap<>();
    List<String> recommendArticles = new ArrayList<>();


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

    @ApiOperation("首页推荐活动")
    @PostMapping("top")
    public List<Activity> topActivities(List<Activity> activities) {
        return topActivities;
    }

    @ApiOperation("增加城市活动推荐")
    @PostMapping("city-activities-recommend")
    public void addRecommendActivities(String cityId, List<String> activitiesId) {
        List<String> activities = recommendActivities.get(cityId);
        if (Objects.isNull(activities)) {
            recommendActivities.put(cityId, activitiesId);
            return;
        }
        recommendActivities.get(cityId).addAll(activitiesId);
    }

    @ApiOperation("删除城市活动推荐")
    @DeleteMapping("city-activities-recommend")
    public void removeRecommendActivities(String cityId, String activityId) {
        List<String> activities = recommendActivities.get(cityId);
        if (Objects.isNull(activities)) {
            return;
        }
        recommendActivities.get(cityId).remove(activityId);
    }

    @ApiOperation("增加文章推荐")
    @PostMapping("article-recommend")
    public void addRecommendArticle(String articleId) {
        recommendArticles.add(articleId);
    }


    @ApiOperation("删除文章推荐")
    @DeleteMapping("article-recommend")
    public void removeRecommendArticle(String articleId) {
        recommendArticles.remove(articleId);
    }
}
