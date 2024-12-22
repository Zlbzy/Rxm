package com.eddy.rxm.admin.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eddy.rxm.admin.entity.TestMenu;

@DS("slave")
public interface TestMenuMapper extends BaseMapper<TestMenu> {
}
