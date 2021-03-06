package com.biubiu.domain.entity.sys;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.biubiu.domain.entity.CommonEntity;
import lombok.Data;

/**
 * @author tangjingxiang
 * @date 20180118
 * @desc 角色资源关联
 */

@Data
@TableName("sys_role_resource")
public class SysRoleResource extends CommonEntity {

    /**
     * 编号
     */

    @TableId(value="id", type= IdType.AUTO)
    private Long id;

    /**
     * 角色编号
     */
    private Long roleId;

    /**
     * 资源编号
     */
    private Long resourceId;


}
