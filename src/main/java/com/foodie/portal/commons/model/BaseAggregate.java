package com.foodie.portal.commons.model;

import com.foodie.portal.commons.event.DomainEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

public abstract class BaseAggregate {

    private ApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();

    protected void raiseEvent(DomainEvent event) {
        applicationContext.publishEvent(event);
    }
}
