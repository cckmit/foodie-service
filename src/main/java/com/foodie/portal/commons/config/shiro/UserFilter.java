package com.foodie.portal.commons.config.shiro;

import com.foodie.portal.user.model.User;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class UserFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        Subject subject = getSubject(request, response);
        if (subject.isAuthenticated()) {
            return subject.getPrincipal() instanceof User;
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }

}
