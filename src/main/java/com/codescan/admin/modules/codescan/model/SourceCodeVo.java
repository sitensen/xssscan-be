package com.codescan.admin.modules.codescan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *
 */
@TableName(value = "tb_source_code")
@Data
public class SourceCodeVo {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String codePath;
    private String codeType;
    private String createUser;
    private String uploadTime;
    private String reportType;
}
