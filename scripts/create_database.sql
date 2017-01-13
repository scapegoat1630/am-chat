/*
数据库建表语句
*/
CREATE DATABASE IF NOT EXISTS `am_chating`;
USE `am_chating`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for am_user
-- ----------------------------
DROP TABLE IF EXISTS `am_user`;
CREATE TABLE `am_user` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `age` int(11) default '18' COMMENT '年龄',
  `birthday` date default NULL COMMENT '生日',
  `sex` int(3) default NULL COMMENT '男or女',
  `phonenumber` int(20) default NULL COMMENT '电话',
  `nickname` varchar(255) default NULL COMMENT '昵称',
  `address` varchar(255) default NULL COMMENT '地址',
  `headimage` varchar(255) default NULL COMMENT '头像',
  `intro` varchar(255) default NULL COMMENT '简介',
  `state` int(11) default '0' COMMENT '用户状态',
  `comments` varchar(255) default NULL COMMENT '备注',
  `k1` varchar(255) default NULL,
  `k2` int(11) default NULL,
  `k3` datetime default NULL,
  `k4` time default NULL,
  `k5` varchar(255) default NULL,
  `k6` varchar(255) default NULL,
  `k7` text,
  `k8` varchar(255) default NULL,
  `k9` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of am_user
-- ----------------------------
