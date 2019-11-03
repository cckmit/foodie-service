package com.foodie.portal.user.repository;

import com.foodie.portal.commons.model.IdType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Table(name = "foodie_sys_user")
public class SysUserEntity {
    @Id
    private String id;
    private String username;
    private String password;
   private Instant createdAt;
}
