package com.foodie.portal.web.city;

import com.foodie.portal.city.representation.CitySummaryRepresentation;
import com.foodie.portal.commons.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Maps.newHashMap;

@Service("userCityRepresentationService")
public class CityRepresentationService {

    public static final String SELECT_SQL = "SELECT * FROM FOODIE_CITY LIMIT :limit OFFSET :offset;";
    public static final String COUNT_SQL = "SELECT COUNT(1) FROM FOODIE_CITY;";

    @Autowired
    private  NamedParameterJdbcTemplate jdbcTemplate;

    public List<CityRepresentation> listCities() {
        String sql = "SELECT * FROM FOODIE_CITY";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(CityRepresentation.class));

    }

}
