package com.foodie.portal.user.command;

import com.foodie.portal.commons.model.IdType;
import lombok.Data;

@Data
public class UpdateUserInfoCommand {
    private String avatar;
    private String lastName;
    private String firstName;
    private String nationality;
    private IdType idType;
    private String idNumber;

}
