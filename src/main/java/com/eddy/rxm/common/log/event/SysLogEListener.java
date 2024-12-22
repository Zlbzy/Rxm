package com.eddy.rxm.common.log.event;

import com.eddy.rxm.admin.entity.SysLog;
import com.eddy.rxm.admin.service.SysLogService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

@Data
@AllArgsConstructor
public class SysLogEListener {

    private final SysLogService sysLogService;

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event){
        SysLog sysLog = (SysLog) event.getSource();
        sysLogService.save(sysLog);
    }

}
