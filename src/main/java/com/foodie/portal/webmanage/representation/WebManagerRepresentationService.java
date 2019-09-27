package com.foodie.portal.webmanage.representation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class WebManagerRepresentationService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


}
