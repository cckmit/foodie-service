package com.foodie.portal.order;

import lombok.Data;

@Data
public class OrderInfo {
    private String surname;
    private String personalName;
    private String nationality;
    private IdType idType;
    private String idNumber;
    private String email;
    private String message;
}
