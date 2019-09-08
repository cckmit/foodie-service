package com.foodie.portal.webmanage.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "foodie_sysconfig")
@AllArgsConstructor
@NoArgsConstructor
public class SysConfigEntity {
    @Id
    private String configKey;
    private String configValue;
    private String description;
}
