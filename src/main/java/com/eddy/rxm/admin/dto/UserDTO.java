package com.eddy.rxm.admin.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.eddy.rxm.admin.entity.SysRole;
import com.eddy.rxm.admin.entity.SysUser;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class UserDTO extends SysUser {


    private String[] permissions;



}
