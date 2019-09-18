package com.foodie.portal.publicbenefit;


import com.foodie.portal.order.Order;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;


public class PublicBenefitTest {

    @Test
    public void should_extract_from_order() {
        PublicBenefit publicBenefit = PublicBenefit.create("", "", BigDecimal.TEN);
        Order order = spy(new Order());
        order.setBenefitExtractRatio(BigDecimal.valueOf(0.03));
        given(order.getPrice()).willReturn(BigDecimal.valueOf(10));
        publicBenefit.extract(order);
        assertEquals(BigDecimal.valueOf(0.3).doubleValue(), publicBenefit.getCurrentFoundation().doubleValue(),0.01);
    }
}
