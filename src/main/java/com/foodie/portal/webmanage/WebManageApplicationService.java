package com.foodie.portal.webmanage;

import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.article.ArticleApplicationService;
import com.foodie.portal.webmanage.command.AddBannerCommand;
import com.foodie.portal.webmanage.model.ActivityRecommend;
import com.foodie.portal.webmanage.model.ArticleRecommend;
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
        var activityRecommend = recommendRepository.findActivityById(activityId);
        activityRecommend.setInterestedRecommend(true);
        recommendRepository.saveActivityRecommend(activityRecommend);
    }

    public List<ActivityRecommend> listInterested() {
        return recommendRepository.findAllInterestedActivities();
    }

    public List<ActivityRecommend> listTopActivities() {
        return recommendRepository.findAllTopActivities();
    }

    public void addTopActivity(String activityId) {
        var activityRecommend = recommendRepository.findActivityById(activityId);
        activityRecommend.setTopRecommend(true);
        recommendRepository.saveActivityRecommend(activityRecommend);
    }

    public List<ArticleRecommend> listFoodGuides() {
        return recommendRepository.findAllInterestedArticles();
    }

    public void addRecommendFoodGuide(String articleId) {
        var articleRecommend = recommendRepository.findArticleById(articleId);
        articleRecommend.setInterestedRecommend(true);
        recommendRepository.saveArticleRecommend(articleRecommend);
    }

    public List<Banner> listBanners() {
        return webManageRepository.findAllBanners();
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
//    public void removeTopActivity(String activityId) {
//        recommendRepository.removeTopActivity(activityId);
//    }



}
