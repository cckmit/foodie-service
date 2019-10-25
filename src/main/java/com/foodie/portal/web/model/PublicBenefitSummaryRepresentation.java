package com.foodie.portal.web.model;

import cn.hutool.core.util.NumberUtil;
import lombok.Data;

@Data
public class PublicBenefitSummaryRepresentation {
    private String id;
    private String title;
    private String image;
    private String description;
    private double totalFoundation;
    private double currentFoundation;
    private double percent;

    public double getPercent() {
        if (totalFoundation == 0) {
            return 0;
        }
        return NumberUtil.div(currentFoundation, totalFoundation, 4) * 100;
    }

}
