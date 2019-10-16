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
        String sql = "select * from FOODIE_ACTIVITY where TOP_RECOMMEND = true";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ActivityRepresentation.class));
    }
}
