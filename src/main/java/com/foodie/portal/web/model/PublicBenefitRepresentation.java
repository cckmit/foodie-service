package com.foodie.portal.web.model;

import lombok.Data;

@Data
public class PublicBenefitRepresentation {
    private String title;
    private String image;
    private String description;
    private String content;
    private double totalFoundation;
    private double currentFoundation;
}
