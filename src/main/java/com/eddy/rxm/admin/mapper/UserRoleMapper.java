package com.eddy.rxm.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eddy.rxm.admin.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<SysUserRole> {


    @Select("select role_id from r_user_role where user_id = #{userId}")
    List<Integer> selectRoleByUserId(@Param("userId") Integer userId);
}
