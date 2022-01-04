package com.codescan.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codescan.admin.modules.sys.dto.SysMenuNode;
import com.codescan.admin.modules.sys.mapper.SysMenuMapper;
import com.codescan.admin.modules.sys.model.SysMenu;
import com.codescan.admin.modules.sys.service.SysMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 后台菜单管理Service实现类
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public boolean create(SysMenu sysMenu) {
        sysMenu.setCreateTime(new Date());
        updateLevel(sysMenu);
        return save(sysMenu);
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(SysMenu sysMenu) {
        if (sysMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            sysMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            SysMenu parentMenu = getById(sysMenu.getParentId());
            if (parentMenu != null) {
                sysMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                sysMenu.setLevel(0);
            }
        }
    }

    @Override
    public boolean update(Long id, SysMenu sysMenu) {
        sysMenu.setId(id);
        updateLevel(sysMenu);
        return updateById(sysMenu);
    }

    @Override
    public Page<SysMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        Page<SysMenu> page = new Page<>(pageNum, pageSize);
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysMenu::getParentId, parentId)
                .orderByDesc(SysMenu::getSort);
        return page(page, wrapper);
    }

    @Override
    public List<SysMenuNode> treeList() {
        List<SysMenu> menuList = list();
        List<SysMenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public boolean updateHidden(Long id, Integer hidden) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(id);
        sysMenu.setHidden(hidden);
        return updateById(sysMenu);
    }

    /**
     * 将Menu转化为MenuNode并设置children属性
     */
    private SysMenuNode covertMenuNode(SysMenu menu, List<SysMenu> menuList) {
        SysMenuNode node = new SysMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<SysMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
