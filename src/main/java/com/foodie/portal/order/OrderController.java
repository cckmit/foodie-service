package com.foodie.portal.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "（管理员）订单管理")
@RestController
@RequestMapping("order")
public class OrderController {


    @ApiOperation("订单列表")
    @GetMapping
    public List<Order> orders() {
        return null;
    }

}
