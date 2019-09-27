package com.foodie.portal.order;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.command.CreateOrderCommand;
import com.foodie.portal.order.command.PayOrderCommand;
import com.foodie.portal.order.representation.OrderSummaryRepresentation;
import com.foodie.portal.user.model.User;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "（用户）订单功能")
@RestController
@RequestMapping("user/order")
public class UserOrderController {

    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";

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
    public Pagination<OrderSummaryRepresentation> orders(PageCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        return orderApplicationService.myOrderList(command.getPage(), command.getSize(), user);
    }

    @ApiOperation("用户付款")
    @PostMapping("/{id}/payment")
    public String pay(@PathVariable(name = "id") String id, @RequestBody @Valid PayOrderCommand command, HttpServletRequest request) {
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        String cancelUrl = basePath + PAYPAL_CANCEL_URL;
        String successUrl = basePath + PAYPAL_SUCCESS_URL;
        return orderApplicationService.prePay(id, command, successUrl, cancelUrl);
    }

    @GetMapping(PAYPAL_SUCCESS_URL)
    public void successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
        orderApplicationService.pay(paymentId, payerId);
    }
}
