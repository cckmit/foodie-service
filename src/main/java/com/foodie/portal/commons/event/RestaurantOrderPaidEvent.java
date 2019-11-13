package com.foodie.portal.commons.event;

import com.foodie.portal.order.model.RestaurantOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestaurantOrderPaidEvent extends DomainEvent {
    private RestaurantOrder order;
}
