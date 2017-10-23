package com.study.study.response;

import com.study.study.enums.ResponseCodeEnum;

public class Response {

    private Integer code;

    private String msg;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Response render(ResponseCodeEnum codeEnum, Object data) {
        Response response = new Response();
        response.setMsg(codeEnum.getMsg());
        response.setCode(codeEnum.getCode());
        response.setData(data);
        return response;
    }
}
