package com.codescan.admin.modules.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codescan.admin.modules.sys.mapper.SysResourceMapper;
import com.codescan.admin.modules.sys.model.SysResource;
import com.codescan.admin.modules.sys.service.SysAdminCacheService;
import com.codescan.admin.modules.sys.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 后台资源管理Service实现类
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {

    @Autowired
    private SysAdminCacheService adminCacheService;

    @Override
    public boolean create(SysResource sysResource) {
        sysResource.setCreateTime(new Date());
        return save(sysResource);
    }

    @Override
    public boolean update(Long id, SysResource sysResource) {
        sysResource.setId(id);
        boolean success = updateById(sysResource);
        adminCacheService.delResourceListByResource(id);
        return success;
    }

    @Override
    public boolean delete(Long id) {
        boolean success = removeById(id);
        adminCacheService.delResourceListByResource(id);
        return success;
    }

    @Override
    public Page<SysResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        Page<SysResource> page = new Page<>(pageNum, pageSize);
        QueryWrapper<SysResource> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<SysResource> lambda = wrapper.lambda();
        if (categoryId != null) {
            lambda.eq(SysResource::getCategoryId, categoryId);
        }
        if (StrUtil.isNotEmpty(nameKeyword)) {
            lambda.like(SysResource::getName, nameKeyword);
        }
        if (StrUtil.isNotEmpty(urlKeyword)) {
            lambda.like(SysResource::getUrl, urlKeyword);
        }
        return page(page, wrapper);
    }
}
