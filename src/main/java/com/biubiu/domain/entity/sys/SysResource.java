package com.biubiu.domain.entity.sys;

import com.baomidou.mybatisplus.annotations.TableName;
import com.biubiu.domain.entity.BaseEntity;
import lombok.Data;

/**
 * @author: tangjingxiang
 * @desc: 资源
 */

@Data
@TableName("sys_resource")
public class SysResource  extends BaseEntity{

    private Long id;

    private String name;

    private Integer type;

    private String action;


}
