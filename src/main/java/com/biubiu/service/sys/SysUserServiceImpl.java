package com.biubiu.service.sys;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.biubiu.domain.entity.sys.SysResource;
import com.biubiu.domain.entity.sys.SysUser;
import com.biubiu.domain.mapper.sys.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService  {

}
