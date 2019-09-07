package com.foodie.portal.commons.event;

import com.foodie.portal.order.Order;
import lombok.Data;

@Data
public class OrderFinishedEvent {
    private Order order;
}
