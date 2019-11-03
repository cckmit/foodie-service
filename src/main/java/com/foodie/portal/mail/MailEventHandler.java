package com.foodie.portal.mail;

import com.foodie.portal.commons.event.MerchantApplyPassedEvent;
import com.foodie.portal.commons.event.OrderCreatedEvent;
import com.foodie.portal.order.model.Order;
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
    public void sendPayNoMail(OrderCreatedEvent event) {
        Order order = event.getOrder();
        String subject = String.format("订单创建成功：%s", order.getNumber());
        String content = String.format("您的服务码为: %s ", order.getPayNo());
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
}
