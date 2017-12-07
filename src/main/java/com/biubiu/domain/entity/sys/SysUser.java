package com.biubiu.domain.entity.sys;


import com.baomidou.mybatisplus.annotations.TableName;
import com.biubiu.domain.entity.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

@TableName(value = "sys_user")
@Data
public class SysUser extends BaseEntity {

    /**
     * 编号
     */
    private Long id;

    /**
     * 帐号
     */
    @NotNull(message = "帐号不能为空")
    private String account;

    /**
     * 密码
     */
    @Size(min = 6, max = 16, message = "密码必须在6-12位之间")
    @NotNull(message = "密码不能为空")
    private String password;

    /**
     * 名称
     */

    @NotNull(message = "名称不能为空")
    private String name ;

    /**
     * 类型
     */
    @NotNull(message = "类型不能为空")
    private Integer type;

    /**
     * 手机号码
     */
    @Length(min = 11, max = 11, message = "手机号码不合法")
    @NotNull(message = "手机号码不能为空")
    private String mobile;

    /**
     * 邮箱
     */
    @Email(message = "不合法的邮箱")
    @NotNull(message = "邮箱不能为空")
    private String email;

    /**
     * 生日
     */
//    @Past(message = "生日不能大于当天")
//    @NotNull(message = "生日不能为空")
    private Date birthday;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    @Max(value = 100, message = "年纪太大了")
    private Integer age;

    /**
     * 联系地址
     */
    @NotNull(message = "地址不能为空")
    private String address;


}
