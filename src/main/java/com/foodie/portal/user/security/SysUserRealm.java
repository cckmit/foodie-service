package com.foodie.portal.user.security;

import com.foodie.portal.commons.config.shiro.LoginToken;
import com.foodie.portal.commons.utils.EncryptUtils;
import com.foodie.portal.user.SysUserApplicationService;
import com.foodie.portal.user.UserApplicationService;
import com.foodie.portal.user.model.SysUser;
import com.foodie.portal.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class SysUserRealm extends AuthorizingRealm {

    @Autowired
    private UserApplicationService userApplicationService;
    @Autowired
    private SysUserApplicationService sysUserApplicationService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return ((LoginToken)token).getLoginType() == LoginToken.LoginType.ADMIN;
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        List<String> sysPermissions = userApplicationService.selectPermissionByUserName(sysUser.getUsername());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(sysPermissions);
        log.info("doGetAuthorizationInfo");
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUser user = sysUserApplicationService.findByUsername(token.getUsername());
        if (user == null) {
            return null;
        }
        log.info("doGetAuthenticationInfo-userRealm");
        ByteSource saltSource = new Md5Hash(user.getUsername());
        return new SimpleAuthenticationInfo(
                user, //用户
                user.getPassword(), //密码
                saltSource,
                this.getName());
    }

}
