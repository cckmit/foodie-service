package com.foodie.portal.order;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.command.StartServiceCommand;
import com.foodie.portal.user.model.Merchant;
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
@RequestMapping("merchant/order")
public class MerchantOrderController {

    @Autowired
    private OrderApplicationService orderApplicationService;

    @ApiOperation("接受服务")
    @PostMapping("{id}/accepting")
    public Order accept(@PathVariable String id) {
        var merchant = (Merchant) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.accept(id, merchant);
    }

    @ApiOperation("拒绝服务")
    @PostMapping("{id}/rejecting")
    public Order reject(@PathVariable String id, String reason) {
        var merchant = (Merchant) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.reject(id, reason, merchant);
    }

    @ApiOperation("开始服务")
    @PostMapping("{id}/starting")
    public Order startService(@PathVariable String id, @Valid @RequestBody StartServiceCommand command) {
        var merchant = (Merchant) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.startService(id, command.getPayNo(), merchant);
    }

    @ApiOperation("我的服务列表")
    @GetMapping("list")
    public Pagination<Order> orders(PageCommand command) {
        var merchant = (Merchant) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.merchantOrderList(command.getPage(), command.getSize(), merchant);
    }

}
