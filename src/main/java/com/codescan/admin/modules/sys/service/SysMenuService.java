package com.codescan.admin.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codescan.admin.modules.sys.dto.SysMenuNode;
import com.codescan.admin.modules.sys.model.SysMenu;

import java.util.List;

/**
 * 后台菜单管理Service
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 创建后台菜单
     */
    boolean create(SysMenu sysMenu);

    /**
     * 修改后台菜单
     */
    boolean update(Long id, SysMenu sysMenu);

    /**
     * 分页查询后台菜单
     */
    Page<SysMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树形结构返回所有菜单列表
     */
    List<SysMenuNode> treeList();

    /**
     * 修改菜单显示状态
     */
    boolean updateHidden(Long id, Integer hidden);
}
