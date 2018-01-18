package com.biubiu.service.sys;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.biubiu.domain.entity.sys.SysRole;
import com.biubiu.domain.mapper.sys.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> selectRolesByUserId(Long userId) {
        return sysRoleMapper.selectRolesByUserId(userId);
    }

    @Override
    public List<SysRole> selectRolesByResourceId(Long resourceId) {
        return sysRoleMapper.selectRolesByResourceId(resourceId);
    }
}
