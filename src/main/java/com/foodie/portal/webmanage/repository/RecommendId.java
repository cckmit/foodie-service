package com.foodie.portal.webmanage.repository;

import lombok.Data;

import java.io.Serializable;

@Data
public class RecommendId implements Serializable {
    private String id;
    private RecommendType type;
}
