package com.eddy.rxm.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("r_menu_role")
public class SysRoleMenu {

    private Integer roleId;

    private Integer menuId;


}
