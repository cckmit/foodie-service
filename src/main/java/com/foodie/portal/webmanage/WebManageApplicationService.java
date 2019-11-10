package com.foodie.portal.webmanage;

import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.article.ArticleApplicationService;
import com.foodie.portal.webmanage.command.AddBannerCommand;
import com.foodie.portal.webmanage.model.ActivityRecommend;
import com.foodie.portal.webmanage.model.ArticleRecommend;
import com.foodie.portal.webmanage.model.Banner;
import com.foodie.portal.webmanage.model.RestaurantRecommend;
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
    private BannerRepository bannerRepository;
    @Autowired
    private ArticleApplicationService articleApplicationService;
    @Autowired
    private RecommendRepository recommendRepository;

    public Banner addBanner(AddBannerCommand command) {
        Banner banner = Banner.create(command.getTitle(), command.getSubTitle(), command.getUrl(), command.getLink());
        bannerRepository.save(banner);
        return banner;
    }

    public void removeBanner(String bannerId) {
        bannerRepository.removeBanner(bannerId);
    }

    public void updateBanner(String bannerId, AddBannerCommand command) {
        var banner = bannerRepository.byId(bannerId);
        banner.update(command.getTitle(), command.getSubTitle(), command.getUrl(), command.getLink());
        bannerRepository.save(banner);
    }

    public Banner detailBanner(String id) {
        return bannerRepository.byId(id);
    }

    public void addRecommendActivity(String activityId) {
        var activityRecommend = recommendRepository.findActivityById(activityId);
        activityRecommend.setInterestedRecommend(true);
        recommendRepository.saveActivityRecommend(activityRecommend);
    }

    public void deleteRecommendActivity(String activityId) {
        var activityRecommend = recommendRepository.findActivityById(activityId);
        activityRecommend.setInterestedRecommend(false);
        recommendRepository.saveActivityRecommend(activityRecommend);
    }


    public List<ActivityRecommend> listInterested(String cityId) {
        return recommendRepository.findAllInterestedActivities(cityId);
    }

    public List<ActivityRecommend> listTopActivities() {
        return recommendRepository.findAllTopActivities();
    }

    public void addTopActivity(String activityId) {
        var activityRecommend = recommendRepository.findActivityById(activityId);
        activityRecommend.setTopRecommend(true);
        recommendRepository.saveActivityRecommend(activityRecommend);
    }

    public void deleteTopActivity(String activityId) {
        var activityRecommend = recommendRepository.findActivityById(activityId);
        activityRecommend.setTopRecommend(false);
        recommendRepository.saveActivityRecommend(activityRecommend);
    }

    public List<ArticleRecommend> listFoodGuides(String cityId) {
        return recommendRepository.findAllInterestedArticles(cityId);
    }

    public void addRecommendFoodGuide(String articleId) {
        var articleRecommend = recommendRepository.findArticleById(articleId);
        articleRecommend.setInterestedRecommend(true);
        recommendRepository.saveArticleRecommend(articleRecommend);
    }

    public void deleteRecommendFoodGuide(String articleId) {
        var articleRecommend = recommendRepository.findArticleById(articleId);
        articleRecommend.setInterestedRecommend(false);
        recommendRepository.saveArticleRecommend(articleRecommend);
    }

    public List<Banner> listBanners() {
        return bannerRepository.findAllBanners();
    }

    public void addRecommendRestaurant(String restaurantId) {
        var restaurantRecommend = recommendRepository.findRestaurantById(restaurantId);
        restaurantRecommend.setInterestedRecommend(true);
        recommendRepository.saveRestaurantRecommend(restaurantRecommend);
    }


    public void deleteRecommendRestaurant(String restaurantId) {
        var restaurantRecommend = recommendRepository.findRestaurantById(restaurantId);
        restaurantRecommend.setInterestedRecommend(false);
        recommendRepository.saveRestaurantRecommend(restaurantRecommend);
    }

    public List<RestaurantRecommend> listInterestedRestaurant(String cityId) {
        return recommendRepository.findAllInterestedRestaurant(cityId);
    }



}
