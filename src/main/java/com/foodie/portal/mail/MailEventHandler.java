package com.foodie.portal.mail;

import com.foodie.portal.commons.event.*;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.model.RestaurantOrder;
import com.foodie.portal.user.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MailEventHandler {

    @Autowired
    private MailApplicationService mailApplicationService;

    @Async
    @EventListener
    public void sendPayNoMail(OrderAcceptedEvent event) {
        Order order = event.getOrder();
        String subject = String.format("活动订单：%s, 商家已接单", order.getNumber());
        String content = String.format("您的服务码为: %s ", order.getPayNo());
        mailApplicationService.send(order.getUser().getEmail(), subject, content);
    }

    @Async
    @EventListener
    public void sendPayStatusMail(ActivityOrderPaidEvent event) {
        Order order = event.getOrder();
        String subject = String.format("活动订单付款成功：%s", order.getNumber());
        String content = String.format("你的活动订单%s付款成功,请等待商家接单", order.getNumber());
        mailApplicationService.send(order.getUser().getEmail(), subject, content);
    }

    @Async
    @EventListener
    public void sendOrderMailToMerchant(ActivityOrderPaidEvent event) {
        Order order = event.getOrder();
        String subject = String.format("用户下单成功：%s", order.getNumber());
        String content = String.format("用户活动订单%s付款成功,请您接单,活动标题: %s", order.getNumber(), order.getActivity().getTitle());
        mailApplicationService.send(order.getMerchant().getEmail(), subject, content);
    }

    @Async
    @EventListener
    public void sendPayNoMail(RestaurantOrderPaidEvent event) {
        RestaurantOrder order = event.getOrder();
        String subject = String.format("餐厅订单成功：%s", order.getNumber());
        String content = String.format("您的服务码为: %s ", order.getPayNo());
        mailApplicationService.send(order.getUser().getEmail(), subject, content);
    }



    @Async
    @EventListener
    public void sendOrderRejected(OrderRejectedEvent event) {
        Order order = event.getOrder();
        String subject = "订单取消通知";
        String content = String.format("您的订单：%s 被商家取消", order.getNumber());
        mailApplicationService.send(order.getUser().getEmail(), subject, content);
    }

    @Async
    @EventListener
    public void sendMerchantPassword(MerchantApplyPassedEvent event) {
        Merchant merchant = event.getMerchant();
        String subject = String.format("商家申请成功：%s", merchant.getEmail());
        String content = String.format("您的登录密码为: %s ", event.getPassword());
        mailApplicationService.send(merchant.getEmail(), subject, content);
    }

    @Async
    @EventListener
    public void sendMerchantPasswordReset(MerchantPasswordResetEvent event) {
        Merchant merchant = event.getMerchant();
        String subject = String.format("商家密码重置成功：%s", merchant.getEmail());
        String content = String.format("您的登录密码为: %s ", event.getPassword());
        mailApplicationService.send(merchant.getEmail(), subject, content);
    }
}
