package com.biubiu.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.biubiu.domain.entity.sys.SysRole;
import com.biubiu.domain.entity.sys.SysUser;
import com.biubiu.service.sys.SysRoleService;
import com.biubiu.service.sys.SysUserService;
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
 * @date 20180118
 * @desc: 自定义UserDetailsService 接口
 */

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.selectOne(new EntityWrapper<SysUser>().where("user_name={0} and enable={1}", username, 1));

        if (sysUser != null) {
            //查询用户所有角色
            List<SysRole> sysRoles = sysRoleService.selectRolesByUserId(sysUser.getId());

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            GrantedAuthority grantedAuthority = null;
            for (SysRole sysRole : sysRoles) {
                if (sysRole != null && sysRole.getText() != null) {
                    grantedAuthority = new SimpleGrantedAuthority(sysRole.getText());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(sysUser.getUserName(), sysUser.getPassword(), true, true, true, true, grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("用户名或密码错误!");

        }
    }
}
