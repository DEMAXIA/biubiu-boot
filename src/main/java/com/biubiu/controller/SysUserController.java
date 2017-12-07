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


    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insertSysUser(@Valid SysUser sysUser, BindingResult result) {
        if (result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                return error.getDefaultMessage();
            }
        }
        sysUserService.insert(sysUser);

        return "success";
    }

    @RequestMapping(value = "/page")
    @ResponseBody
    public List<SysUser> queryPage(){
        return sysUserService.selectPage(new Page<>(1, 10)).getRecords();

    }

    @RequestMapping(value = "/transation")
    @ResponseBody
    public String testTransaion(){
        sysUserService.addTwoSysUser();
        return "success";
    }

}
