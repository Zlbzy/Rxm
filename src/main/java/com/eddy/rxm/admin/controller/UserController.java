package com.eddy.rxm.admin.controller;


import com.eddy.rxm.admin.entity.SysUser;
import com.eddy.rxm.admin.service.UserService;
import com.eddy.rxm.common.exception.AppException;
import com.eddy.rxm.common.exception.ResponseEnum;
import com.eddy.rxm.common.util.R;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;


    @PostMapping
    @Transactional
    public R save(SysUser sysUser){

        userService.saveOrUpdate(sysUser);

        return R.success("新增成功");
    }

    @GetMapping("/listAll")
    public R listAll(){

        List<SysUser> userList = userService.list();
        return R.success(userList);
    }

}
