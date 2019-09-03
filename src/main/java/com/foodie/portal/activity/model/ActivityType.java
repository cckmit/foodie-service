package com.foodie.portal.activity.model;

public enum  ActivityType {
    TOURS("food tours"),
    COOKING("cooking classes"),
    TASTINGS("tastings"),
    RESTAURANTS("restaurants reservation");

    private String description;

    ActivityType(String description){
        this.description = description;
    }
}

