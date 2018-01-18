
USE biubiu;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------

DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `name` varchar(32) DEFAULT NULL COMMENT '资源名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '资源类型',
  `action` varchar(64) DEFAULT NULL COMMENT '资源路径',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `enable` tinyint(4) DEFAULT NULL COMMENT '可用状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) COMMENT='资源表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `text` varchar(32) DEFAULT NULL COMMENT '角色文本',
  `remark` varchar(128) DEFAULT NULL COMMENT '角色备注',
  `enable` tinyint(4) DEFAULT NULL COMMENT '可用状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) COMMENT='角色表';

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源编号',
  `enable` tinyint(4) DEFAULT NULL COMMENT '可用状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
)  COMMENT='角色资源关联表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `user_name` varchar(32) DEFAULT NULL COMMENT '登录账号',
  `name` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `type` tinyint(4) DEFAULT NULL COMMENT '用户类型',
  `mobile` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `address` varchar(128) DEFAULT NULL COMMENT '联系地址',
  `enable` tinyint(4) DEFAULT NULL COMMENT '可用状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) COMMENT='用户表';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  `enable` tinyint(4) DEFAULT NULL COMMENT '可用状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) COMMENT='用户角色关联表';



-- remember-me功能使用
# CREATE TABLE `persistent_logins` (
#   `username` varchar(64) NOT NULL,
#   `series` varchar(64) NOT NULL,
#   `token` varchar(64) NOT NULL,
#   `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
#   PRIMARY KEY (`series`)
# )