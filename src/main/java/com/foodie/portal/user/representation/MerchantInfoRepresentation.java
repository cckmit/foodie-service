package com.foodie.portal.user.representation;

import com.foodie.portal.user.repository.MerchantEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MerchantInfoRepresentation {
    private String avatar;
    private String name;
    private double balance;
    private int orderCount;


    public static MerchantInfoRepresentation from(MerchantEntity merchantEntity, Integer orderCount) {
        return new MerchantInfoRepresentation()
                .setAvatar(merchantEntity.getAvatar())
                .setBalance(merchantEntity.getBalance())
                .setName(merchantEntity.getName())
                .setOrderCount(orderCount);
    }

}
