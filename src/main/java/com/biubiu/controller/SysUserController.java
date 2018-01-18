package com.biubiu.controller;


import com.biubiu.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/sysUser", method = RequestMethod.POST)
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


}
