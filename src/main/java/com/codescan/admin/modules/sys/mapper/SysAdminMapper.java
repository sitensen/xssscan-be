package com.codescan.admin.modules.sys.mapper;

import com.codescan.admin.modules.sys.model.SysAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户表 Mapper 接口
 */
public interface SysAdminMapper extends BaseMapper<SysAdmin> {

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);

}
