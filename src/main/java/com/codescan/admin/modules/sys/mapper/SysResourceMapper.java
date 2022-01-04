package com.codescan.admin.modules.sys.mapper;

import com.codescan.admin.modules.sys.model.SysResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台资源表 Mapper 接口
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

    /**
     * 获取用户所有可访问资源
     */
    List<SysResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 根据角色ID获取资源
     */
    List<SysResource> getResourceListByRoleId(@Param("roleId") Long roleId);

}
