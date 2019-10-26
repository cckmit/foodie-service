package com.foodie.portal.order.model;

import com.foodie.portal.commons.model.IdType;
import lombok.Data;

@Data
public class OrderInfo {
    private String lastName;
    private String firstName;
    private String nationality;
    private IdType idType;
    private String idNumber;
    private String email;
    private String message;
}
