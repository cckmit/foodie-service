package com.foodie.portal.commons.config;

import com.foodie.portal.commons.ErrorCode;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.HashMap;
import java.util.Map;

/**
 *  Restful 接口处理
 *
 * @author shijun_luo
 * @date    2019/03/18
 */
public class HandlerMethodReturnValueHandlerProxy implements HandlerMethodReturnValueHandler {

    private static final int STATUS_CODE_SUCCEEDED = HttpStatus.OK.value();

    private HandlerMethodReturnValueHandler proxyObject;

    public HandlerMethodReturnValueHandlerProxy(HandlerMethodReturnValueHandler proxyObject) {
        this.proxyObject = proxyObject;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return proxyObject.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("statusCode", ErrorCode.SUCCESS.getCode());
        resultMap.put("errorMessage", "");
        resultMap.put("data", returnValue);

        proxyObject.handleReturnValue(resultMap, returnType, mavContainer, webRequest);
    }
}
