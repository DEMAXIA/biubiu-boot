package com.biubiu.domain.entity.sys;


import com.baomidou.mybatisplus.annotations.TableName;
import com.biubiu.domain.entity.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author tangjingxiang
 * @desc 用户
 */
@Data
@TableName(value = "sys_user")
public class SysUser extends BaseEntity {

    /**
     * 编号
     */
    private Long id;

    /**
     * 帐号
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 名称
     */
    private String name ;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系地址
     */
    private String address;


}
