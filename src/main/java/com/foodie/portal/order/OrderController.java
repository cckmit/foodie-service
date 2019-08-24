package com.foodie.portal.order;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "订单管理")
@RestController
@RequestMapping("order")
public class OrderController {

    List<Order> orders = JMockData.mock(new TypeReference<List<Order>>() {});

    @ApiOperation("订单列表")
    @GetMapping
    public List<Order> orders() {
        return orders;
    }
}
