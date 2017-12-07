package com.biubiu.domain.entity;

import lombok.Data;

import java.util.Date;


@Data
public class BaseEntity {

    /**
     * 可用状态
     */
    private Integer enable;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private Long updateBy;


}
