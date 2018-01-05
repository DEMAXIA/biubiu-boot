package com.biubiu.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.biubiu.domain.entity.sys.SysUser;
import com.biubiu.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/sysUser", method = RequestMethod.POST)
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


}
