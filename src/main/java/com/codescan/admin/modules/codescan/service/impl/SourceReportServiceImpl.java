package com.codescan.admin.modules.codescan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codescan.admin.modules.codescan.mapper.SourceReportMapper;
import com.codescan.admin.modules.codescan.model.SourceReportVo;
import com.codescan.admin.modules.codescan.service.ISourceReportService;
import org.springframework.stereotype.Service;

@Service
public class SourceReportServiceImpl extends ServiceImpl<SourceReportMapper, SourceReportVo> implements ISourceReportService {
}
