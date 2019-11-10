package com.foodie.portal.web.service;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.activity.model.ActivityType;
import com.foodie.portal.activity.repository.ActivityJpaRepository;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.favourite.FavouriteType;
import com.foodie.portal.favourite.repository.FavouriteJpaRepository;
import com.foodie.portal.user.model.User;
import com.foodie.portal.web.model.ActivityDetailRepresentation;
import com.foodie.portal.web.model.ActivityRepresentation;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.google.common.collect.Maps.newHashMap;

@Service
public class ActivityRepresentationService {

    private final static String LIMIT_SQL = " limit :size offset :offset";
    private final static String SORT_SQL = " order by sort";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ActivityJpaRepository activityJpaRepository;
    @Autowired
    private FavouriteJpaRepository favouriteJpaRepository;



    public Pagination<ActivityRepresentation> findAllByCityId(int page, int size, String cityId) {

        String sql = "select a.* ,a.PRICE_LIST as priceListStr, m.NAME as merchant_name, c.NAME as city_name from FOODIE_ACTIVITY a left join FOODIE_MERCHANT m on a.MERCHANT_ID=m.ID " +
                "left join FOODIE_CITY c on a.CITY_ID=c.ID where a.CITY_ID = :cityId";
         sql = sql.concat(SORT_SQL).concat(LIMIT_SQL);
        List<ActivityRepresentation> activityRepresentations = jdbcTemplate.query(sql,
                ImmutableMap.of("cityId", cityId, "offset", (page - 1) * size, "size", size),
                new BeanPropertyRowMapper<>(ActivityRepresentation.class));

        String countSql = "select count(1) from FOODIE_ACTIVITY a where a.CITY_ID = :cityId ";
        int total = jdbcTemplate.queryForObject(countSql, ImmutableMap.of("cityId", cityId), Integer.class);

        return Pagination.of(total, page, size, activityRepresentations);
    }

    public Pagination<ActivityRepresentation> findAllByCityIdAndType(int page, int size, String cityId, ActivityType type) {
        String sql = "select a.* ,a.PRICE_LIST as priceListStr, m.NAME as merchant_name, c.NAME as city_name from FOODIE_ACTIVITY a left join FOODIE_MERCHANT m on a.MERCHANT_ID=m.ID " +
                "left join FOODIE_CITY c on a.CITY_ID=c.ID where a.CITY_ID = :cityId and a.TYPE=:type";
        sql = sql.concat(SORT_SQL).concat(LIMIT_SQL);
        List<ActivityRepresentation> activityRepresentations = jdbcTemplate.query(sql,
                ImmutableMap.of("cityId", cityId, "offset", (page - 1) * size,
                        "size", size, "type", type.name()),
                new BeanPropertyRowMapper<>(ActivityRepresentation.class));

        String countSql = "select count(1) from FOODIE_ACTIVITY a where a.CITY_ID = :cityId and a.TYPE=:type ";
        int total = jdbcTemplate.queryForObject(countSql,
                ImmutableMap.of("cityId", cityId, "type", type.name()), Integer.class);

        return Pagination.of(total, page, size, activityRepresentations);
    }

    public ActivityDetailRepresentation findActivityDetail(String id, User user) {
        return activityJpaRepository.findById(id)
                .map(ActivityDetailRepresentation::from)
                .map(rep -> {
                    Optional.ofNullable(user)
                            .map(it -> favouriteJpaRepository.findByObjectIdAndTypeAndUserId(id, FavouriteType.ACTIVITY, it.getId()))
                            .ifPresent(it -> rep.setFavourite(true));
                    return rep;
                })
                .orElse(null);


    }
}
