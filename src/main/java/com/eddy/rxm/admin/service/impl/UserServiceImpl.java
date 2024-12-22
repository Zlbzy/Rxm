package com.eddy.rxm.admin.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eddy.rxm.admin.dto.UserDTO;
import com.eddy.rxm.admin.entity.SysMenu;
import com.eddy.rxm.admin.entity.SysUser;
import com.eddy.rxm.admin.entity.SysUserRole;
import com.eddy.rxm.admin.entity.TestMenu;
import com.eddy.rxm.admin.mapper.TestMenuMapper;
import com.eddy.rxm.admin.mapper.UserMapper;
import com.eddy.rxm.admin.mapper.UserRoleMapper;
import com.eddy.rxm.admin.service.TestService;
import com.eddy.rxm.admin.service.UserService;
import com.eddy.rxm.common.core.exception.AppException;
import com.eddy.rxm.common.core.exception.ResponseEnum;
import com.eddy.rxm.common.util.BaseUtil;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {

    private final UserMapper userMapper;

    private final TestMenuMapper testMenuMapper;

    private final TestService testService;

    private final UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public SysUser saveUserInfo(UserDTO userDTO){
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDTO, sysUser);
        if(sysUser.getId() == null){
            sysUser.setPassword(BaseUtil.md5(userDTO.getPassword(), "nick"));
        }
        this.saveOrUpdate(sysUser);

        userRoleMapper.delete(new LambdaQueryWrapper<SysUserRole>()
                .eq(SysUserRole::getUserId, sysUser.getId())
        );

        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(sysUser.getId());
        for(Integer roleId: sysUser.getRoleList()){
            userRole.setRoleId(roleId);
            userRoleMapper.insert(userRole);
        }

        return sysUser;

    }

    @Override
    public SysUser getUserInfo(Integer id){
        return userMapper.selectUserById(id);
    }


    @Override
    public Page<SysUser> queryPage(IPage page, SysUser sysUser) {

        return userMapper.selectPage(page, sysUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(Integer userId){
        userMapper.deleteById(userId);
        userRoleMapper.delete(new LambdaQueryWrapper<SysUserRole>()
            .eq(SysUserRole::getUserId, userId)
        );

    }


    @DSTransactional
    @Override
    public void saveOrUpdateFun(TestMenu testMenu) {
        testMenuMapper.updateById(testMenu);

        SysUser sysUser = new SysUser();
        sysUser.setUsername("transac1");
        sysUser.setPassword("123433");
        userMapper.insert(sysUser);
//        System.out.println(1/0);

    }

    @DS("master")
    public void saveUser(SysUser sysUser){
        this.save(sysUser);
    }

}
