package com.foodie.portal.web.representation;

import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.article.Article;
import com.foodie.portal.article.ArticleApplicationService;
import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.city.representation.CityRepresentationService;
import com.foodie.portal.city.representation.CitySummaryRepresentation;
import com.foodie.portal.webmanage.FeaturedAreasDto;
import com.foodie.portal.webmanage.RecommendRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndexRepresentationService {

    @Autowired
    private CityApplicationService cityApplicationService;
    @Autowired
    private ActivityApplicationService activityApplicationService;
    @Autowired
    private RecommendRepository recommendRepository;
    @Autowired
    private ArticleApplicationService articleApplicationService;

    /**
     * 推荐活动
     * @return
     */
    public List<FeaturedAreasDto> featuredActivity() {
        var activities = activityApplicationService.fetchActivitiesByIds(recommendRepository.findRecommendActivityIds());
       return  activities.stream().collect(Collectors.groupingBy(Activity::getCity)).entrySet().stream()
                .map(entry -> FeaturedAreasDto.toDto(entry.getKey(), entry.getValue()))
               .collect(Collectors.toList());
    }

    public List<Article> featuredCityFoodGuide() {
        return articleApplicationService.findArticlesByIds(recommendRepository.findRecommendActivityIds());
    }

    /**
     * 推荐活动
     * @return
     */
    public List<Activity> topRatedActivities() {
        return activityApplicationService.fetchActivitiesByIds(recommendRepository.findTopActivityIds());
    }


}
