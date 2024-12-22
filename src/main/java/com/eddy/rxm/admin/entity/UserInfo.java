package com.eddy.rxm.admin.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("t_user_info")
public class UserInfo extends BaseEntity{

    @ExcelProperty("名称")
    /* 用户名 */
    private String username;
    /* 密码 */
    private String password;
    @ExcelProperty("联系方式")
    /* 手机号 */
    private Integer mobile;
    @ExcelProperty("email")
    /* 电子邮箱 */
    private String email;
    /* 头像 */
    private String imageUrl;
    /* 备注 */
    private String remarks;
    /* 第三方登录 */
    private String oauthQqState;
    private String oauthWxState;
    private String oauthWbState;

}
