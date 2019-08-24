package com.foodie.portal.config;

/**
 * 错误码
 */
public enum ErrorCode {

    SUCCESS(200,"执行成功"),
    REFUSED(500),
    NO_RESULT_FOUND(404),
    FAILED(400);

    private int code;

    private String msg;

    ErrorCode(int code) {
        this.code = code;
    }

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
