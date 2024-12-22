package com.eddy.rxm.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eddy.rxm.admin.entity.SysRole;
import com.eddy.rxm.admin.entity.SysRoleMenu;
import com.eddy.rxm.admin.mapper.RoleMapper;
import com.eddy.rxm.admin.mapper.RoleMenuMapper;
import com.eddy.rxm.admin.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DS("master")
@RequiredArgsConstructor
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, SysRole> implements RoleService {

    private final RoleMapper roleMapper;

    private final RoleMenuMapper roleMenuMapper;

    @Override
    public SysRole getRoleById(Integer roleId){
        return roleMapper.selectRoleById(roleId);
    }

    @Override
    @Transactional
    public boolean saveAuth(Integer roleId, List<Integer> menuIds) {
        // 删除角色权限配置
        roleMenuMapper.delete(new LambdaQueryWrapper<SysRoleMenu>()
            .eq(SysRoleMenu::getRoleId, roleId)
        );
        boolean flag = true;
        SysRoleMenu roleMenu = new SysRoleMenu();
        roleMenu.setRoleId(roleId);
        for(int menuId: menuIds){
            roleMenu.setMenuId(menuId);
            int result = roleMenuMapper.insert(roleMenu);
            if(result <= 0) flag = false;
        }
        return flag;
    }


    public List<Integer> getRoleMenuIds(Integer roleId){
        return roleMapper.selectRoleMenuIds(roleId);
    }
}
