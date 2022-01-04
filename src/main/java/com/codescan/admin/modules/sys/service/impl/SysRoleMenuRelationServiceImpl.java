package com.codescan.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codescan.admin.modules.sys.mapper.SysRoleMenuRelationMapper;
import com.codescan.admin.modules.sys.service.SysRoleMenuRelationService;
import com.codescan.admin.modules.sys.model.SysRoleMenuRelation;
import org.springframework.stereotype.Service;

/**
 * 角色菜单关系管理Service实现类
 */
@Service
public class SysRoleMenuRelationServiceImpl extends ServiceImpl<SysRoleMenuRelationMapper, SysRoleMenuRelation> implements SysRoleMenuRelationService {
}
