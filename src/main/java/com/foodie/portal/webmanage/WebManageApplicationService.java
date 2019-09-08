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
import com.google.common.collect.Lists;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WebManageApplicationService {


    private List<String> recommendArticleIds = Lists.newArrayList();


    @Autowired
    private ActivityApplicationService activityApplicationService;
    @Autowired
    private CityApplicationService cityApplicationService;
    @Autowired
    private ArticleApplicationService articleApplicationService;
    @Autowired
    private RecommendRepository recommendRepository;

    public List<Activity> listRecommendActivities() {
        return activityApplicationService.fetchActivitiesByIds(recommendRepository.findRecommendActivityIds());
    }

    public List<Article> listFoodGuides() {
        return articleApplicationService.findArticlesByIds(recommendRepository.findRecommendFoodGuideIds());
    }

    public List<Activity> listTopActivities() {
        return activityApplicationService.fetchActivitiesByIds(recommendRepository.findTopActivityIds());
    }


    public void addRecommendActivities(List<String> activities) {
        recommendRepository.saveRecommendActivityIds(activities);
    }

    public void removeRecommendActivity(String activityId) {
        recommendRepository.removeRecommendActivity(activityId);
    }

    public void addRecommendFoodGuides(List<String> articleIds) {
        recommendRepository.saveRecommendCityArticleIds(articleIds);
    }

    public void removeRecommendFoodGuide(String articleId) {
        recommendRepository.removeRecommendArticle(articleId);
    }

    public void addTopActivities(List<String> activityIds) {
        recommendRepository.saveTopActivityIds(activityIds);
    }

    public void removeTopActivity(String activityId) {
        recommendRepository.removeTopActivity(activityId);
    }


}
