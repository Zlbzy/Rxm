package com.eddy.rxm.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 日志实体类
 *
 * @Author xiaorui
 * @since 2023/10/7
 */
@Data
@TableName("sys_log")
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value="id", type= IdType.AUTO)
    private Long id;
    /**
     * 日志类型
     */
//    @NotBlank(message="日志类型不能为空")
    private String type;
    /**
     * 操作对象
     */
    private String title;
    /**
     * 操作人
     */
    private String createBy;
    /**
     * 操作时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 操作ip地址
     */
    private String remoteAddr;
    /**
     * 用户代理
     */
    private String userAgent;
    /**
     * 请求URI
     */
    private String requestUri;
    /**
     * 操作方式
     */
    private String method;
    /**
     * 操作内容
     */
    private String params;
    /**
     * 执行时间
     */
    private Long time;
    /**
     * 说明
     */
    private String exception;
    /**
     * 服务ID
     */
    private String serviceId;
    /**
     * 删除标记
     */
    private String delFlag;





}
