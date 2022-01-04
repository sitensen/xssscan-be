package com.codescan.admin.modules.codescan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "tb_source_report")
@Data
public class SourceReportVo {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private Long sourceId;
    private String reportName;
    private String filePath;
}
