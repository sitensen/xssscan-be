package com.codescan.admin.modules.codescan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codescan.admin.common.api.CommonResult;
import com.codescan.admin.modules.codescan.model.SourceCodeVo;
import com.codescan.admin.modules.codescan.service.ISourceCodeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Api(tags = "SourceCodeController", description = "源码文件上传")
@RequestMapping("/sourceCode")
@RestController
public class SourceCodeController {
    @Autowired
    private ISourceCodeService sourceCodeService;

    @PostMapping("/page")
    public CommonResult<?> page(@RequestBody SourceCodeVo sourceCodeVo,
                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                @RequestParam(value = "pageIndex",defaultValue = "1") int pageIndex){
        Page page = new Page<>(pageIndex,pageSize);
        QueryWrapper<SourceCodeVo> wrapper = new QueryWrapper<>(sourceCodeVo);
        Page<SourceCodeVo> list = sourceCodeService.page(page,wrapper);
        return CommonResult.success(list);

    }

    @PostMapping("/save")
    public CommonResult<?> save(@RequestBody SourceCodeVo sourceCodeVo){
        if(Objects.isNull(sourceCodeVo.getCodePath())){
            return CommonResult.failed("源码文件不能为空!");
        }
        String suffiixName = sourceCodeVo.getCodePath().substring(sourceCodeVo.getCodePath().lastIndexOf("."));
        if(!suffiixName.equalsIgnoreCase(".zip")){
            // || sourceCodeVo.getCodePath().equalsIgnoreCase(".py")
            return CommonResult.failed("源码文件格式错误,请上传zip压缩包!");
        }
        sourceCodeService.saveSourceCode(sourceCodeVo);
        return CommonResult.success();
    }

    @GetMapping("/delete")
    public CommonResult<?> delete(@RequestParam String id){
        return CommonResult.success(sourceCodeService.removeById(id));
    }
}
