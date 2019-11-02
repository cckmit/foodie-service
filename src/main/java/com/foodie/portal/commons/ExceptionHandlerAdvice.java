package com.foodie.portal.commons;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 处理Rest接口请求时的异常
     *
     * @param request  请求
     * @param response 响应
     * @param ex       异常信息
     * @return
     */
    @ExceptionHandler(RestException.class)
    public Map<String, Object> restError(HttpServletRequest request, HttpServletResponse response, RestException restException) {
        Map<String, Object> map = new HashMap<>();
        //map.put("exception", null != restException.getT() ? restException.getT() : restException);
        map.put("errorMessage", restException.getMessage());
        map.put("url", request.getRequestURL());
        map.put("statusCode", restException.getCode());
        return map;
    }

    @ExceptionHandler(Exception.class)
    public Map<String, Object> exception(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("errorMessage", ex.getMessage());
        map.put("url", request.getRequestURL());
        map.put("statusCode", 500);
        return map;
    }
}
