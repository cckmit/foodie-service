package com.foodie.portal.payment;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentApplicationService paymentApplicationService;

    @GetMapping("/test")
    public String test() {
        try {
            Payment activityPayment = paymentApplicationService.createActivityPayment(1D,
                    "USD", PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale, "订单支付", "13123");

            for (Links links : activityPayment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "error";

    }
}
