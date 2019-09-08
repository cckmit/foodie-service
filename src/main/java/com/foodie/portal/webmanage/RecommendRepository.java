package com.foodie.portal.webmanage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.commons.utils.JsonUtils;
import com.foodie.portal.webmanage.repository.SysConfigEntity;
import com.foodie.portal.webmanage.repository.SysConfigRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RecommendRepository {

    private static final String RECOMMEND_CITY_ACTIVITY_IDS = "RECOMMEND_CITY_ACTIVITY_IDS";
    private static final String RECOMMEND_CITY_ACTIVITY_IDS_DESC = "首页推荐城市活动配置";
    private static final String RECOMMEND_CITY_ARTICLE_IDS = "RECOMMEND_CITY_ARTICLE_IDS";
    private static final String RECOMMEND_CITY_ARTICLE_IDS_DESC = "首页推荐城市文章配置";
    private static final String TOP_ACTIVITIES = "TOP_ACTIVITIES";
    private static final String TOP_ACTIVITIES_DESC = "首页推荐活动配置";
    private static final String TOP_ARTICLES = "TOP_ARTICLES";
    private static final String TOP_ARTICLES_DESC = "首页推荐文章配置";

    @Autowired
    private SysConfigRepository sysConfigRepository;


    public Map<String, List<String>> findRecommendCityActivityIds() {
        var value = sysConfigRepository.getOne(RECOMMEND_CITY_ACTIVITY_IDS).getConfigValue();
        return JsonUtils.toBean(value, new TypeReference<Map<String, List<String>>>() {
        });
    }

    public Map<String, List<String>> findRecommendCityFoodGuideIds() {
        var value = sysConfigRepository.getOne(RECOMMEND_CITY_ARTICLE_IDS).getConfigValue();
        return JsonUtils.toBean(value, new TypeReference<Map<String, List<String>>>() {});
    }

    public List<String> findTopActivityIds() {
        var value = sysConfigRepository.getOne(TOP_ACTIVITIES).getConfigValue();
        return JsonUtils.toBean(value, new TypeReference<List<String>>() {
        });
    }
    public List<String> findTopFoodGuideIds() {
        return sysConfigRepository.findById(TOP_ACTIVITIES)
                .map(config -> JsonUtils.toBean(config.getConfigValue(), new TypeReference<List<String>>() {
                })).orElse(null);

    }

    /**
     * 保存推荐的城市活动
     * @param value
     */
    public void saveRecommendCityActivityIds(Map<String, List<String>> value) {
        saveConfig(value, RECOMMEND_CITY_ACTIVITY_IDS, RECOMMEND_CITY_ACTIVITY_IDS_DESC);

    }

    /**
     * 保存推荐的城市文章
     * @param value
     */
    public void saveRecommendCityArticleIds(Map<String, List<String>> value) {
        saveConfig(value, RECOMMEND_CITY_ARTICLE_IDS, RECOMMEND_CITY_ARTICLE_IDS_DESC);
    }

    /**
     * 保存首页的推荐活动
     * @param value
     */
    public void saveTopActivities(List<String> value) {
        saveConfig(value, TOP_ACTIVITIES, TOP_ACTIVITIES_DESC);
    }

    /**
     * 保存首页的推荐文章
     * @param value
     */
    public void saveTopArticles(List<String> value) {
        saveConfig(value, TOP_ARTICLES, TOP_ARTICLES_DESC);
    }


    private void saveConfig(Object value, String key, String description) {
        var valueStr = JsonUtils.toJsonStr(value);
        var entity = sysConfigRepository.findById(key).map(sysConfigEntity -> {
            sysConfigEntity.setConfigValue(valueStr);
            return sysConfigEntity;
        }).orElse(new SysConfigEntity(key, valueStr, description));

        sysConfigRepository.save(entity);
    }


}
