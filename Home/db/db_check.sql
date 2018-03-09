/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : db_check

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-09-24 21:32:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_ability_option`
-- ----------------------------
DROP TABLE IF EXISTS `t_ability_option`;
CREATE TABLE `t_ability_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_id` int(11) DEFAULT NULL COMMENT '能力指标考核问题表',
  `target_id` int(11) DEFAULT NULL COMMENT '指标ID，来自能力指标考核指标表',
  `option_name` int(10) DEFAULT NULL COMMENT '选项名称，例如优良中差',
  `max_score` float DEFAULT NULL COMMENT '得分上限',
  `min_score` float DEFAULT NULL COMMENT '得分下限',
  `option_content` varchar(255) DEFAULT NULL COMMENT '选项描述，该选项要表达的意思',
  `test_id` int(11) DEFAULT NULL COMMENT '此次考核计划的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='能力指标 考核选项表';

-- ----------------------------
-- Records of t_ability_option
-- ----------------------------

-- ----------------------------
-- Table structure for `t_ability_position`
-- ----------------------------
DROP TABLE IF EXISTS `t_ability_position`;
CREATE TABLE `t_ability_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL COMMENT '部门ID',
  `target_id` varchar(200) DEFAULT NULL COMMENT '指标 ID，来自 考核能力指标表',
  `weight` int(3) DEFAULT NULL COMMENT '指标所占的权重',
  `is_available` tinyint(4) DEFAULT NULL COMMENT '是否可用，1是可用，0是不可用',
  `test_id` int(11) DEFAULT NULL COMMENT '考核计划ID',
  `target_type_id` varchar(100) DEFAULT NULL COMMENT '考核计划指标ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='能力指标考核问题表';

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
  `test_id` int(11) DEFAULT NULL COMMENT '考核计划ID',
  `is_join` tinyint(4) DEFAULT '0' COMMENT '是否参与此次考核，已考核为1，未考核为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='能力指标考核结果表';

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='能力指标考核指标表';

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='能力指标考核 指标类型表';

-- ----------------------------
-- Records of t_ability_target_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_ability_test`
-- ----------------------------
DROP TABLE IF EXISTS `t_ability_test`;
CREATE TABLE `t_ability_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_id` int(11) DEFAULT NULL COMMENT '此次考核计划的ID',
  `be_check_id` int(11) DEFAULT NULL COMMENT '被考核用户的ID',
  `check_id` int(11) DEFAULT NULL COMMENT '考核此用户的ID',
  `score` float DEFAULT NULL COMMENT '此次考核得分',
  `is_join` tinyint(4) DEFAULT '0' COMMENT '是否参与此次考核，1是已经参与，0是未参与',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ability_test
-- ----------------------------

-- ----------------------------
-- Table structure for `t_allot`
-- ----------------------------
DROP TABLE IF EXISTS `t_allot`;
CREATE TABLE `t_allot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `did` int(11) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='管辖分配表';

-- ----------------------------
-- Records of t_allot
-- ----------------------------

-- ----------------------------
-- Table structure for `t_department`
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '部门名字',
  `is_delete` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否被删除，1是不被删除，0是被删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '人力资源部门', '1');
INSERT INTO `t_department` VALUES ('2', '安全部门', '1');
INSERT INTO `t_department` VALUES ('3', '管理部门', '1');
INSERT INTO `t_department` VALUES ('4', '产品部门', '1');
INSERT INTO `t_department` VALUES ('5', '开发部门', '1');
INSERT INTO `t_department` VALUES ('6', '技术部门', '1');

-- ----------------------------
-- Table structure for `t_join_test`
-- ----------------------------
DROP TABLE IF EXISTS `t_join_test`;
CREATE TABLE `t_join_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_id` int(11) DEFAULT NULL COMMENT '考核计划ID',
  `uid` int(11) DEFAULT NULL COMMENT '参与该考核计划的用户ID',
  `is_join` tinyint(4) DEFAULT '0' COMMENT '0是没有被考核过，1是被考核 过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_join_test
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
  `suggest_score` float(4,0) DEFAULT NULL COMMENT '月度平均分',
  `summary_score` float(4,0) DEFAULT NULL COMMENT '年度总结得分',
  `year_score` float(4,0) DEFAULT NULL COMMENT '年度得分',
  `did` int(11) DEFAULT NULL COMMENT '被考核用户的部门ID',
  `rid` int(11) DEFAULT NULL COMMENT '考核用户的',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='年度绩效综合评定表';

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
  `detail` varchar(255) DEFAULT NULL COMMENT '权限等级的详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_power
