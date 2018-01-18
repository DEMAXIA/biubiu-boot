package com.biubiu.service.sys;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.biubiu.domain.entity.sys.SysResource;
import com.biubiu.domain.mapper.sys.SysResourceMapper;
import org.springframework.stereotype.Service;


@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {
}
