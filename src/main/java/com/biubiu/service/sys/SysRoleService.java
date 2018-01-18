package com.biubiu.service.sys;

import com.baomidou.mybatisplus.service.IService;
import com.biubiu.domain.entity.sys.SysRole;

import java.util.List;


public interface SysRoleService extends IService<SysRole> {


    List<SysRole> selectRolesByUserId(Long userId);

    List<SysRole> selectRolesByResourceId(Long resourceId);
}
