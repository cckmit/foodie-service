package com.foodie.portal.web.service;

import com.foodie.portal.activity.ActivityApplicationService;
import com.foodie.portal.article.ArticleApplicationService;
import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.city.repository.CityJpaRepository;
import com.foodie.portal.web.model.ActivityRepresentation;
import com.foodie.portal.web.model.ArticleRepresentation;
import com.foodie.portal.web.model.CityRepresentation;
import com.foodie.portal.web.model.InterestedCityActivities;
import com.foodie.portal.web.model.PublicBenefitRepresentation;
import com.foodie.portal.web.model.PublicBenefitSummaryRepresentation;
import com.foodie.portal.web.model.RestaurantRepresentation;
import com.foodie.portal.web.po.RestaurantRepresentationPo;
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
import java.util.stream.Collectors;

import static com.foodie.portal.publicbenefit.PublicBenefitStatus.ACTIVATED;

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
     *
     * @return
     */
    public List<Banner> listBanner() {
        return bannerEntityMapper.to(bannerJpaRepository.findAll());
    }


    public InterestedCityActivities findInterestedActivityByCityId(String cityId) {

        var city = cityJpaRepository.getOne(cityId);

        String sql = "select a.*, a.PRICE_LIST as priceListStr , m.NAME as merchant_name, c.NAME as city_name from FOODIE_ACTIVITY a left join FOODIE_MERCHANT m on a.MERCHANT_ID=m.ID " +
                "left join FOODIE_CITY c on a.CITY_ID=c.ID where INTERESTED_RECOMMEND = 1 and a.CITY_ID=:cityId";
        List<ActivityRepresentation> activities = jdbcTemplate.query(sql, ImmutableMap.of("cityId", cityId), new BeanPropertyRowMapper<>(ActivityRepresentation.class));

        return InterestedCityActivities.of(city.getName(), city.getIntroduction(), city.getImages(), activities);
    }

    public List<ActivityRepresentation> findTopActivity() {
        String sql = "select a.* ,a.PRICE_LIST as priceListStr , m.NAME as merchant_name, c.NAME as city_name from FOODIE_ACTIVITY a left join FOODIE_MERCHANT m on a.MERCHANT_ID=m.ID " +
                "left join FOODIE_CITY c on a.CITY_ID=c.ID where TOP_RECOMMEND = 1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ActivityRepresentation.class));
    }


    public List<ArticleRepresentation> findInterestedFoodGuide() {
        String sql = "select a.* , c.NAME as city_name from FOODIE_ARTICLE a " +
                "left join FOODIE_CITY c on a.CITY_ID=c.ID where INTERESTED_RECOMMEND = 1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ArticleRepresentation.class));
    }

    public PublicBenefitSummaryRepresentation findActivatedPublicBenefit() {
        String sql = "select * from FOODIE_PUBLIC_BENEFIT p where p.STATUS=:status";
        return jdbcTemplate.queryForObject(sql, ImmutableMap.of("status", ACTIVATED.name()), new BeanPropertyRowMapper<>(PublicBenefitSummaryRepresentation.class));
    }

    public PublicBenefitRepresentation findActivatedPublicBenefitDetail() {
        String sql = "select * from FOODIE_PUBLIC_BENEFIT p where p.STATUS=:status";
        return jdbcTemplate.queryForObject(sql, ImmutableMap.of("status", ACTIVATED.name()), new BeanPropertyRowMapper<>(PublicBenefitRepresentation.class));
    }

    public List<RestaurantRepresentation> findInterestedRestaurantByCityId(String cityId) {
        String sql = "select r.* , c.NAME as city_name from FOODIE_RESTAURANT r " +
                "left join FOODIE_CITY c on r.CITY_ID=c.ID where r.INTERESTED_RECOMMEND = 1 and r.CITY_ID=:cityId";
        return jdbcTemplate.query(sql, ImmutableMap.of("cityId", cityId), new BeanPropertyRowMapper<>(RestaurantRepresentationPo.class))
                .stream()
                .map(RestaurantRepresentation::from)
                .collect(Collectors.toList());

    }
}
