package com.study.study.enums;

public enum ResponseCodeEnum {
    SUCCESS(200, "success"),
    UNKNOWN_ERROR(500, "unknown error"),
    BAD_REQUEST(400, "bad request"),
    FORBIDDEN(10002, "You have no permission to access this page."),
    VALIDATE_FAILURE(10003, "Validate failure."),
    NULL_POINTER(1004, "Null Pointer");

    private Integer code;
    private String msg;

    ResponseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
