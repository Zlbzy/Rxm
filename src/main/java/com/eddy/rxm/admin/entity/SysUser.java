package com.eddy.rxm.admin.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@TableName("sys_user")
public class SysUser extends BaseEntity {


    @ExcelProperty("名称")
    /* 用户名 */
    private String username;
    /* 密码 */
    private String password;
    /* 确认密码 */
    @TableField(exist = false)
    private String pwd2;
    @ExcelProperty("联系方式")
    /* 联系方式 */
    private String phone;
    @ExcelProperty("email")
    /* 电子邮箱 */
    private String email;
    /* 头像 */
    private String imageUrl;
    /* 角色id列表*/
    @TableField(exist = false)
    private List<Integer> roleList;

    /* 冻结标识 */
//    private Integer lockFlag;
    /* 第三方登录 */
    private String sinaOpenid;
    private String qqOpenid;
    private String wxOpenid;

    public void addRole(Integer id){
        this.roleList.add(id);
    }

    public void removeRole(Integer index){
        this.roleList.remove(index);
    }





}
