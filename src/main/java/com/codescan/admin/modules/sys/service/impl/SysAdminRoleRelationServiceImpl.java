package com.codescan.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codescan.admin.modules.sys.mapper.SysAdminRoleRelationMapper;
import com.codescan.admin.modules.sys.model.SysAdminRoleRelation;
import com.codescan.admin.modules.sys.service.SysAdminRoleRelationService;
import org.springframework.stereotype.Service;

/**
 * 管理员角色关系管理Service实现类
 */
@Service
public class SysAdminRoleRelationServiceImpl extends ServiceImpl<SysAdminRoleRelationMapper, SysAdminRoleRelation> implements SysAdminRoleRelationService {
}
