package com.foodie.portal.webmanage.command;

import lombok.Data;

import java.util.List;

@Data
public class AddRecommendArticlesCommand {

    private List<String> articleIds;

}
