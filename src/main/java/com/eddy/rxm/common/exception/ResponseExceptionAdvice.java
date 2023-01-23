package com.eddy.rxm.common.exception;

import com.eddy.rxm.common.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
@ResponseBody
public class ResponseExceptionAdvice {

    @ExceptionHandler(AppException.class)
    public R appExceptionHandler(AppException appexc){
        return new R(appexc.getCode(), appexc.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception ex){
        ex.printStackTrace();
        return new R(ResponseEnum.SYSTEM_ERROR, null);
    }

}
