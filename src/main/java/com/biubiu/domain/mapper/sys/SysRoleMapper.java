package com.biubiu.domain.mapper.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.biubiu.domain.entity.sys.SysRole;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole> {


    List<SysRole> selectRolesByUserId(Long userId);

    List<SysRole> selectRolesByResourceId(Long resourceId);
}
