package com.foodie.portal.payment;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
        log.info("创建paypal 支付");
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

    public DetailedRefund refundSale(String paymentId, Double total, String currency, String reason) {


        // ###Sale
        // A sale transaction.
        // Create a Sale object with the
        // given sale transaction id.

        // ###Refund
        // A refund transaction.
        // Use the amount to create
        // a refund object
        RefundRequest refund = new RefundRequest();
        // ###Amount
        // Create an Amount object to
        // represent the amount to be
        // refunded. Create the refund object, if the refund is partial
        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setTotal(String.format("%.2f", total));
        refund.setAmount(amount);
        refund.setReason(reason);


        try {
            //注意这段代码，获取saleId
            Payment payment = Payment.get(apiContext, paymentId);
            Transaction transaction = payment.getTransactions().get(0);
            RelatedResources resources = transaction.getRelatedResources().get(0);

            // ### Api Context
            // Pass in a `ApiContext` object to authenticate
            // the call and to send a unique request id
            // (that ensures idempotency). The SDK generates
            // a request id if you do not pass one explicitly.

            // Refund by posting to the APIService
            // using a valid AccessToken
            Sale sale = new Sale();
            sale.setId(resources.getSale().getId());
            DetailedRefund res = sale.refund(apiContext, refund);
            return res;
        } catch (PayPalRESTException e) {
            throw new IllegalStateException("failed to refund saleId=" + paymentId, e);
        }
    }


}
