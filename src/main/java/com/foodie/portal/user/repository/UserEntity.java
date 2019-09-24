package com.foodie.portal.user.repository;

import com.foodie.portal.commons.model.IdType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "foodie_user")
public class UserEntity {
    @Id
    private String id;
    private String email;
    private String password;
    private String avatar;
    private String lastName;
    private String firstName;
    private String nationality;
    private IdType idType;
    private String idNumber;
}
