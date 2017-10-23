package com.study.study.handle;

import com.study.study.enums.ResponseCodeEnum;
import com.study.study.response.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    public Object handle(RuntimeException e) {
        System.out.println("RuntimeException");
        return Response.render(ResponseCodeEnum.UNKNOWN_ERROR, e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public Object handle(NullPointerException e) {
        System.out.println("NullPointerException");
        return Response.render(ResponseCodeEnum.NULL_POINTER, e.getMessage());
    }
}
