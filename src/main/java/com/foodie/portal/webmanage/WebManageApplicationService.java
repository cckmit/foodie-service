package com.foodie.portal.webmanage;

import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.article.ArticleApplicationService;
import com.foodie.portal.webmanage.command.AddBannerCommand;
import com.foodie.portal.webmanage.model.Banner;
import com.google.common.collect.Lists;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebManageApplicationService {


    private List<String> recommendArticleIds = Lists.newArrayList();


    @Autowired
    private ActivityApplicationService activityApplicationService;
    @Autowired
    private WebManageRepository webManageRepository;
    @Autowired
    private ArticleApplicationService articleApplicationService;
    @Autowired
    private RecommendRepository recommendRepository;

    public Banner addBanner(AddBannerCommand command) {
        Banner banner = Banner.create(command.getTitle(), command.getUrl(), command.getLink());
        webManageRepository.addBanner(banner);
        return banner;
    }

    public void removeBanner(String bannerId) {
        webManageRepository.removeBanner(bannerId);
    }

    public void addRecommendActivity(String activityId) {
        var activityRecommend = recommendRepository.findById(activityId);
        activityRecommend.setInterestedRecommend(true);
        recommendRepository.saveActivityInterested(activityRecommend);
    }

//    public void removeRecommendActivity(String activityId) {
//        recommendRepository.removeRecommendActivity(activityId);
//    }
//
//    public void addRecommendFoodGuides(List<String> articleIds) {
//        recommendRepository.saveRecommendCityArticleIds(articleIds);
//    }
//
//    public void removeRecommendFoodGuide(String articleId) {
//        recommendRepository.removeRecommendArticle(articleId);
//    }
//
//    public void addTopActivities(List<String> activityIds) {
//        recommendRepository.saveTopActivityIds(activityIds);
//    }
//
//    public void removeTopActivity(String activityId) {
//        recommendRepository.removeTopActivity(activityId);
//    }



}
