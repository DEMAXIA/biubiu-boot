package com.biubiu.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.biubiu.domain.entity.sys.SysUser;
import com.biubiu.domain.mapper.SysUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService  {


    @Transactional
    @Override
    public void addTwoSysUser() {
        SysUser sysUser1 = new SysUser();
        sysUser1.setName("张三");
        this.insert(sysUser1);

        int a = 1/0;

        SysUser sysUser2 = new SysUser();
        sysUser2.setName("李四");

        this.insert(sysUser2);

    }
}
