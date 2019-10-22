package com.foodie.portal.order.command;

import lombok.Data;

@Data
public class OrderPaySuccessCommand {

    private String paymentId;
    private String payerId;
    private String orderNo;
}
