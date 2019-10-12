package com.foodie.portal.webmanage;

import com.foodie.portal.webmanage.model.ActivityRecommend;
import com.foodie.portal.webmanage.model.ArticleRecommend;
import com.foodie.portal.webmanage.repository.ActivityRecommendEntityMapper;
import com.foodie.portal.webmanage.repository.ActivityRecommendJpaRepository;
import com.foodie.portal.webmanage.repository.ArticleRecommendEntityMapper;
import com.foodie.portal.webmanage.repository.ArticleRecommendJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecommendRepository {

    @Autowired
    private ActivityRecommendJpaRepository activityRecommendJpaRepository;
    private ActivityRecommendEntityMapper activityRecommendEntityMapper = ActivityRecommendEntityMapper.instance;
    @Autowired
    private ArticleRecommendJpaRepository articleRecommendJpaRepository;
    private ArticleRecommendEntityMapper articleRecommendEntityMapper  = ArticleRecommendEntityMapper.instance;

    public ActivityRecommend findActivityById(String activityId) {
        return activityRecommendJpaRepository.findById(activityId)
                .map(activityRecommendEntityMapper::to)
                .orElse(null);
    }

    public void saveActivityRecommend(ActivityRecommend activityRecommend) {
        activityRecommendJpaRepository.save(activityRecommendEntityMapper.from(activityRecommend));
    }

    public List<ActivityRecommend> findAllInterestedActivities(String cityId) {
        return activityRecommendEntityMapper.to(activityRecommendJpaRepository.findByInterestedRecommendAndCityId(true, cityId));
    }


    public List<ActivityRecommend> findAllTopActivities() {
        return activityRecommendEntityMapper.to(activityRecommendJpaRepository.findByTopRecommend(true));
    }

    public List<ArticleRecommend> findAllInterestedArticles(String cityId) {
        return articleRecommendEntityMapper.to(articleRecommendJpaRepository.findByInterestedRecommendAndCityId(true, cityId));
    }

    public ArticleRecommend findArticleById(String id){
        return articleRecommendJpaRepository.findById(id)
                .map(articleRecommendEntityMapper::to)
                .orElse(null);
    }

    public void saveArticleRecommend(ArticleRecommend articleRecommend) {
        articleRecommendJpaRepository.save(articleRecommendEntityMapper.from(articleRecommend));
    }
}
