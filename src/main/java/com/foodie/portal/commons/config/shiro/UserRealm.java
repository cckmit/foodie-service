package com.foodie.portal.commons.config.shiro;

import com.foodie.portal.user.SysUser;
import com.foodie.portal.user.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
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
        SysUser user = userApplicationService.findByUserName(token.getUsername());
        if (user == null) {
            return null;
        }
        log.info("doGetAuthenticationInfo-userRealm");
        ByteSource saltSource = new Md5Hash(user.getUsername());
        return new SimpleAuthenticationInfo(
                user, //用户
                user.getPassword(), //密码
//                saltSource,//salt=username+salt
                this.getName());
    }

}
