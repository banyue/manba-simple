/*
Navicat MySQL Data Transfer

Source Server         : manba
Source Server Version : 50634
Source Host           : rm-2ze5cglmlfldxqd20o.mysql.rds.aliyuncs.com:3306
Source Database       : mb_db_dat

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-09-28 18:15:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for man_comment
-- ----------------------------
DROP TABLE IF EXISTS `man_comment`;
CREATE TABLE `man_comment` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `content_type` int(11) NOT NULL COMMENT '评论内容类型',
  `content_id` bigint(20) NOT NULL COMMENT '评论内容ID',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_comment
-- ----------------------------

-- ----------------------------
-- Table structure for man_dict
-- ----------------------------
DROP TABLE IF EXISTS `man_dict`;
CREATE TABLE `man_dict` (
  `id` bigint(20) NOT NULL,
  `dict_type` int(11) NOT NULL COMMENT '字典类型',
  `dict_code` varchar(255) NOT NULL COMMENT '字典编码',
  `dict_content` varchar(255) DEFAULT NULL COMMENT '字典内容',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_dict
-- ----------------------------

-- ----------------------------
-- Table structure for man_fans
-- ----------------------------
DROP TABLE IF EXISTS `man_fans`;
CREATE TABLE `man_fans` (
  `user_id` bigint(20) NOT NULL,
  `fans_id` bigint(20) NOT NULL COMMENT '粉丝ID',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`fans_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_fans
-- ----------------------------

-- ----------------------------
-- Table structure for man_favorite
-- ----------------------------
DROP TABLE IF EXISTS `man_favorite`;
CREATE TABLE `man_favorite` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL COMMENT '收藏人ID',
  `content_type` int(11) NOT NULL COMMENT '收藏内容类型',
  `content_id` bigint(20) DEFAULT NULL COMMENT '收藏内容ID',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_favorite
-- ----------------------------

-- ----------------------------
-- Table structure for man_img
-- ----------------------------
DROP TABLE IF EXISTS `man_img`;
CREATE TABLE `man_img` (
  `id` bigint(20) NOT NULL,
  `img_url` varchar(255) NOT NULL COMMENT '图片URL',
  `img_source_type` int(11) NOT NULL COMMENT '图片来源类型',
  `img_source_id` bigint(20) NOT NULL COMMENT '图片来源ID',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_img
-- ----------------------------

-- ----------------------------
-- Table structure for man_integration
-- ----------------------------
DROP TABLE IF EXISTS `man_integration`;
CREATE TABLE `man_integration` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `integration` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_integration
-- ----------------------------

-- ----------------------------
-- Table structure for man_leave_message
-- ----------------------------
DROP TABLE IF EXISTS `man_leave_message`;
CREATE TABLE `man_leave_message` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `leave_user_id` bigint(20) NOT NULL COMMENT '留言人ID',
  `leave_message` varchar(2048) NOT NULL COMMENT '留言内容',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_leave_message
-- ----------------------------

-- ----------------------------
-- Table structure for man_message
-- ----------------------------
DROP TABLE IF EXISTS `man_message`;
CREATE TABLE `man_message` (
  `id` bigint(20) NOT NULL,
  `message` varchar(2048) NOT NULL COMMENT '消息内容',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID（如果是私密消息，此字段不为空）',
  `message_type` int(11) DEFAULT NULL COMMENT '1私密，2公开',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_message
-- ----------------------------

-- ----------------------------
-- Table structure for man_plan
-- ----------------------------
DROP TABLE IF EXISTS `man_plan`;
CREATE TABLE `man_plan` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `plan_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '计划时间',
  `plan_content` varchar(2048) NOT NULL COMMENT '计划内容',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_plan
-- ----------------------------

-- ----------------------------
-- Table structure for man_record
-- ----------------------------
DROP TABLE IF EXISTS `man_record`;
CREATE TABLE `man_record` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `record_content` varchar(2048) NOT NULL COMMENT '记录内容',
  `record_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_record
-- ----------------------------

-- ----------------------------
-- Table structure for man_simple_guild
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_guild`;
CREATE TABLE `man_simple_guild` (
  `id` bigint(20) NOT NULL,
  `guild_name` varchar(255) NOT NULL,
  `member_num` int(11) DEFAULT NULL,
  `liveness` int(11) DEFAULT NULL,
  `guild_photo` varchar(255) DEFAULT NULL,
  `declaration` varchar(2048) DEFAULT NULL,
  `create_user` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_guild
-- ----------------------------

-- ----------------------------
-- Table structure for man_simple_user
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_user`;
CREATE TABLE `man_simple_user` (
  `id` bigint(20) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `interesting` varchar(255) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_user
-- ----------------------------
INSERT INTO `man_simple_user` VALUES ('1', '18516145120', '123456', '张三', '1', '100,102', 'www.baidu.com', '2017-09-28 14:53:16', null);

-- ----------------------------
-- Table structure for man_simple_zone
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_zone`;
CREATE TABLE `man_simple_zone` (
  `id` bigint(20) NOT NULL,
  `zone_title` varchar(1024) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `zone_content` varchar(2048) DEFAULT NULL,
  `zone_image` varchar(255) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_zone
-- ----------------------------

-- ----------------------------
-- Table structure for man_user
-- ----------------------------
DROP TABLE IF EXISTS `man_user`;
CREATE TABLE `man_user` (
  `id` bigint(20) NOT NULL,
  `man_name` varchar(255) DEFAULT NULL COMMENT '慢吧专属名字',
  `phone` varchar(48) NOT NULL DEFAULT '' COMMENT '手机号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别',
  `summary` varchar(2048) DEFAULT NULL COMMENT '简介',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `cover_url` varchar(255) DEFAULT NULL COMMENT '封面URL',
  `photo_url` varchar(255) DEFAULT NULL COMMENT '头像URL',
  `interest` varchar(255) DEFAULT NULL COMMENT '兴趣',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_user
-- ----------------------------

-- ----------------------------
-- Table structure for man_whisper
-- ----------------------------
DROP TABLE IF EXISTS `man_whisper`;
CREATE TABLE `man_whisper` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `send_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '送达时间',
  `send_content` varchar(2048) NOT NULL COMMENT '悄悄话内容',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_whisper
-- ----------------------------
