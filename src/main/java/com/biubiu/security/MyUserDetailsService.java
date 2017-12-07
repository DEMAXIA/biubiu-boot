package com.biubiu.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.biubiu.domain.entity.sys.SysUser;
import com.biubiu.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //TODO

        sysUserService.selectOne(new EntityWrapper<SysUser>().where("account={0}", userName));

        return null ;
    }
}
