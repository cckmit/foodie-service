package com.foodie.portal.order;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.command.CreateOrderCommand;
import com.foodie.portal.order.command.PayOrderCommand;
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

    @ApiOperation("用户下单")
    @PostMapping
    public Order createOrder(@RequestBody CreateOrderCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.create(command, user);
    }

    @ApiOperation("我的列表")
    @GetMapping("list")
    public Pagination<Order> orders(PageCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.myOrderList(command.getPage(), command.getSize(), user);
    }

    @ApiOperation("用户付款")
    @PostMapping("/{id}/payment")
    public void pay(@PathVariable(name = "id") String id, @RequestBody @Valid PayOrderCommand command) {
        orderApplicationService.pay(id, command);
    }
}
