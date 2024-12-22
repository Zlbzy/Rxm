package com.eddy.rxm.common.log.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD) //注解只能用于方法
@Retention(RetentionPolicy.RUNTIME)  // 修饰注解的生命周期
@Documented
public @interface SysLog {

    String value() default "";

    String title() default "";
}
