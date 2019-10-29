package com.foodie.portal.order;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.representation.OrderDetailRepresentation;
import com.foodie.portal.order.representation.OrderRepresentationService;
import com.foodie.portal.order.representation.OrderSummaryRepresentation;
import com.foodie.portal.order.representation.RestaurantOrderDetailRepresentation;
import com.foodie.portal.order.representation.RestaurantOrderSummaryRepresentation;
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

    @ApiOperation("活动订单列表")
    @GetMapping("activity/list")
    public Pagination<OrderSummaryRepresentation> activityOrders(PageCommand command) {
        return orderRepresentationService.activityOrderList(command.getPage(), command.getSize());
    }

    @ApiOperation("活动订单详情")
    @GetMapping("activity/{id}")
    public OrderDetailRepresentation activityOrderDetail(@PathVariable String id) {
        return orderRepresentationService.findActivityOrderById(id);
    }

    @ApiOperation("餐厅订单列表")
    @GetMapping("restaurant/list")
    public Pagination<RestaurantOrderSummaryRepresentation> restaurantOrders(PageCommand command) {
        return orderRepresentationService.restaurantOrderList(command.getPage(), command.getSize());
    }

    @ApiOperation("餐厅订单详情")
    @GetMapping("restaurant/{id}")
    public RestaurantOrderDetailRepresentation restaurantOrderDetail(@PathVariable String id) {
        return orderRepresentationService.findRestaurantOrderById(id);
    }

}
