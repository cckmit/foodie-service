package com.foodie.portal.webmanage;

import com.foodie.portal.webmanage.repository.RecommendEntity;
import com.foodie.portal.webmanage.repository.RecommendJpaRepository;
import com.foodie.portal.webmanage.repository.RecommendType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecommendRepository {

    @Autowired
    private RecommendJpaRepository recommendJpaRepository;


    public List<String> findRecommendActivityIds() {
        return recommendJpaRepository.findByType(RecommendType.RECOMMEND_ACTIVITIES)
                .stream().map(RecommendEntity::getId)
                .collect(Collectors.toList());
    }

    public List<String> findRecommendFoodGuideIds() {
        return recommendJpaRepository.findByType(RecommendType.RECOMMEND_FOOD_GUIDE)
                .stream().map(RecommendEntity::getId)
                .collect(Collectors.toList());
    }

    public List<String> findTopActivityIds() {
        return recommendJpaRepository.findByType(RecommendType.TOP_ACTIVITIES)
                .stream().map(RecommendEntity::getId)
                .collect(Collectors.toList());
    }

    /**
     * 保存推荐的活动
     *
     * @param activityIds
     */
    public void saveRecommendActivityIds(List<String> activityIds) {
        recommendJpaRepository.saveAll(activityIds.stream()
                .map(activityId -> new RecommendEntity(activityId, RecommendType.RECOMMEND_ACTIVITIES))
                .collect(Collectors.toList()));
    }

    /**
     * 删除推荐的活动
     *
     * @param activityId
     */
    public void removeRecommendActivity(String activityId) {
        recommendJpaRepository.delete(new RecommendEntity(activityId, RecommendType.RECOMMEND_ACTIVITIES));
    }

    /**
     * 保存推荐的美食指南
     *
     * @param articleIds
     */
    public void saveRecommendCityArticleIds(List<String> articleIds) {
        recommendJpaRepository.saveAll(articleIds.stream()
                .map(article -> new RecommendEntity(article, RecommendType.RECOMMEND_FOOD_GUIDE))
                .collect(Collectors.toList()));
    }

    /**
     * 删除推荐的美食指南
     *
     * @param articleId
     */
    public void removeRecommendArticle(String articleId) {
        recommendJpaRepository.delete(new RecommendEntity(articleId, RecommendType.RECOMMEND_FOOD_GUIDE));
    }


    public void saveTopActivityIds(List<String> activityIds) {
        recommendJpaRepository.saveAll(activityIds.stream()
                .map(article -> new RecommendEntity(article, RecommendType.TOP_ACTIVITIES))
                .collect(Collectors.toList()));
    }

    public void removeTopActivity(String activityId) {
        recommendJpaRepository.delete(new RecommendEntity(activityId, RecommendType.TOP_ACTIVITIES));
    }
}
