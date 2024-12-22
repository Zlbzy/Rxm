package com.eddy.rxm.common.util;


import com.eddy.rxm.common.core.exception.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class R<T> {
    private  String code;
    private  String message;
    private T data;

    public R(ResponseEnum responseEnum, T data){
        this.code=responseEnum.getCode();
        this.message=responseEnum.getMessage();
        this.data=data;
    }

    public R(ResponseEnum responseEnum, String message){
        this.code=responseEnum.getCode();
        this.message=message;
    }

    public R(String code, String msg){
        this.code=code;
        this.message=msg;
    }

    public static <T> R<T> result(T data, String code, String msg){
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMessage(msg);
        return apiResult;
    }

    public static <T> R<T> success(){
        return result(null, ResponseEnum.SUCCESS.getCode(), null);
    }

    public static <T> R<T> success(String msg){
        return result(null, ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static <T> R<T> success(T data, String msg){
        return result(data, ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static <T> R<T> success(T data){
        return result(data, ResponseEnum.SUCCESS.getCode(), null);
    }

    public static <T> R<T> failed(){
        return result(null, ResponseEnum.SYSTEM_ERROR.getCode(), null);
    }

    public static <T> R<T> failed(String msg){
        return result(null, ResponseEnum.SYSTEM_ERROR.getCode(), msg);
    }



}
