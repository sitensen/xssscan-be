package com.codescan.admin.modules.sys.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台用户和角色关系表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_admin_role_relation")
@ApiModel(value = "AdminRoleRelation对象", description = "后台用户和角色关系表")
public class SysAdminRoleRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long adminId;

    private Long roleId;

}
