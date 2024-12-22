package com.eddy.rxm.common.core.exception;



public enum ResponseEnum {

    SUCCESSLOGIN("204","登录成功"),
    SUCCESS("0", "成功"),
    FAILED("301", "操作失败!"),
    NOT_FOUND("302", "不存在!!"),
    SUCCEED_YZM("205", "验证码已发送成功"),
    USERNAME_NOT_FOUND("310", "该用户不存在"),
    USERNAME_OR_PASSWORD_INVALIDATE("311", "用户名或密码错误"),
    NO_TOKEN("312", "当前没有登录，请登录"),
    NO_MUELS("313", "当前角色没有任何权限"),
    TOKEN_ERROR("314", "token错误"),
    TOKEN_TIMEOUT("315", "token过期"),
    No_ACTIONRIGHT("316", "权限不足"),
    EMPTY_REQUEST("317", "空请求!"),
    USER_LOGIN_FAILED("410", "用户名或密码错误!"),
    SYSTEM_ERROR("500", "发生未知错误，请联系管理员");
    private String code;
    private String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
