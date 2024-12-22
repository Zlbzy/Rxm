package com.eddy.rxm.common.core.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext = null;

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static void clearHolder(){
        if(log.isDebugEnabled()){
            log.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
        }
        applicationContext = null;
    }

    /**
     * 从静态变量applicaionContext中取得Bean，自动转型为锁赋值对象的类型。
     */
    public static <T> T getBean(String name){
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量applicaionContext中取得Bean，自动转型为锁赋值对象的类型。
     */
    public static <T> T getBean(Class<T> requiredType){
        return applicationContext.getBean(requiredType);
    }

    /**
     * 发布事件
     */
    public static void publishEvent(ApplicationEvent event){
        if(applicationContext == null){
            return;
        }
        applicationContext.publishEvent(event);
    }


    /**
     * 实现DisposableBean接口， 在Context关闭时清理静态变量
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        SpringContextHolder.clearHolder();
    }


}
