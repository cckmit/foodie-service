package com.foodie.portal.commons.event;

import com.foodie.portal.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderAcceptedEvent {
    private Order order;
}
