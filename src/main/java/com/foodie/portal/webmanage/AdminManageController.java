package com.foodie.portal.webmanage;

import com.foodie.portal.activity.model.Activity;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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


    @ApiOperation("配置城市活动推荐")
    @PostMapping("city-activities-recommend")
    public void configRecommendActivities(Map<String, List<String>> command) {
        webManageApplicationService.configRecommendActivities(command);

    }

    @ApiOperation("配置城市文章推荐")
    @PostMapping("city-article-recommend")
    public void configRecommendArticle(Map<String, List<String>> command) {
        webManageApplicationService.configRecommendArticle(command);
    }


    @ApiOperation("配置首页活动推荐")
    @PostMapping("top-activities")
    public void configTopActivities(List<String> command) {
        webManageApplicationService.configTopActivities(command);
    }

    @ApiOperation("配置首页文章推荐")
    @PostMapping("top-articles")
    public void configTopArticles(List<String> command) {
        webManageApplicationService.configTopArticles(command);
    }



}
