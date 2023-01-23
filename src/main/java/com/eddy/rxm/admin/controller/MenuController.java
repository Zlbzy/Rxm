package com.eddy.rxm.admin.controller;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eddy.rxm.admin.entity.SysMenu;
import com.eddy.rxm.admin.entity.SysUser;
import com.eddy.rxm.admin.entity.TreeNode;
import com.eddy.rxm.admin.service.MenuService;
import com.eddy.rxm.common.util.R;
import com.eddy.rxm.common.util.TreeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @DS("slave")
    @Transactional
    @RequestMapping("/tree")
    public R tree(){

        List<SysMenu> menuList = menuService.getMenu();
        List<TreeNode> menuTree = TreeUtils.buildByLoop(menuList, -1);
        System.out.println(menuTree);

        return R.success(menuTree);
    }


    @RequestMapping("helloWorld")
    public R hello(){


        List<SysMenu> menuList = menuService.list(new LambdaQueryWrapper<SysMenu>()
        .eq(SysMenu::getParentId, -1));
        System.out.println(menuList);

        return R.success("hello!!");
    }

    @PostMapping
    public R save(SysUser user){



        return R.success("新增成功");
    }

}
