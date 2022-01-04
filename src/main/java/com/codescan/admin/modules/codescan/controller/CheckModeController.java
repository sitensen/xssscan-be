package com.codescan.admin.modules.codescan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codescan.admin.common.api.CommonResult;
import com.codescan.admin.modules.codescan.model.CheckModeVo;
import com.codescan.admin.modules.codescan.service.ICheckModeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "CheckModeController", description = "检查模式")
@RestController
@RequestMapping("/checkmode")
public class CheckModeController {

    @Autowired
    private ICheckModeService checkModeService;

    @PostMapping("/list")
    public CommonResult<?> list(@RequestBody CheckModeVo checkModeVo,
                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                @RequestParam(value = "pageIndex",defaultValue = "1") int pageIndex){
        Page page = new Page(pageIndex,pageSize);
        QueryWrapper<CheckModeVo> queryWrapper = new QueryWrapper<>(checkModeVo);
        IPage<CheckModeVo> list = checkModeService.page(page,queryWrapper);
        return CommonResult.success(list);
    }

    @PostMapping("/save")
    public CommonResult<?> save(@RequestBody CheckModeVo checkModeVo){
        boolean flag = checkModeService.save(checkModeVo);
        return CommonResult.success(flag);
    }

    @GetMapping("/delete")
    public CommonResult<?> delete(@RequestParam String id ){
        boolean flag = checkModeService.removeById(id);
        return CommonResult.success(flag);
    }
}
