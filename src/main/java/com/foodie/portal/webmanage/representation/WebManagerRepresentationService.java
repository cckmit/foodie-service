package com.foodie.portal.webmanage.representation;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.activity.repository.ActivityJpaRepository;
import com.foodie.portal.webmanage.repository.RecommendType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.foodie.portal.webmanage.repository.RecommendType.ALL;
import static com.foodie.portal.webmanage.repository.RecommendType.RECOMMEND;
import static com.foodie.portal.webmanage.repository.RecommendType.TOP;

@Service
public class WebManagerRepresentationService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<RecommendActivityRepresentation> listRecommendActivities() {
        String sql = "select * from foodie_activity where recommend_type in (:recommendTypes)";
        return jdbcTemplate.queryForList(sql,
                ImmutableMap.of("recommendTypes", ImmutableList.of(RECOMMEND, ALL)),
                RecommendActivityRepresentation.class);

    }

    public List<RecommendActivityRepresentation> listTopActivities() {
        String sql = "select * from foodie_activity where recommend_type in (:recommendTypes)";
        return jdbcTemplate.queryForList(sql,
                ImmutableMap.of("recommendTypes", ImmutableList.of(TOP, ALL)),
                RecommendActivityRepresentation.class);
    }
}
