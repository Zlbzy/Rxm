package com.eddy.rxm.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eddy.rxm.admin.entity.TestMenu;
import com.eddy.rxm.admin.mapper.TestMenuMapper;
import com.eddy.rxm.admin.service.TestService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@DS("slave")
public class TestServiceImpl extends ServiceImpl<TestMenuMapper, TestMenu> implements TestService {

    private final TestMenuMapper testMenuMapper;

    public int update(TestMenu menu){
        return testMenuMapper.updateById(menu);

    }
}
