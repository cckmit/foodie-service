package com.foodie.portal.webmanage.command;

import lombok.Data;

import java.util.List;

@Data
public class AddTopActivitiesCommand {

    private List<String> activityIds;

}
