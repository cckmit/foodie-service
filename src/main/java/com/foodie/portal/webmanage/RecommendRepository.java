package com.foodie.portal.webmanage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.city.City;
import com.foodie.portal.commons.utils.JsonUtils;
import com.foodie.portal.webmanage.repository.ListStringConverter;
import com.foodie.portal.webmanage.repository.MapStringListConverter;
import com.foodie.portal.webmanage.repository.SysConfigRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Convert;
import java.util.List;
import java.util.Map;

@Component
public class RecommendRepository {

    private static final String RECOMMEND_CITY_ACTIVITIES = "recommendCityActivities";
    private List<String> recommendArticles;
    private List<String> recommendActivities;

    @Autowired
    private SysConfigRepository sysConfigRepository;



    public Recommend findRecommend() {
        Recommend recommend = new Recommend();
        var value = sysConfigRepository.getOne(RECOMMEND_CITY_ACTIVITIES).getConfigValue();
        recommend.setRecommendCityActivities(JsonUtils.toBean(value, new TypeReference<Map<String, List<String>>>() {
        }));

        return recommend;
    }
}
