package com.biubiu.service.sys;

import com.baomidou.mybatisplus.service.IService;
import com.biubiu.domain.entity.sys.SysResource;
import com.biubiu.domain.entity.sys.SysUser;

import java.util.List;

public interface SysUserService extends IService<SysUser> {

    /**
     * 查询用户资源
     *
     * @param userId
     * @return
     */
    List<SysResource> queryResourceByUserId(Long userId);
}
