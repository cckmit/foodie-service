package com.foodie.portal.activity.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ActivityDateTime {

    private Date date;

    private List<String> times;

}
