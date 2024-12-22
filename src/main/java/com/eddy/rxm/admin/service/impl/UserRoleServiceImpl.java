package com.eddy.rxm.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eddy.rxm.admin.entity.SysUserRole;
import com.eddy.rxm.admin.mapper.UserRoleMapper;
import com.eddy.rxm.admin.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@DS("master")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, SysUserRole> implements UserRoleService {


}
