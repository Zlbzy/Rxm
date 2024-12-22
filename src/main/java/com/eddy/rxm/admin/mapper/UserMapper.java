package com.eddy.rxm.admin.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eddy.rxm.admin.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@DS("master")
public interface UserMapper extends BaseMapper<SysUser> {

    SysUser selectUserById(@Param("id") Integer id);

    Page<SysUser> selectPage(IPage page, @Param("user")SysUser user);

}
