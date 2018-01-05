package com.biubiu.domain.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.biubiu.domain.entity.sys.SysResource;
import com.biubiu.domain.entity.sys.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {


    List<SysResource> queryResourceByUserId(@Param("userId") Long userId);
}
