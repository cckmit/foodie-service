package com.foodie.portal.activity.representation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityRepresentationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ActivityRepresentation> findTopActivity() {
        String sql = "select a.* , m.NAME as merchant_name, c.NAME as city_name from FOODIE_ACTIVITY a left join FOODIE_MERCHANT m on a.MERCHANT_ID=m.ID " +
                "left join FOODIE_CITY c on a.CITY_ID=c.ID where TOP_RECOMMEND = 1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ActivityRepresentation.class));
    }
}
