package com.foodie.portal.order;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.order.command.CreateOrderCommand;
import com.foodie.portal.order.command.PayOrderCommand;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "（用户）订单功能")
@RestController
@RequestMapping
public class OrderPaymentController {

    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";

    @Autowired
    private OrderApplicationService orderApplicationService;

    @GetMapping(PAYPAL_SUCCESS_URL)
    public void successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
        orderApplicationService.pay(paymentId, payerId);
    }

    @GetMapping(PAYPAL_CANCEL_URL)
    public void cancelPay(@RequestParam("paymentId")  String paymentId){
        orderApplicationService.cancelPay(paymentId);
    }
}
