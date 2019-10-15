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
        PublicBenefit publicBenefit = PublicBenefit.create("", "", 10);
        Order order = spy(new Order());
        order.setBenefitExtract(0.3);
        given(order.getPrice()).willReturn(10.0);
        publicBenefit.extract(order);
        assertEquals(BigDecimal.valueOf(0.3).doubleValue(), publicBenefit.getCurrentFoundation(),0.01);
    }
}
