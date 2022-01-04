package com.codescan.admin.modules.sys.mapper;

import com.codescan.admin.modules.sys.model.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台菜单表 Mapper 接口
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据后台用户ID获取菜单
     */
    List<SysMenu> getMenuList(@Param("adminId") Long adminId);

    /**
     * 根据角色ID获取菜单
     */
    List<SysMenu> getMenuListByRoleId(@Param("roleId") Long roleId);

}
