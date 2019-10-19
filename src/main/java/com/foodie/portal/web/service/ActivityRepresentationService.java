package com.foodie.portal.web.service;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.web.model.ActivityRepresentation;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Maps.newHashMap;

@Service
public class ActivityRepresentationService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<ActivityRepresentation> findTopActivity() {
        String sql = "select a.* , m.NAME as merchant_name, c.NAME as city_name from FOODIE_ACTIVITY a left join FOODIE_MERCHANT m on a.MERCHANT_ID=m.ID " +
                "left join FOODIE_CITY c on a.CITY_ID=c.ID where TOP_RECOMMEND = 1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ActivityRepresentation.class));
    }


    public Pagination<ActivityRepresentation> findAllByCityId(int page, int size, String cityId) {

        String sql = "select a.* , m.NAME as merchant_name, c.NAME as city_name from FOODIE_ACTIVITY a left join FOODIE_MERCHANT m on a.MERCHANT_ID=m.ID " +
                "left join FOODIE_CITY c on a.CITY_ID=c.ID where a.CITY_ID = :cityId limit :size offset :offset";
        List<ActivityRepresentation> activityRepresentations = jdbcTemplate.query(sql,
                ImmutableMap.of("cityId", cityId, "offset", (page - 1) * size, "size", size),
                new BeanPropertyRowMapper<>(ActivityRepresentation.class));

        String countSql = "select count(1) from FOODIE_ACTIVITY a where a.CITY_ID = :cityId ";
        int total = jdbcTemplate.queryForObject(countSql, ImmutableMap.of("cityId", cityId), Integer.class);

        return Pagination.of(total, page, size, activityRepresentations);
    }
}
