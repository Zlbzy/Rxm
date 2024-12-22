package com.eddy.rxm.admin.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eddy.rxm.admin.entity.SysMenu;
import com.eddy.rxm.admin.mapper.MenuMapper;
import com.eddy.rxm.admin.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DS("master")
@RequiredArgsConstructor
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, SysMenu> implements MenuService {


    private final MenuMapper menuMapper;

    @Override
    public List<SysMenu> getMenu(){
        return menuMapper.getMenu();
    }

}
