package com.eddy.rxm.auth.service;

import com.eddy.rxm.admin.entity.SysUser;
import com.eddy.rxm.common.util.R;

public interface LoginService {

    R login(SysUser sysUser);
}
