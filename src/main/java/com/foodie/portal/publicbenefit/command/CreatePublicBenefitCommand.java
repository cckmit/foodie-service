package com.foodie.portal.publicbenefit.command;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatePublicBenefitCommand {

    private String title;
    private String image;
    private String description;
    private String content;
    private double totalFoundation;
}
