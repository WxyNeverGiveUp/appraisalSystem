/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : db_check

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-08-11 12:43:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_ability_option`
-- ----------------------------
DROP TABLE IF EXISTS `t_ability_option`;
CREATE TABLE `t_ability_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_id` int(11) DEFAULT NULL COMMENT '能力指标考核问题表',
  `target_id` int(11) NOT NULL COMMENT '指标ID，来自能力指标考核指标表',
  `option_num` varchar(10) DEFAULT NULL COMMENT '选项编号',
  `option_name` varchar(10) DEFAULT NULL COMMENT '选项名称，例如优良中差',
  `max_score` float DEFAULT NULL COMMENT '得分上限',
  `min_score` float DEFAULT NULL COMMENT '得分下限',
  `option_content` varchar(255) DEFAULT NULL COMMENT '选项描述，该选项要表达的意思',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='能力指标 考核选项表';

-- ----------------------------
-- Records of t_ability_option
-- ----------------------------

-- ----------------------------
-- Table structure for `t_ability_position`
-- ----------------------------
DROP TABLE IF EXISTS `t_ability_position`;
CREATE TABLE `t_ability_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) NOT NULL COMMENT '部门ID',
  `be_check_id` int(11) NOT NULL COMMENT '被考核 用户ID',
  `check_id` int(11) DEFAULT NULL COMMENT '考核该用户的用户 ID',
  `target_id` int(11) DEFAULT NULL COMMENT '指标 ID，来自 考核能力指标表',
  `weight` varchar(20) DEFAULT NULL COMMENT '指标所占的权重',
  `is_available` tinyint(4) DEFAULT NULL COMMENT '是否可用，1是可用，0是不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='能力指标考核问题表';

-- ----------------------------
-- Records of t_ability_position
-- ----------------------------

-- ----------------------------
-- Table structure for `t_ability_result`
-- ----------------------------
DROP TABLE IF EXISTS `t_ability_result`;
CREATE TABLE `t_ability_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `be_check_id` int(11) NOT NULL COMMENT '被考核用户的ID',
  `check_id` int(11) DEFAULT NULL COMMENT '考核该用户的用户ID',
  `rid` int(11) DEFAULT NULL COMMENT '角色ID',
  `year` int(4) DEFAULT NULL COMMENT '当前年份',
  `did` int(11) DEFAULT NULL COMMENT '部门ID，来自部门表',
  `total_score` float DEFAULT NULL COMMENT '能力指标考核总得分',
  `is_submit` tinyint(4) DEFAULT NULL COMMENT '是否 提交，1是提交，0是 未提交',
  `finish_time` varchar(20) DEFAULT NULL COMMENT '完成测评的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='能力指标考核结果表';

-- ----------------------------
-- Records of t_ability_result
-- ----------------------------

-- ----------------------------
-- Table structure for `t_ability_target`
-- ----------------------------
DROP TABLE IF EXISTS `t_ability_target`;
CREATE TABLE `t_ability_target` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL COMMENT '指标类型ID，来自能力指标考核指标类型表',
  `name` varchar(50) DEFAULT NULL COMMENT '指标名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='能力指标考核指标表';

-- ----------------------------
-- Records of t_ability_target
-- ----------------------------

-- ----------------------------
-- Table structure for `t_ability_target_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_ability_target_type`;
CREATE TABLE `t_ability_target_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '指标类型名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='能力指标考核 指标类型表';

-- ----------------------------
-- Records of t_ability_target_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_administer`
-- ----------------------------
DROP TABLE IF EXISTS `t_administer`;
CREATE TABLE `t_administer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `did` int(11) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管辖分配表';

-- ----------------------------
-- Records of t_administer
-- ----------------------------

-- ----------------------------
-- Table structure for `t_department`
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '部门名字',
  `is_delete` tinyint(4) NOT NULL COMMENT '是否被删除，1是不被删除，0是被删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of t_department
-- ----------------------------

