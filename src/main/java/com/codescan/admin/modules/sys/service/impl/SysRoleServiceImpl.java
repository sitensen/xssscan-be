package com.codescan.admin.modules.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codescan.admin.modules.sys.mapper.SysMenuMapper;
import com.codescan.admin.modules.sys.mapper.SysResourceMapper;
import com.codescan.admin.modules.sys.mapper.SysRoleMapper;
import com.codescan.admin.modules.sys.model.*;
import com.codescan.admin.modules.sys.service.SysRoleMenuRelationService;
import com.codescan.admin.modules.sys.service.SysRoleResourceRelationService;
import com.codescan.admin.modules.sys.model.*;
import com.codescan.admin.modules.sys.service.SysAdminCacheService;
import com.codescan.admin.modules.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 后台角色管理Service实现类
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysAdminCacheService adminCacheService;

    @Autowired
    private SysRoleMenuRelationService roleMenuRelationService;

    @Autowired
    private SysRoleResourceRelationService roleResourceRelationService;

    @Autowired
    private SysMenuMapper menuMapper;

    @Autowired
    private SysResourceMapper resourceMapper;

    @Override
    public boolean create(SysRole role) {
        role.setCreateTime(new Date());
        role.setAdminCount(0);
        role.setSort(0);
        return save(role);
    }

    @Override
    public boolean delete(List<Long> ids) {
        boolean success = removeByIds(ids);
        adminCacheService.delResourceListByRoleIds(ids);
        return success;
    }

    @Override
    public Page<SysRole> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<SysRole> page = new Page<>(pageNum, pageSize);
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<SysRole> lambda = wrapper.lambda();
        if (StrUtil.isNotEmpty(keyword)) {
            lambda.like(SysRole::getName, keyword);
        }
        return page(page, wrapper);
    }

    @Override
    public List<SysMenu> getMenuList(Long adminId) {
        return menuMapper.getMenuList(adminId);
    }

    @Override
    public List<SysMenu> listMenu(Long roleId) {
        return menuMapper.getMenuListByRoleId(roleId);
    }

    @Override
    public List<SysResource> listResource(Long roleId) {
        return resourceMapper.getResourceListByRoleId(roleId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        QueryWrapper<SysRoleMenuRelation> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysRoleMenuRelation::getRoleId, roleId);
        roleMenuRelationService.remove(wrapper);
        //批量插入新关系
        List<SysRoleMenuRelation> relationList = new ArrayList<>();
        for (Long menuId : menuIds) {
            SysRoleMenuRelation relation = new SysRoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            relationList.add(relation);
        }
        roleMenuRelationService.saveBatch(relationList);
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        QueryWrapper<SysRoleResourceRelation> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysRoleResourceRelation::getRoleId, roleId);
        roleResourceRelationService.remove(wrapper);
        //批量插入新关系
        List<SysRoleResourceRelation> relationList = new ArrayList<>();
        for (Long resourceId : resourceIds) {
            SysRoleResourceRelation relation = new SysRoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            relationList.add(relation);
        }
        roleResourceRelationService.saveBatch(relationList);
        adminCacheService.delResourceListByRole(roleId);
        return resourceIds.size();
    }
}
