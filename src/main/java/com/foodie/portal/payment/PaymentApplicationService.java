package com.foodie.portal.payment;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentApplicationService {

    @Autowired
    private APIContext apiContext;
    @Autowired
    private PaymentProperties properties;

    public Payment createActivityPayment(
            Double total,
            String currency,
            PaypalPaymentMethod method,
            PaypalPaymentIntent intent,
            String description, String orderNo) throws PayPalRESTException {

        Payment payment = getPayment(total, currency, method, intent, description);

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(String.format(properties.getPaypal().getActivityCancelUrl(), orderNo));
        redirectUrls.setReturnUrl(String.format(properties.getPaypal().getActivitySuccessUrl(), orderNo));
        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }

    public Payment createRestaurantPayment(
            Double total,
            String currency,
            PaypalPaymentMethod method,
            PaypalPaymentIntent intent,
            String description, String orderNo) throws PayPalRESTException {

        Payment payment = getPayment(total, currency, method, intent, description);

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(String.format(properties.getPaypal().getRestaurantCancelUrl(), orderNo));
        redirectUrls.setReturnUrl(String.format(properties.getPaypal().getRestaurantSuccessUrl(), orderNo));
        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }

    private Payment getPayment(Double total, String currency, PaypalPaymentMethod method, PaypalPaymentIntent intent, String description) {
        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setTotal(String.format("%.2f", total));

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method.toString());

        Payment payment = new Payment();
        payment.setIntent(intent.toString());
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        return payment;
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }
}
