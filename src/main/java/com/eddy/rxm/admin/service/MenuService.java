package com.eddy.rxm.admin.service;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eddy.rxm.admin.entity.SysMenu;

import java.util.List;


public interface MenuService extends IService<SysMenu> {

    List<SysMenu> getMenu();
}
