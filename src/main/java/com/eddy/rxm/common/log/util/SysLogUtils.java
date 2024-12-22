package com.eddy.rxm.common.log.util;

import com.eddy.rxm.admin.entity.SysLog;
import lombok.experimental.UtilityClass;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 系统日志工具类
 *
 * @auther Nick
 */
@UtilityClass
public class SysLogUtils {

    public SysLog getSysLog(){

//        HttpServletRequest request = ((ServletRequestAttribute) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).;
        SysLog sysLog = new SysLog();
        sysLog.setCreateBy(Objects.requireNonNull(getUserName()));
        sysLog.setRemoteAddr("2");
        sysLog.setRequestUri("3");
        sysLog.setMethod("4");
        sysLog.setUserAgent("5");
        sysLog.setParams("6");
        sysLog.setServiceId(getClicentId());

        return sysLog;
    }

    /**
     * 获取客户端
     */
    private String getClicentId(){
        return null;
    }

    /**
     * 获取用户名称
     */
    private String getUserName(){
        return "";
    }


}
