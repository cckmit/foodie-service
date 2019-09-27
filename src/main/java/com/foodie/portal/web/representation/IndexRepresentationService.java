package com.foodie.portal.web.representation;

import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.article.ArticleApplicationService;
import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.webmanage.model.Banner;
import com.foodie.portal.webmanage.RecommendRepository;
import com.foodie.portal.webmanage.repository.BannerEntityMapper;
import com.foodie.portal.webmanage.repository.BannerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private BannerJpaRepository bannerJpaRepository;
    private BannerEntityMapper bannerEntityMapper = BannerEntityMapper.instance;

    /**
     * 获取首页banner列表
     * @return
     */
    public List<Banner> listBanner() {
        return bannerEntityMapper.to(bannerJpaRepository.findAll());
    }

//    /**
//     * 推荐活动
//     * @return
//     */
//    public List<FeaturedAreasDto> featuredActivity() {
//        var activities = activityApplicationService.fetchActivitiesByIds(recommendRepository.findRecommendActivityIds());
//       return  activities.stream().collect(Collectors.groupingBy(Activity::getCity)).entrySet().stream()
//                .map(entry -> FeaturedAreasDto.toDto(entry.getKey(), entry.getValue()))
//               .collect(Collectors.toList());
//    }
//
//    public List<Article> featuredCityFoodGuide() {
//        return articleApplicationService.findArticlesByIds(recommendRepository.findRecommendActivityIds());
//    }
//
//    /**
//     * 推荐活动
//     * @return
//     */
//    public List<Activity> topRatedActivities() {
//        return activityApplicationService.fetchActivitiesByIds(recommendRepository.findTopActivityIds());
//    }


}
