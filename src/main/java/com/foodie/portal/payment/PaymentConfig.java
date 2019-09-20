package com.foodie.portal.payment;

import com.paypal.base.rest.APIContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PaymentProperties.class)
public class PaymentConfig {

    @Autowired
    private PaymentProperties properties;

    @Bean
    public APIContext apiContext()  {
        return new APIContext(properties.getPaypal().getClientId(),
                properties.getPaypal().getClientSecret(),
                properties.getPaypal().getMode());
    }
}
