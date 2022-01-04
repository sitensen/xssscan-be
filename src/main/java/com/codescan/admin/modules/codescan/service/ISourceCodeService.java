package com.codescan.admin.modules.codescan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codescan.admin.modules.codescan.model.SourceCodeVo;

public interface ISourceCodeService extends IService<SourceCodeVo> {

    boolean saveSourceCode(SourceCodeVo sourceCodeVo);
}
