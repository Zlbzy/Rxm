package com.eddy.rxm.common.log.aspect;


import com.eddy.rxm.common.core.util.SpringContextHolder;
import com.eddy.rxm.common.log.annotation.SysLog;
import com.eddy.rxm.common.log.event.SysLogEvent;
import com.eddy.rxm.common.log.util.SysLogUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class SysLogAspect {

    @Around("@annotation(sysLog)")
    @SneakyThrows
    public Object around(ProceedingJoinPoint point, SysLog sysLog){

        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);
        log.info("[类名]:{},[方法]:{}", strClassName, strMethodName);

        com.eddy.rxm.admin.entity.SysLog logVo = SysLogUtils.getSysLog();
        logVo.setType(sysLog.value());
        logVo.setTitle(sysLog.title());
        Long startTime = System.currentTimeMillis();
        Object obj = point.proceed();
        Long endTime = System.currentTimeMillis();
        logVo.setTime(endTime - startTime);
        SpringContextHolder.publishEvent(new SysLogEvent(logVo));

        return obj;
    }

}
