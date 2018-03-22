package com.biubiu.domain.entity.sys;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.biubiu.domain.entity.CommonEntity;
import lombok.Data;

/**
 * @author: tangjingxiang
 * @date 20180118
 * @desc: 资源
 */

@Data
@TableName("sys_resource")
public class SysResource extends CommonEntity {

    /**
     * 编号
     */

    @TableId(value="id", type= IdType.AUTO)
    private Long id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * 资源路径
     */
    private String action;


}
