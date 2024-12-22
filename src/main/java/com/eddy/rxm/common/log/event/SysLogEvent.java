package com.eddy.rxm.common.log.event;


import com.eddy.rxm.admin.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * 系统日志事件
 * @author Nick
 */
public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(SysLog source){
        super(source);
    }
}
