package com.foodie.portal.web.service;

import com.foodie.portal.city.repository.CityJpaRepository;
import com.foodie.portal.web.model.CityDetailRepresentation;
import com.foodie.portal.web.model.CityRepresentation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Maps.newHashMap;

@Service("userCityRepresentationService")
public class CityRepresentationService {

    public static final String SELECT_SQL = "SELECT * FROM FOODIE_CITY LIMIT :limit OFFSET :offset;";
    public static final String COUNT_SQL = "SELECT COUNT(1) FROM FOODIE_CITY;";

    @Autowired
    private  NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private CityJpaRepository cityJpaRepository;

    public List<CityRepresentation> listCities() {
        String sql = "SELECT * FROM FOODIE_CITY";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(CityRepresentation.class));
    }

    public List<CityRepresentation> listActivityCities() {
        String sql = "SELECT * FROM FOODIE_CITY where SHOW_ON_ACTIVITY=1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(CityRepresentation.class));
    }

    public List<CityRepresentation> listRestaurantCities() {
        String sql = "SELECT * FROM FOODIE_CITY where SHOW_ON_RESTAURANT=1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(CityRepresentation.class));
    }

    public CityDetailRepresentation detail(String id) {
        var city = cityJpaRepository.getOne(id);
        return CityDetailRepresentation.from(city);
    }
}
