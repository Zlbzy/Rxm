package com.eddy.rxm.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("r_user_role")
public class SysUserRole {

    private Integer userId;

    private Integer roleId;
}
