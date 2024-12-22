package com.eddy.rxm.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity {

    private String roleName;
    private Integer sort;
    private String remarks;
    private String roleCode;

    @TableField(exist = false)
    private String createUser;


}
