package com.eddy.rxm.admin.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eddy.rxm.admin.entity.SysRole;

import java.util.List;


public interface RoleService extends IService<SysRole> {

    SysRole getRoleById(Integer roleId);

    boolean saveAuth(Integer roleId, List<Integer> menuIds);

    List<Integer> getRoleMenuIds(Integer roleId);
}
