package com.codescan.admin.modules.codescan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codescan.admin.common.api.CommonResult;
import com.codescan.admin.modules.codescan.model.SourceReportVo;
import com.codescan.admin.modules.codescan.service.ISourceReportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SourceReportController", description = "源码分析报告")
@RestController
@RequestMapping("/sourcereport")
public class SourceReportController {
    @Autowired
    private ISourceReportService sourceReportService;

    @PostMapping("/list")
    public CommonResult<?> list(@RequestBody SourceReportVo sourceReportVo,
                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                @RequestParam(value = "pageIndex",defaultValue = "1") int pageIndex){
        Page page = new Page(pageIndex,pageSize);
        QueryWrapper<SourceReportVo> queryWrapper = new QueryWrapper<>(sourceReportVo);
        IPage<SourceReportVo> list = sourceReportService.page(page,queryWrapper);
        return CommonResult.success(list);
    }

    @PostMapping("/save")
    public CommonResult<?> save(@RequestBody SourceReportVo sourceReportVo){
        boolean flag = sourceReportService.save(sourceReportVo);
        return CommonResult.success(flag);
    }

    @GetMapping("/delete")
    public CommonResult<?> delete(@RequestParam String id ){
        boolean flag = sourceReportService.removeById(id);
        return CommonResult.success(flag);
    }
}
