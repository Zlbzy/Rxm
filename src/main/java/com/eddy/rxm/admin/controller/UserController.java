package com.eddy.rxm.admin.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eddy.rxm.admin.dto.UserDTO;
import com.eddy.rxm.admin.entity.SysRole;
import com.eddy.rxm.admin.entity.SysUser;
import com.eddy.rxm.admin.entity.TestMenu;
import com.eddy.rxm.admin.service.UserService;
import com.eddy.rxm.auth.service.LoginService;
import com.eddy.rxm.common.core.exception.AppException;
import com.eddy.rxm.common.core.exception.ResponseEnum;
import com.eddy.rxm.common.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Api(tags = "用户管理")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private final LoginService loginService;


    @PostMapping("/login")
    public R login(@RequestBody SysUser user){
        return loginService.login(user);
//        return null;
    }

    @ApiOperation("新增用户")
    @PostMapping
    public R save(@RequestBody UserDTO userDTO){
        userService.saveUserInfo(userDTO);

        return R.success("新增成功");
    }

    @ApiOperation("新增用户")
    @PostMapping("/testDs")
    public R testDsSave(@RequestBody TestMenu testMenu){
        userService.saveOrUpdateFun(testMenu);

        return R.success("新增成功");
    }


    @ApiOperation("用户列表分页")
    @GetMapping("/queryPage")
    public R page(Page page, SysUser sysUser){

//        QueryWrapper wrapper = new QueryWrapper<SysRole>();
//        wrapper.like(StringUtils.isNotBlank(sysUser.getUsername()),"",sysUser.getUsername());
//        Page userPage = userService.page(page, new LambdaQueryWrapper<>());
        Page userPage = userService.queryPage(page, sysUser);

        return R.success(userPage);
    }

    @GetMapping("/{id}")
    public R getUser(@PathVariable Integer id){
        if(id == null) throw new AppException(ResponseEnum.EMPTY_REQUEST);  // 空请求异常
        SysUser user = userService.getUserInfo(id);
        if(Objects.isNull(user)) throw new AppException(ResponseEnum.USERNAME_NOT_FOUND);   // 用户不存在!
        return R.success(user);

    }


    @ApiOperation("listUser")
    @GetMapping("/listAll")
    public R listAll(){

        List<SysUser> userList = userService.list();

        return R.success(userList);
    }

    @DeleteMapping("/{id}")
    public R deleteUser(@PathVariable Integer id){
        // 判断是否为当前用户，如果是不允许删除
        userService.deleteUser(id);



        return R.success("删除成功");
    }



    @GetMapping("/downloadExcel")
    public void exportExcel(HttpServletResponse response){

        List<SysUser> userList = userService.list();
        this.driveExcel(response, userList);
    }

    private void driveExcel(HttpServletResponse response, List<SysUser> list){
        List<SysUser> list2 = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            SysUser export = new SysUser();
            export.setUsername(list.get(i).getUsername());
            export.setPassword(list.get(i).getPassword());
            list2.add(export);
        }

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");

       try {
//           excelName = URLEncoder.encode("用户列表", "UTF-8");
//           response.setHeader("Content-Disposition", "attachment;filename=" + excelName + ExcelTypeEnum.XLSX.getValue());
           String fileName = URLEncoder.encode("用户列表", "UTF-8").replaceAll("\\+", "%20");//设置文件名
           fileName = new String(fileName.getBytes(), "ISO-8859-1");
           response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ExcelTypeEnum.XLSX.getValue());
           EasyExcel.write(response.getOutputStream(), SysUser.class)
                   .sheet("用户表").doWrite(list2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
