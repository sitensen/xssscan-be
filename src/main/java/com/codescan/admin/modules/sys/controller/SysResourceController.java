package com.codescan.admin.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codescan.admin.common.api.CommonPage;
import com.codescan.admin.common.api.CommonResult;
import com.codescan.admin.modules.sys.service.SysResourceService;
import com.codescan.admin.security.component.DynamicSecurityMetadataSource;
import com.codescan.admin.modules.sys.model.SysResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源管理Controller
 */
@Controller
@Api(tags = "ResourceController", description = "后台资源管理")
@RequestMapping("/resource")
public class SysResourceController {

    @Autowired
    private SysResourceService resourceService;

    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    @ApiOperation("添加后台资源")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SysResource sysResource) {
        boolean success = resourceService.create(sysResource);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改后台资源")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody SysResource sysResource) {
        boolean success = resourceService.update(id, sysResource);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取资源详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SysResource> getItem(@PathVariable Long id) {
        SysResource sysResource = resourceService.getById(id);
        return CommonResult.success(sysResource);
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        boolean success = resourceService.delete(id);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页模糊查询后台资源")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SysResource>> list(@RequestParam(required = false) Long categoryId,
                                                      @RequestParam(required = false) String nameKeyword,
                                                      @RequestParam(required = false) String urlKeyword,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<SysResource> resourceList = resourceService.list(categoryId,nameKeyword, urlKeyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(resourceList));
    }

    @ApiOperation("查询所有后台资源")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SysResource>> listAll() {
        List<SysResource> resourceList = resourceService.list();
        return CommonResult.success(resourceList);
    }
}
