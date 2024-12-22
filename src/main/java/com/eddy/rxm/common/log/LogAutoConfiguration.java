package com.eddy.rxm.common.log;

import com.eddy.rxm.admin.service.SysLogService;
import com.eddy.rxm.common.log.aspect.SysLogAspect;
import com.eddy.rxm.common.log.event.SysLogEListener;
import com.eddy.rxm.common.log.event.SysLogEvent;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class LogAutoConfiguration {

    private final SysLogService sysLogService;

    @Bean
    public SysLogEListener sysLogEListener(){
        return new SysLogEListener(sysLogService);
    }

    @Bean
    public SysLogAspect sysLogAspect(){
        return new SysLogAspect();
    }

}
