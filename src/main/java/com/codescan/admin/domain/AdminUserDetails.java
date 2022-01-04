package com.codescan.admin.domain;

import com.codescan.admin.modules.sys.model.SysAdmin;
import com.codescan.admin.modules.sys.model.SysResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 */
public class AdminUserDetails implements UserDetails {

    private SysAdmin sysAdmin;

    private List<SysResource> resourceList;

    public AdminUserDetails(SysAdmin sysAdmin, List<SysResource> resourceList) {
        this.sysAdmin = sysAdmin;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return resourceList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId() + ":" + role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return sysAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return sysAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return sysAdmin.getStatus().equals(1);
    }
}
