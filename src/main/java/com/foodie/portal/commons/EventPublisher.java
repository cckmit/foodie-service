package com.foodie.portal.commons;

import com.foodie.portal.commons.event.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publish(DomainEvent event){
        applicationContext.publishEvent(event);
    }

}
