package com.foodie.portal.order;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.Order;
import com.foodie.portal.order.OrderApplicationService;
import com.foodie.portal.order.representation.OrderDetailRepresentation;
import com.foodie.portal.order.representation.OrderRepresentationService;
import com.foodie.portal.order.representation.OrderSummaryRepresentation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（管理员）订单管理")
@RestController
@RequestMapping("admin/order")
public class AdminOrderController {

    @Autowired
    private OrderRepresentationService orderRepresentationService;

    @ApiOperation("订单列表")
    @GetMapping
    public Pagination<OrderSummaryRepresentation> orders(PageCommand command) {
        return orderRepresentationService.orderList(command.getPage(), command.getSize());
    }

    @ApiOperation("订单详情")
    @GetMapping("{id}")
    public OrderDetailRepresentation detail(@PathVariable String id) {
        return orderRepresentationService.findById(id);
    }

}
