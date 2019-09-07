package com.foodie.portal.commons.event;

import com.foodie.portal.order.Order;
import lombok.Getter;

@Getter
public class OrderFinishedEvent extends DomainEvent{
    private Order order;
}
