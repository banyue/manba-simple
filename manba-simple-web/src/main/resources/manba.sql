/*
Navicat MySQL Data Transfer

Source Server         : o2o-promotion-125
Source Server Version : 50166
Source Host           : 192.168.156.125:3306
Source Database       : manba

Target Server Type    : MYSQL
Target Server Version : 50166
File Encoding         : 65001

Date: 2017-09-29 16:47:31
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `yn` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
  `publish_time` datetime DEFAULT NULL,
  `yn` int(2) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_zone
-- ----------------------------
INSERT INTO `man_simple_zone` VALUES ('1', '一个十年门户老编的哀叹：被今日头条革了命', '1', '一个十年门户老编的哀叹：被今日头条革了命', 'www.baidu.com/1.jpg', '2017-09-29 14:34:48', null, null);
INSERT INTO `man_simple_zone` VALUES ('2', '被赔“葱”的宾利车主现身 称赔“葱”大爷有点儿意思', '2', '被赔“葱”的宾利车主现身 称赔“葱”大爷有点儿意思', 'www.baidu.com/2.jpg', '2017-09-29 14:35:29', null, null);
INSERT INTO `man_simple_zone` VALUES ('3', '皇马续约阿森西奥至2023 年薪350万欧解约金5亿', '3', '皇马续约阿森西奥至2023 年薪350万欧解约金5亿', 'www.baidu.com/3.jpg', '2017-09-29 14:35:58', null, null);
INSERT INTO `man_simple_zone` VALUES ('4', '英国发现罗马时期铜制小狗雕像 伸舌头表情生动', '4', '英国发现罗马时期铜制小狗雕像 伸舌头表情生动', 'www.baidu.com/4.jpg', '2017-09-29 14:36:37', null, null);
INSERT INTO `man_simple_zone` VALUES ('5', '中国全面“封杀”比特币 外媒：戳破国际市场泡沫', '5', '中国全面“封杀”比特币 外媒：戳破国际市场泡沫', 'www.baidu.com/5.jpg', '2017-09-29 14:37:05', null, null);
