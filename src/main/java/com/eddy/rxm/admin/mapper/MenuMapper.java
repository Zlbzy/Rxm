package com.eddy.rxm.admin.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eddy.rxm.admin.entity.SysMenu;


import java.util.List;

public interface MenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getMenu();

}
