package com.foodie.portal.user.representation;

import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.repository.MerchantEntity;
import com.foodie.portal.user.repository.MerchantJpaRepository;
import com.google.common.collect.ImmutableMap;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MerchantRepresentationService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public MerchantInfoRepresentation info(String id) {
        String merchantSql = "select * from FOODIE_MERCHANT where ID=:id";
        var merchantInfoRepresentation = jdbcTemplate.queryForObject(merchantSql, ImmutableMap.of("id", id), new BeanPropertyRowMapper<>(MerchantInfoRepresentation.class));

        String sql = "select COUNT(1) from FOODIE_ORDER where MERCHANT_ID=:merchantId";
        var orderCount = jdbcTemplate.queryForObject(sql, ImmutableMap.of("merchantId", id), Integer.class);
        return merchantInfoRepresentation.setOrderCount(orderCount);
    }

}
