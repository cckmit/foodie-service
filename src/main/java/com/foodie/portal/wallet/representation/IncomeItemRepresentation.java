package com.foodie.portal.wallet.representation;

import lombok.Data;

import java.time.Instant;

@Data
public class IncomeItemRepresentation {
    private String name;
    private Instant date;
    private Double amount;
}
