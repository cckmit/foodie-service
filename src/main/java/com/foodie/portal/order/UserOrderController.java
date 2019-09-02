package com.foodie.portal.order;

import com.foodie.portal.user.model.User;
import lombok.var;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/order")
public class UserOrderController {

    @Autowired
    private OrderApplicationService orderApplicationService;

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.create(command, user);
    }
}
