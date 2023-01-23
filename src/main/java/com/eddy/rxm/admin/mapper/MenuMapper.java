package com.eddy.rxm.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eddy.rxm.admin.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getMenu();

}
