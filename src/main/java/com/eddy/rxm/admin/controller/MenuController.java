package com.eddy.rxm.admin.controller;


import com.eddy.rxm.admin.entity.SysMenu;
import com.eddy.rxm.admin.entity.TreeNode;
import com.eddy.rxm.admin.service.MenuService;
import com.eddy.rxm.admin.service.UserService;
import com.eddy.rxm.common.core.exception.AppException;
import com.eddy.rxm.common.core.exception.ResponseEnum;
import com.eddy.rxm.common.util.R;
import com.eddy.rxm.common.util.TreeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@Api(tags = "菜单管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
@Slf4j
public class MenuController {

    private final MenuService menuService;

    private final UserService userService;

    @ApiOperation("菜单树")
    @GetMapping("/tree")
    public R tree(){
//        SysMenu sysMenu = menuService.getById("111");
        List<SysMenu> menuList = menuService.getMenu();
        List<TreeNode> menuTree = TreeUtils.buildByLoop(menuList, -1);
        return R.success(menuTree);
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        SysMenu sysMenu = menuService.getById(id);
        if(Objects.isNull(sysMenu)) throw new AppException(ResponseEnum.NOT_FOUND);
        return R.success(sysMenu);
    }


    @PostMapping
    public R save(@RequestBody SysMenu sysMenu){
        if(sysMenu.getParentId() == null) sysMenu.setParentId(-1);
        boolean result = menuService.saveOrUpdate(sysMenu);
        if(!result) throw new AppException(ResponseEnum.FAILED);
        return R.success(sysMenu);
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id){
        Boolean result = menuService.removeById(id);
        if(!result) throw new AppException(ResponseEnum.FAILED);
        return R.success("删除成功!");
    }








}
