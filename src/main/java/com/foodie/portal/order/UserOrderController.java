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
@RequestMapping("user/order")
public class UserOrderController {

    @Autowired
    private OrderApplicationService orderApplicationService;
    @Autowired
    private OrderRepresentationService orderRepresentationService;

    @ApiOperation("用户活动下单")
    @PostMapping("activity")
    public Order createActivityOrder(@RequestBody CreateOrderCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.create(command, user);
    }

    @ApiOperation("用户餐馆下单")
    @PostMapping("restaurant")
    public RestaurantOrder createRestaurantOrder(@RequestBody CreateRestaurantOrderCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.createRestaurantOrder(command, user);
    }

    @ApiOperation("我的活动订单列表")
    @GetMapping("/activity/list")
    public Pagination<OrderSummaryRepresentation> activityOrders(PageCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderRepresentationService.myOrderList(command.getPage(), command.getSize(), user);
    }

    @ApiOperation("我的活动订单列表")
    @GetMapping("/restaurant/list")
    public Pagination<OrderSummaryRepresentation> restaurantOrders(PageCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderRepresentationService.myOrderList(command.getPage(), command.getSize(), user);
    }

    @ApiOperation("我的订单详情")
    @GetMapping("activity/{id}")
    public OrderDetailRepresentation detail(@PathVariable String id) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderRepresentationService.findByIdAndUserId(id, user.getId());
    }

    @ApiOperation("用户付款")
    @PostMapping("/{id}/payment")
    public String pay(@PathVariable(name = "id") String id, @RequestBody @Valid PayOrderCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.prePay(id, command);
    }

    @ApiOperation("支付成功")
    @PostMapping("pay/success")
    public OrderInfoDto successPay(@RequestBody OrderPaySuccessCommand command){
        return OrderInfoDto.from(orderApplicationService.pay(command.getPaymentId(), command.getPayerId()));
    }

    @ApiOperation("支付取消")
    @PostMapping("pay/cancel")
    public OrderInfoDto cancelPay(@RequestBody OrderPayCancelCommand command){
        return OrderInfoDto.from(orderApplicationService.cancel(command.getOrderNo()));
    }
}
