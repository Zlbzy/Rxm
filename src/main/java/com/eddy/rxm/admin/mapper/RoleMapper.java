package com.eddy.rxm.admin.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eddy.rxm.admin.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RoleMapper extends BaseMapper<SysRole> {


    SysRole selectRoleById(@Param("roleId") Integer id);

    List<Integer> selectRoleMenuIds(@Param("roleId") Integer roleId);

//    List<Integer> selectRoleByUserId(@Param("userId") Integer userId);

}
