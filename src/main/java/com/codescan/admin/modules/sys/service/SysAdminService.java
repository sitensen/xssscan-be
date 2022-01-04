package com.codescan.admin.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codescan.admin.modules.sys.model.SysAdmin;
import com.codescan.admin.modules.sys.model.SysRole;
import com.codescan.admin.modules.sys.dto.SysAdminParam;
import com.codescan.admin.modules.sys.dto.UpdatePasswordParam;
import com.codescan.admin.modules.sys.model.SysResource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台管理员管理Service
 */
public interface SysAdminService extends IService<SysAdmin> {
    /**
     * 根据用户名获取后台管理员
     */
    SysAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    SysAdmin register(SysAdminParam sysAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 刷新token的功能
     * @param oldToken 旧的token
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户名或昵称分页查询用户
     */
    Page<SysAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     */
    boolean update(Long id, SysAdmin admin);

    /**
     * 删除指定用户
     */
    boolean delete(Long id);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取用户对于角色
     */
    List<SysRole> getRoleList(Long adminId);

    /**
     * 获取指定用户的可访问资源
     */
    List<SysResource> getResourceList(Long adminId);

    /**
     * 修改密码
     */
    int updatePassword(UpdatePasswordParam updatePasswordParam);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

}
