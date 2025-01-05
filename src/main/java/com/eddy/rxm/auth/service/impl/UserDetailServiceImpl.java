package com.eddy.rxm.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.eddy.rxm.admin.entity.SysUser;
import com.eddy.rxm.admin.mapper.UserMapper;
import com.eddy.rxm.auth.entity.LoginUser;
import com.eddy.rxm.common.core.exception.AppException;
import com.eddy.rxm.common.core.exception.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Wrapper<SysUser> wrapper = Wrappers.<SysUser>query().lambda()
                .eq(SysUser::getUsername, username);
        SysUser user = userMapper.selectOne(wrapper);
        if(Objects.isNull(user)){
            throw new AppException(ResponseEnum.USER_LOGIN_FAILED);
        }
        // TODO根据用户查询到权限信息，添加到LoginUser中， 先暂时写死
        List<String> authList = new ArrayList<>(Arrays.asList("tree"));

        return new LoginUser(user, authList);
    }
}
