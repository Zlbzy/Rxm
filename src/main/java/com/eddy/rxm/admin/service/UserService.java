package com.eddy.rxm.admin.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eddy.rxm.admin.entity.SysUser;
import org.springframework.stereotype.Service;


@DS("master")
public interface UserService extends IService<SysUser> {

}
