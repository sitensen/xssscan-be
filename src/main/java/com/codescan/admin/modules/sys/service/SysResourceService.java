package com.codescan.admin.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codescan.admin.modules.sys.model.SysResource;

/**
 * 后台资源管理Service
 */
public interface SysResourceService extends IService<SysResource> {
    /**
     * 添加资源
     */
    boolean create(SysResource sysResource);

    /**
     * 修改资源
     */
    boolean update(Long id, SysResource sysResource);

    /**
     * 删除资源
     */
    boolean delete(Long id);

    /**
     * 分页查询资源
     */
    Page<SysResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);
}
