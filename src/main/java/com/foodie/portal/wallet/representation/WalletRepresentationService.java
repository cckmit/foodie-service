package com.foodie.portal.wallet.representation;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletRepresentationService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<IncomeItemRepresentation> listServiceIncome(String merchantId) {
        String sql = "select * from FOODIE_INCOME_ITEM where MERCHANT_ID=:merchantId";
        return jdbcTemplate.query(sql,
                ImmutableMap.of("merchantId" ,merchantId),
                new BeanPropertyRowMapper<>(IncomeItemRepresentation.class));
    }

    public List<WithdrawalRepresentation> listWithdrawal(String merchantId) {
        String sql = "select * from FOODIE_WITHDRAWAL_ITEM where MERCHANT_ID=:merchantId";
        return jdbcTemplate.query(sql,
                ImmutableMap.of("merchantId" ,merchantId),
                new BeanPropertyRowMapper<>(WithdrawalRepresentation.class));
    }

    public void updateWithdrawInfo() {

    }
}