-- ----------------------------
-- Table structure for `t_performance`
-- ----------------------------
DROP TABLE IF EXISTS `t_performance`;
CREATE TABLE `t_performance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `be_check_id` int(11) NOT NULL COMMENT '被考核用户ID',
  `check_id` int(11) DEFAULT NULL COMMENT '考核该用户的用户ID',
  `year` int(4) DEFAULT NULL COMMENT '所在年份',
  `queater` tinyint(4) DEFAULT NULL COMMENT '所在季度',
  `month` int(4) DEFAULT NULL COMMENT '所在月份',
  `suggest_score` float DEFAULT NULL COMMENT '月度平均分',
  `summary_score` float DEFAULT NULL COMMENT '年度总结得分',
  `year_score` float DEFAULT NULL COMMENT '年度得分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='年度绩效综合评定表';

-- ----------------------------
-- Records of t_performance
-- ----------------------------

-- ----------------------------
-- Table structure for `t_power`
-- ----------------------------
DROP TABLE IF EXISTS `t_power`;
CREATE TABLE `t_power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `power` int(3) DEFAULT NULL COMMENT '权限等级，数字越小，等级越高',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_power
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '角色名字',
  `is_delete` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否删除，0是删除，1是不被删除',
  `pid` int(11) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_summary`
-- ----------------------------
DROP TABLE IF EXISTS `t_summary`;
CREATE TABLE `t_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `be_check_id` int(11) DEFAULT NULL COMMENT '被考核用户ID',
  `check_id` int(11) DEFAULT NULL COMMENT '考核该用户的ID',
  `year` int(4) DEFAULT NULL COMMENT '所在年份',
  `content` text COMMENT '年度总结报告',
  `summary_score` float DEFAULT NULL COMMENT '年度总结得分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='年度总结表';

-- ----------------------------
-- Records of t_summary
-- ----------------------------

-- ----------------------------
-- Table structure for `t_test_plan`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_plan`;
CREATE TABLE `t_test_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '开通考核人员的ID',
  `test_type_id` int(11) DEFAULT NULL COMMENT '考核类型ID',
  `start_time` varchar(50) DEFAULT NULL COMMENT '评测开始时间',
  `finish_time` varchar(50) DEFAULT NULL COMMENT '评测结束时间',
  `test_name` varchar(50) DEFAULT NULL COMMENT '评测名字',
  `is_avaiable` tinyint(4) DEFAULT NULL COMMENT '是否可用，1是可用，0是不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考核计划表';

-- ----------------------------
-- Records of t_test_plan
-- ----------------------------

-- ----------------------------
-- Table structure for `t_test_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_type`;
CREATE TABLE `t_test_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '考核类型名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考核计划类别表';

-- ----------------------------
-- Records of t_test_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(30) DEFAULT NULL COMMENT '密码',
  `did` int(11) NOT NULL DEFAULT '0' COMMENT '部门ID',
  `dname` varchar(50) DEFAULT NULL COMMENT '部门名字当部门选定后，自动跳出，用户不能进行修改，只能调用',
  `rid` int(11) DEFAULT NULL COMMENT '角色ID',
  `pname` varchar(50) DEFAULT NULL COMMENT '权限名字，当角色选定后，自动跳出，用户不能进行修改，只能调用',
  `is_join_check` tinyint(4) DEFAULT NULL COMMENT '是否参与考核，1是参与考核，0是不参与考核',
  `is_be_check` tinyint(4) DEFAULT NULL COMMENT '是否被考核，1是被考核，0是不被考核',
  `status` tinyint(4) DEFAULT NULL COMMENT '审核状态，0是未审核，1是审核通过，2是审核不通过',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '是否被删除，0是被删除，1是不被删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for `t_work_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_work_detail`;
CREATE TABLE `t_work_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wid` int(11) DEFAULT NULL COMMENT '工作计划ID',
  `start_time` varchar(50) DEFAULT NULL COMMENT '计划开始时间',
  `end_time` varchar(50) DEFAULT NULL COMMENT '计划结束时间',
  `plan_content` varchar(255) DEFAULT NULL COMMENT '该条工作计划的内容',
  `expect_result` varchar(255) DEFAULT NULL COMMENT '预期工作结果',
  `weight` varchar(20) DEFAULT NULL COMMENT '所占权重',
  `completion` varchar(255) DEFAULT NULL COMMENT '完成情况说明',
  `test_score` float DEFAULT NULL COMMENT '考核得分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作计划每条的详情表';

-- ----------------------------
-- Records of t_work_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `t_work_plan`
-- ----------------------------
DROP TABLE IF EXISTS `t_work_plan`;
CREATE TABLE `t_work_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `be_check_id` int(11) DEFAULT NULL COMMENT '被考核用户ID',
  `check_id` int(11) DEFAULT NULL COMMENT '考核人员ID',
  `year` int(4) DEFAULT NULL COMMENT '所在年份',
  `month` int(4) DEFAULT NULL COMMENT '所在月份',
  `queater` tinyint(4) DEFAULT NULL COMMENT '所在季度',
  `month_score` float DEFAULT NULL COMMENT '月度得分',
  `queater_score` float DEFAULT NULL COMMENT '季度得分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作计划表';

-- ----------------------------
-- Records of t_work_plan
-- ----------------------------
