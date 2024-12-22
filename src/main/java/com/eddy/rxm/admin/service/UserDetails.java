package com.eddy.rxm.admin.service;

import com.eddy.rxm.admin.entity.SysUser;
//import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public interface UserDetails {


//    public Collection<? extends GrantedAuthority> getAuthorities();

    public String getPassword();

    public String getUsername();

    public boolean isAccountNonExpired();

    public boolean isAccountNonLocked();

    public boolean isCredentialsNonExpired();

    public boolean isEnabled();
}
