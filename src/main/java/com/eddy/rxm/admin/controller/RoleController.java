package com.eddy.rxm.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eddy.rxm.admin.entity.BatchOptObj;
import com.eddy.rxm.admin.entity.SysMenu;
import com.eddy.rxm.admin.entity.SysRole;
import com.eddy.rxm.admin.entity.SysRoleMenu;
import com.eddy.rxm.admin.service.RoleMenuService;
import com.eddy.rxm.admin.service.RoleService;
import com.eddy.rxm.common.core.exception.AppException;
import com.eddy.rxm.common.core.exception.ResponseEnum;
import com.eddy.rxm.common.log.annotation.SysLog;
import com.eddy.rxm.common.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.beans.Introspector;
import java.util.List;
import java.util.Objects;

@Api(tags = "角色管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    private final RoleMenuService roleMenuService;


    @GetMapping("/queryPage")
    public R queryPage(Page page, SysRole sysRole){

        QueryWrapper wrapper = new QueryWrapper<SysRole>();
        wrapper.like(StringUtils.isNotBlank(sysRole.getRoleName()),"",sysRole.getRoleName());

        IPage pageData = roleService.page(page, wrapper);
        return R.success(pageData);

    }




    @ApiOperation("全部角色")
    @GetMapping("/queryAll")
    public R queryAll(){
        List<SysRole> list = roleService.list();
        return R.success(list);
    }

    @SysLog(title="新增角色成功",value="新增角色")
    @PostMapping
    public R save(@RequestBody SysRole sysRole){

        boolean result = roleService.saveOrUpdate(sysRole);
        if(!result) throw new AppException(ResponseEnum.FAILED);
        return R.success(sysRole);
    }


    @GetMapping("/{id}")
    public R selectFun(@PathVariable Integer id){
        SysRole role = roleService.getRoleById(id);
        if(Objects.isNull(role)) throw new AppException(ResponseEnum.NOT_FOUND);

        return R.success(role);
    }

    @SysLog(title="删除角色成功",value="删除角色")
    @DeleteMapping("/{id}")
    public R deleteFun(@PathVariable Integer id){
        boolean flag = roleService.removeById(id);
        if(!flag) throw new AppException(ResponseEnum.NOT_FOUND);
        return R.success("删除成功!");
    }

    @PostMapping("/saveRoleMenu")
    public R updateRoleMenu(@RequestBody BatchOptObj batchObj){
        List<Integer> menuIds = batchObj.getOptIds();
        boolean flag = roleService.saveAuth(batchObj.getId(), menuIds);
        if(!flag) throw new AppException(ResponseEnum.FAILED);
        return R.success("保存成功!");
    }

    @GetMapping("/getRoleMenuIds/{roleId}")
    public R getRoleMenuIds(@PathVariable Integer roleId){
        List<Integer> menuIds = roleService.getRoleMenuIds(roleId);
        return R.success(menuIds);
    }



}
