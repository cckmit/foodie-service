package com.foodie.portal.user.model;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.commons.model.IdType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private String nationality;
    private IdType idType;
    private String idNumber;

    public User(String email, String password) {
        this.id = IdUtil.fastSimpleUUID();
        this.email = email;
        this.password = password;
    }

    public static User create(String email, String password) {
        return new User(email, password);
    }

    public void updateInfo(String lastName, String firstName, String nationality, IdType idType, String idNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.nationality = nationality;
        this.idType = idType;
        this.idNumber = idNumber;
    }
}
