package com.foodie.portal.public_benefit;


import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class PublicBenefitTest {

    @Test
    public void should_extract_from_order() {
        PublicBenefit publicBenefit = PublicBenefit.create("", "", BigDecimal.valueOf(0.03), BigDecimal.TEN);
        publicBenefit.extract(BigDecimal.valueOf(10));
        assertEquals(BigDecimal.valueOf(0.3).doubleValue(), publicBenefit.getCurrentFoundation().doubleValue(),0.01);
    }
}
