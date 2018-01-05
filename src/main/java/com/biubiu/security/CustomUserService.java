package com.biubiu.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.biubiu.domain.entity.sys.SysResource;
import com.biubiu.domain.entity.sys.SysUser;
import com.biubiu.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangjingxiang
 * desc: 自定义UserDetailsService 接口
 */

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.selectOne(new EntityWrapper<SysUser>().andNew("account={0}, enable={1}", username, 1));

        if (sysUser != null) {
            List<SysResource> sysResources = sysUserService.queryResourceByUserId(sysUser.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            GrantedAuthority grantedAuthority = null;
            for (SysResource sysResource : sysResources) {
                if (sysResource != null && sysResource.getAction() != null) {
                    grantedAuthority = new SimpleGrantedAuthority(sysResource.getAction());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(sysUser.getUserName(), sysUser.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("用户： " + username + " 不存在!");

        }
    }
}
