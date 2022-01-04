package com.codescan.admin.modules.sys.controller;

import com.codescan.admin.common.api.CommonResult;
import com.codescan.admin.modules.sys.service.IFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@Api(tags = "SysFileController", description = "文件服务,上传下载等")
@RequestMapping("/file")
public class SysFileController {


    @Autowired
    private IFileService fileService;

    @ApiOperation(value = "文件上传")
    @RequestMapping("/upload")
    public CommonResult<?> fileUpload(MultipartFile file){
        if(file == null){
            return CommonResult.failed();
        }
        //上传到MINIIO
        String url = fileService.uploadFileRtPath(file);

        return CommonResult.success(url);
    }

//    @ApiOperation(value = "文件下载")
//    @RequestMapping("/download")
//    public void fileDownload(){
//
//    }

}
