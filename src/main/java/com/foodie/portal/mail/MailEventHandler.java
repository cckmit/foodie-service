package com.foodie.portal.mail;

import com.foodie.portal.commons.event.OrderCreatedEvent;
import com.foodie.portal.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MailEventHandler {

    @Autowired
    private MailApplicationService mailApplicationService;

    @EventListener
    public void sendPayNoMail(OrderCreatedEvent event) {
        Order order = event.getOrder();
        String subject = String.format("订单创建成功：%s", order.getNumber());
        String content = String.format("你的服务码为: %s ", order.getPayNo());
        mailApplicationService.send(order.getUser().getEmail(), subject, content);
    }
}
