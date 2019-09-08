package com.foodie.portal.webmanage.command;

import lombok.Data;

import java.util.List;

@Data
public class AddRecommendActivitiesCommand {

    private List<String> activityIds;

}
