package com.eddy.rxm.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eddy.rxm.admin.entity.SysRoleMenu;
import com.eddy.rxm.admin.mapper.RoleMenuMapper;
import com.eddy.rxm.admin.service.RoleMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@DS("master")
@RequiredArgsConstructor
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, SysRoleMenu> implements RoleMenuService {


}
