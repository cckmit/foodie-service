package com.foodie.portal.web.service;

import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.article.ArticleApplicationService;
import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.city.repository.CityJpaRepository;
import com.foodie.portal.web.model.ActivityRepresentation;
import com.foodie.portal.web.model.CityRepresentation;
import com.foodie.portal.web.model.InterestedCityActivities;
import com.foodie.portal.webmanage.model.Banner;
import com.foodie.portal.webmanage.RecommendRepository;
import com.foodie.portal.webmanage.repository.BannerEntityMapper;
import com.foodie.portal.webmanage.repository.BannerJpaRepository;
import com.google.common.collect.ImmutableMap;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexRepresentationService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private BannerJpaRepository bannerJpaRepository;
    private BannerEntityMapper bannerEntityMapper = BannerEntityMapper.instance;
    @Autowired
    private CityJpaRepository cityJpaRepository;

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

    public InterestedCityActivities findByInterestedByCityId(String cityId) {

       var city =  cityJpaRepository.getOne(cityId);

        String sql = "select a.* , m.NAME as merchant_name, c.NAME as city_name from FOODIE_ACTIVITY a left join FOODIE_MERCHANT m on a.MERCHANT_ID=m.ID " +
                "left join FOODIE_CITY c on a.CITY_ID=c.ID where INTERESTED_RECOMMEND = 1 and a.CITY_ID=:cityId";
        List<ActivityRepresentation> activities =  jdbcTemplate.query(sql, ImmutableMap.of("cityId", cityId), new BeanPropertyRowMapper<>(ActivityRepresentation.class));

        return InterestedCityActivities.of(city.getName(), city.getIntroduction(), city.getImages(),activities );
    }


}