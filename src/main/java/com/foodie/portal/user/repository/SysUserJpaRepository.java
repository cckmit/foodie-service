package com.foodie.portal.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserJpaRepository extends JpaRepository<SysUserEntity, String> {

    SysUserEntity findByUsername(String username);
}
