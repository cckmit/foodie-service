package com.foodie.portal.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publish(Object event){
        applicationContext.publishEvent(event);
    }

}
