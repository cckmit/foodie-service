package com.foodie.portal.wallet;

import com.foodie.portal.order.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WalletApplicationService {


    public void addMerchantOpenAccount(Order order) {
        log.info("商家:{}, 增加金额：{}" ,order.getMerchant().getId(), order.getPrice());
    }
}
