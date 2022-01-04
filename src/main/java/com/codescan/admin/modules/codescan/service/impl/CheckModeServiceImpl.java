package com.codescan.admin.modules.codescan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codescan.admin.modules.codescan.mapper.CheckModeMapper;
import com.codescan.admin.modules.codescan.model.CheckModeVo;
import com.codescan.admin.modules.codescan.service.ICheckModeService;
import org.springframework.stereotype.Service;

@Service
public class CheckModeServiceImpl extends ServiceImpl<CheckModeMapper, CheckModeVo> implements ICheckModeService {
}
