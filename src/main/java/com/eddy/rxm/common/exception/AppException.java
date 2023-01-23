package com.eddy.rxm.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 异常处理类
 * @author: eddy
 * @Data:   2022/12/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppException extends RuntimeException{
    private String code;
    private String message;

    public AppException(ResponseEnum responseEnum){
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

}
