package com.codescan.admin.modules.codescan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 检查模式
 */
@TableName(value = "tb_check_mode")
@Data
public class CheckModeVo {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String modeName;
}
