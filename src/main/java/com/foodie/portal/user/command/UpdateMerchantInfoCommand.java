package com.foodie.portal.user.command;

import com.foodie.portal.commons.model.IdType;
import lombok.Data;

@Data
public class UpdateMerchantInfoCommand {
    private String name;
    private String avatar;
    private String description;
}
