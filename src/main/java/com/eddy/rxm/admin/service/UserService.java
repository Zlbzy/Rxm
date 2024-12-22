package com.eddy.rxm.admin.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eddy.rxm.admin.dto.UserDTO;
import com.eddy.rxm.admin.entity.SysMenu;
import com.eddy.rxm.admin.entity.SysUser;
import com.eddy.rxm.admin.entity.TestMenu;

public interface UserService extends IService<SysUser> {

    SysUser getUserInfo(Integer id);

    SysUser saveUserInfo(UserDTO userDTO);

    void deleteUser(Integer userId);

    void saveOrUpdateFun(TestMenu testMenu);

    Page<SysUser> queryPage(IPage page, SysUser sysUser);

}
