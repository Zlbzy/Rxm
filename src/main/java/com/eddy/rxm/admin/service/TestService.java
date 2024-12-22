package com.eddy.rxm.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eddy.rxm.admin.entity.TestMenu;

public interface TestService extends IService<TestMenu> {

    int update(TestMenu menu);

}
