package com.eddy.rxm.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eddy.rxm.admin.entity.SysLog;
import com.eddy.rxm.admin.mapper.SysLogMapper;
import com.eddy.rxm.admin.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@DS("master")
@Slf4j
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
}
