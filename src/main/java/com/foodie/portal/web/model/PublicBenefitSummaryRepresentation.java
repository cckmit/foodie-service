package com.foodie.portal.web.model;

import lombok.Data;

@Data
public class PublicBenefitSummaryRepresentation {
    private String id;
    private String title;
    private String image;
    private String description;
    private double totalFoundation;
    private double currentFoundation;
}
