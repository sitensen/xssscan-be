package com.codescan.admin.modules.sys.dto;

import com.codescan.admin.modules.sys.model.SysMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台菜单节点封装
 */
@Getter
@Setter
public class SysMenuNode extends SysMenu {

    @ApiModelProperty(value = "子级菜单")
    private List<SysMenuNode> children;

}
