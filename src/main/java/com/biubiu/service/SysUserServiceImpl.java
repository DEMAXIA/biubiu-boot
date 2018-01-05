package com.biubiu.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.biubiu.domain.entity.sys.SysResource;
import com.biubiu.domain.entity.sys.SysUser;
import com.biubiu.domain.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService  {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysResource> queryResourceByUserId(Long userId) {
        return sysUserMapper.queryResourceByUserId(userId);
    }
}