-- ----------------------------
INSERT INTO `t_power` VALUES ('1', '1', '超级管理员，拥有 整个系统的所有权限');
INSERT INTO `t_power` VALUES ('2', '2', '可以执行除了除了超级管理员或者增删管理员的所有操作');
INSERT INTO `t_power` VALUES ('3', '3', '可以对除了系统管理模块之外的模块进行所有的操作');
INSERT INTO `t_power` VALUES ('4', '4', '可以对所有的考核结果进行查询和导出');
INSERT INTO `t_power` VALUES ('5', '5', '可以对所有的考核结果进行查询和导出，并对副总经理进行考核');
INSERT INTO `t_power` VALUES ('6', '6', '可以对自己管辖的部门进行考核，可以查看所有的成绩');
INSERT INTO `t_power` VALUES ('7', '7', '可以对本部门，和副总经理进行考核，和查询本部门的所有成绩');
INSERT INTO `t_power` VALUES ('8', '8', '可以对本部门和本部门经理进行考核，查询本部门的所有成绩');
INSERT INTO `t_power` VALUES ('9', '9', '自己参与考核，和参与上一级领导的考核，可以查看自己的成绩');
INSERT INTO `t_power` VALUES ('10', '10', null);
INSERT INTO `t_power` VALUES ('11', '11', null);
INSERT INTO `t_power` VALUES ('12', '12', null);
INSERT INTO `t_power` VALUES ('13', '13', null);
INSERT INTO `t_power` VALUES ('14', '14', null);
INSERT INTO `t_power` VALUES ('15', '15', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', '1', '1');
INSERT INTO `t_role` VALUES ('2', '管理员', '1', '2');
INSERT INTO `t_role` VALUES ('3', '考核负责人', '1', '3');
INSERT INTO `t_role` VALUES ('4', '董事长', '1', '4');
INSERT INTO `t_role` VALUES ('5', '副书记', '1', '4');
INSERT INTO `t_role` VALUES ('6', '总经理', '1', '5');
INSERT INTO `t_role` VALUES ('7', '副总经理', '1', '6');
INSERT INTO `t_role` VALUES ('8', '部门经理', '1', '7');
INSERT INTO `t_role` VALUES ('9', '部门副经理', '1', '8');
INSERT INTO `t_role` VALUES ('10', '一般员工', '1', '9');

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
  `did` int(11) DEFAULT NULL COMMENT '部门ID',
  `is_join` tinyint(4) DEFAULT '0' COMMENT '是否参与考核，已参与为1，为参与为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='年度总结表';

-- ----------------------------
-- Records of t_summary
-- ----------------------------

-- ----------------------------
-- Table structure for `t_test_plan`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_plan`;
CREATE TABLE `t_test_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '开通考核人员的ID',
  `test_type_id` int(11) DEFAULT NULL COMMENT '考核类型ID',
  `start_time` varchar(50) DEFAULT NULL COMMENT '评测开始时间',
  `finish_time` varchar(50) DEFAULT NULL COMMENT '评测结束时间',
  `test_name` varchar(50) DEFAULT NULL COMMENT '评测名字',
  `is_available` tinyint(4) DEFAULT '1' COMMENT '是否可用，1是可用，0是不可用',
  `did` int(11) DEFAULT NULL COMMENT '部门ID',
  `year` int(11) DEFAULT NULL COMMENT '此次考核所属的的年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='考核计划表';

-- ----------------------------
-- Records of t_test_plan
-- ----------------------------

-- ----------------------------
-- Table structure for `t_test_position`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_position`;
CREATE TABLE `t_test_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `test_id` int(11) DEFAULT NULL COMMENT '本次考核计划的ID',
  `position_id` int(11) DEFAULT NULL COMMENT '本次考核计划所包含问题的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_test_position
-- ----------------------------

-- ----------------------------
-- Table structure for `t_test_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_type`;
CREATE TABLE `t_test_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '考核类型名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='考核计划类别表';

-- ----------------------------
-- Records of t_test_type
-- ----------------------------
INSERT INTO `t_test_type` VALUES ('1', '年度季度考核');
INSERT INTO `t_test_type` VALUES ('2', '年度月度考核');
INSERT INTO `t_test_type` VALUES ('3', '年度能力指标考核');
INSERT INTO `t_test_type` VALUES ('5', '季度考核');
INSERT INTO `t_test_type` VALUES ('6', '月度考核');

-- ----------------------------
-- Table structure for `t_url`
-- ----------------------------
DROP TABLE IF EXISTS `t_url`;
CREATE TABLE `t_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url_name` varchar(255) DEFAULT NULL COMMENT '路径权限的名字',
  `url` varchar(255) DEFAULT NULL COMMENT '访问路径',
  `power` tinyint(4) DEFAULT NULL COMMENT '权限等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_url
-- ----------------------------
INSERT INTO `t_url` VALUES ('1', '角色管理列表', '/role/list', '2');
INSERT INTO `t_url` VALUES ('2', '角色管理角色添加', '/role/toadd', '2');
INSERT INTO `t_url` VALUES ('3', '角色管理权限列表', '/power/list', '2');
INSERT INTO `t_url` VALUES ('4', '部门管理列表', '/department/list', '2');
INSERT INTO `t_url` VALUES ('5', '部门管理部门添加', '/department/toadd', '2');
INSERT INTO `t_url` VALUES ('6', '人员管理列表获取', '/user/list', '2');
INSERT INTO `t_url` VALUES ('7', '管辖分配列表获取', '/allot/list', '2');
INSERT INTO `t_url` VALUES ('8', '账号管理列表获取', '/user/account/list', '2');
INSERT INTO `t_url` VALUES ('9', '考核计划管理获取列表', '/testplan/list', '3');
INSERT INTO `t_url` VALUES ('10', '考核计划的添加', '/testplan/toadd', '3');
INSERT INTO `t_url` VALUES ('11', '考核计划人员的分配', '/testplan/toallot/#', '3');
INSERT INTO `t_url` VALUES ('12', '能力指标列表获取', '/ability/list', '3');

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
  `pname` int(11) DEFAULT NULL COMMENT '权限名字，当角色选定后，自动跳出，用户不能进行修改，只能调用',
  `is_join_check` tinyint(4) DEFAULT '0' COMMENT '是否参与考核，1是参与考核，0是不参与考核',
  `is_be_check` tinyint(4) DEFAULT NULL COMMENT '是否被考核，1是被考核，0是不被考核',
  `status` tinyint(4) DEFAULT '0' COMMENT '审核状态，0是未审核，1是审核通过，2是审核不通过',
  `is_delete` tinyint(4) DEFAULT '1' COMMENT '是否被删除，0是被删除，1是不被删除',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('13', 'admin', 'admin', 'ISMvKXpXpadDiUoOSoAfww==', '3', null, '1', null, '0', null, '1', '1', null, '15764321950');
INSERT INTO `t_user` VALUES ('14', '陶永攀', '陶永攀', 'WqgzENnc9u5qyUrGnl/kFw==', '1', null, '8', null, '0', null, '1', '1', null, '15764321950');

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
  `except_result` varchar(255) DEFAULT NULL COMMENT '预期工作结果',
  `weight` int(3) DEFAULT NULL COMMENT '所占权重',
  `completion` varchar(255) DEFAULT NULL COMMENT '完成情况说明',
  `test_score` float DEFAULT NULL COMMENT '考核得分',
  `uid` int(11) DEFAULT NULL COMMENT '被考核用户 的ID',
  `is_join` tinyint(4) DEFAULT '0' COMMENT '1参与过，0未参与',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='工作计划每条的详情表';

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
  `month_score` float DEFAULT '0' COMMENT '月度得分',
  `queater_score` float DEFAULT '0' COMMENT '季度得分',
  `test_id` int(11) DEFAULT NULL COMMENT '考核计划ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='工作计划表';

-- ----------------------------
-- Records of t_work_plan
-- ----------------------------
