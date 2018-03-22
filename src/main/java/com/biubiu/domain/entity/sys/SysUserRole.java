package com.biubiu.domain.entity.sys;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.biubiu.domain.entity.CommonEntity;
import lombok.Data;


/**
 * @author tangjingxiang
 * @date 20180118
 * @desc 用户角色关联
 */
@Data
@TableName("sys_user_role")
public class SysUserRole extends CommonEntity {

    /**
     * 编号
     */

    @TableId(value="id", type= IdType.AUTO)
    private Long id;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 角色编号
     */
    private Long roleId;


}
