package com.foodie.portal.user.security;

import com.foodie.portal.commons.config.shiro.LoginToken;
import com.foodie.portal.commons.utils.EncryptUtils;
import com.foodie.portal.user.model.SysUser;
import com.foodie.portal.user.UserApplicationService;
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
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserApplicationService userApplicationService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return ((LoginToken)token).getLoginType() == LoginToken.LoginType.USER;
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
        User user = userApplicationService.findByEmail(token.getUsername());
        if (user == null) {
            return null;
        }
        log.info("doGetAuthenticationInfo-userRealm");
        ByteSource saltSource = new Md5Hash(user.getEmail());
        return new SimpleAuthenticationInfo(
                user, //用户
                user.getPassword(), //密码
                saltSource,
                this.getName());
    }

    /**
     * 设置认证加密方式（经过测试，在项目启动时会加载登录认证加密方式，这里的加密需要和修改密码时加密算法一致）
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
        md5CredentialsMatcher.setHashAlgorithmName(EncryptUtils.hashAlgorithmName);
        md5CredentialsMatcher.setHashIterations(EncryptUtils.hashIterations);
        super.setCredentialsMatcher(md5CredentialsMatcher);
    }

}
