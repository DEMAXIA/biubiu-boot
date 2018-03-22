package com.biubiu.domain.entity.sys;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.biubiu.domain.entity.CommonEntity;
import lombok.Data;


/**
 * @author tangjingxiang
 * @date 20181018
 * @desc 角色
 */
@Data
@TableName("sys_role")
public class SysRole extends CommonEntity {

    /**
     * 编号
     */

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色文本
     */
    private String text;

    /**
     * 备注
     */
    private String remark;
}
