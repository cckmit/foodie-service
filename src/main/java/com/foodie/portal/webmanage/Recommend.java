package com.foodie.portal.webmanage;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Recommend {

    private Map<String, List<String>> recommendCityActivities;

    private List<String> recommendArticles;

    private List<String> recommendActivities;
}
