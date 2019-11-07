package com.foodie.portal.commons.event;

import com.foodie.portal.order.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderRejectedEvent extends DomainEvent {
    private Order order;

}
