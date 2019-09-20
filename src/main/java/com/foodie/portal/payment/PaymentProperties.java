package com.foodie.portal.payment;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "application.payment")
public class PaymentProperties {

    private Paypal paypal;

    @Data
    public static class Paypal {
        private String clientId;
        private String clientSecret;
        private String mode;
    }
}
