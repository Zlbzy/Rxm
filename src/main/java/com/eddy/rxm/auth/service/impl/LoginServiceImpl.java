package com.eddy.rxm.auth.service.impl;

import com.eddy.rxm.admin.entity.SysUser;
import com.eddy.rxm.auth.entity.LoginUser;
import com.eddy.rxm.auth.redis.RedisCache;
import com.eddy.rxm.auth.service.LoginService;
import com.eddy.rxm.auth.util.JwtUtil;
import com.eddy.rxm.common.core.exception.AppException;
import com.eddy.rxm.common.core.exception.ResponseEnum;
import com.eddy.rxm.common.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RedisCache redisCache;

    @Override
    public R login(SysUser sysUser) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(sysUser.getUsername(), sysUser.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new AppException(ResponseEnum.USER_LOGIN_FAILED);
        }
        // 使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        // authenticate存入redis
        redisCache.setCacheObject("login:" + userId, loginUser);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
        return R.success(map, "登录成功");
    }

    @Override
    public R logout() {
        Authentication authenticate = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Integer userId = loginUser.getUser().getId();
        redisCache.deleteObject("login:" +userId);
        return R.success("登出成功");
    }
}
