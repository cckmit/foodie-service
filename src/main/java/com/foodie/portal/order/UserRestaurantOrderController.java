package com.foodie.portal.order;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.command.CreateOrderCommand;
import com.foodie.portal.order.command.CreateRestaurantOrderCommand;
import com.foodie.portal.order.command.OrderPayCancelCommand;
import com.foodie.portal.order.command.OrderPaySuccessCommand;
import com.foodie.portal.order.command.PayOrderCommand;
import com.foodie.portal.order.dto.OrderInfoDto;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.model.RestaurantOrder;
import com.foodie.portal.order.representation.OrderDetailRepresentation;
import com.foodie.portal.order.representation.OrderRepresentationService;
import com.foodie.portal.order.representation.OrderSummaryRepresentation;
import com.foodie.portal.order.representation.RestaurantOrderSummaryRepresentation;
import com.foodie.portal.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "（用户）订单功能")
@RestController
@RequestMapping("user/order/restaurant")
public class UserRestaurantOrderController {

    @Autowired
    private OrderApplicationService orderApplicationService;
    @Autowired
    private OrderRepresentationService orderRepresentationService;


    @ApiOperation("用户餐馆下单")
    @PostMapping
    public RestaurantOrder createRestaurantOrder(@RequestBody CreateRestaurantOrderCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.createRestaurantOrder(command, user);
    }

    @ApiOperation("我的餐馆订单列表")
    @GetMapping("list")
    public Pagination<RestaurantOrderSummaryRepresentation> restaurantOrders(PageCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderRepresentationService.myRestaurantOrderList(command.getPage(), command.getSize(), user);
    }

}
