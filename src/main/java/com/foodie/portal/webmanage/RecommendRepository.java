package com.foodie.portal.webmanage;

import com.foodie.portal.webmanage.model.ActivityRecommend;
import com.foodie.portal.webmanage.repository.ActivityRecommendEntity;
import com.foodie.portal.webmanage.repository.ActivityRecommendEntityMapper;
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
    private ActivityRecommendEntityMapper activityRecommendEntityMapper = ActivityRecommendEntityMapper.instance;

    public ActivityRecommend findById(String activityId) {
        return recommendJpaRepository.findById(activityId)
                .map(activityRecommendEntityMapper::to)
                .orElse(null);
    }

    public void saveActivityInterested(ActivityRecommend activityRecommend) {
        recommendJpaRepository.save(activityRecommendEntityMapper.from(activityRecommend));
    }


}
