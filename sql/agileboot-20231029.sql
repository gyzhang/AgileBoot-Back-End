-- ----------------------------
-- wf_category流程分类
-- ----------------------------
drop table if exists `wf_category`;
CREATE TABLE `wf_category` (
  `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '流程分类id',
  `category_code` varchar(64) DEFAULT '' COMMENT '分类编码',
  `category_name` varchar(64) DEFAULT '' COMMENT '分类名称',
  `category_sort` int NOT NULL COMMENT '显示顺序',
  `status` smallint NOT NULL COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator_id` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updater_id` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB COMMENT='流程分类';

-- ----------------------------
-- wf_form流程表单
-- ----------------------------
drop table if exists `wf_form`;
CREATE TABLE `wf_form` (
  `form_id` bigint NOT NULL AUTO_INCREMENT COMMENT '表单id',
  `form_code` varchar(64) NOT NULL COMMENT '表单编码',
  `form_name` varchar(64) NOT NULL COMMENT '表单名称',
  `form_content` longtext NOT NULL COMMENT '表单内容',
  `form_sort` int NOT NULL COMMENT '显示顺序',
  `status` smallint NOT NULL COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator_id` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updater_id` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`form_id`)
) ENGINE=InnoDB COMMENT='流程表单';