/*
Source Database       : manba
Date: 2017-10-25 17:50:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for man_simple_comment
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_comment`;
CREATE TABLE `man_simple_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `zone_id` bigint(20) NOT NULL,
  `content` varchar(2048) NOT NULL,
  `comment_time` datetime DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_comment
-- ----------------------------

-- ----------------------------
-- Table structure for man_simple_favorite
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_favorite`;
CREATE TABLE `man_simple_favorite` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `zone_id` bigint(20) NOT NULL,
  `favorite_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_favorite
-- ----------------------------

-- ----------------------------
-- Table structure for man_simple_follow
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_follow`;
CREATE TABLE `man_simple_follow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `follow_id` bigint(20) NOT NULL,
  `follow_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_follow
-- ----------------------------

-- ----------------------------
-- Table structure for man_simple_guild
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_guild`;
CREATE TABLE `man_simple_guild` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
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
-- Table structure for man_simple_guild_user
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_guild_user`;
CREATE TABLE `man_simple_guild_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `guild_id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_guild_user
-- ----------------------------

-- ----------------------------
-- Table structure for man_simple_photo
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_photo`;
CREATE TABLE `man_simple_photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `photo_path` varchar(1024) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `busi_type` int(11) DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_photo
-- ----------------------------

-- ----------------------------
-- Table structure for man_simple_upvote
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_upvote`;
CREATE TABLE `man_simple_upvote` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `zone_id` bigint(20) NOT NULL,
  `upvote_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_upvote
-- ----------------------------

-- ----------------------------
-- Table structure for man_simple_user
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_user`;
CREATE TABLE `man_simple_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `interesting` varchar(255) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_user
-- ----------------------------
INSERT INTO `man_simple_user` VALUES ('1', '18516145120', '123456', '张三', '1', '100,102', 'www.baidu.com', '2017-09-28 14:53:16', null);

-- ----------------------------
-- Table structure for man_simple_zone
-- ----------------------------
DROP TABLE IF EXISTS `man_simple_zone`;
CREATE TABLE `man_simple_zone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `zone_title` varchar(1024) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `zone_content` varchar(2048) DEFAULT NULL,
  `zone_image` varchar(255) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `yn` int(2) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_simple_zone
-- ----------------------------
INSERT INTO `man_simple_zone` VALUES ('1', '一个十年门户老编的哀叹：被今日头条革了命', '1', '一个十年门户老编的哀叹：被今日头条革了命', 'www.baidu.com/1.jpg', '2017-09-29 14:34:48', '0', null);
INSERT INTO `man_simple_zone` VALUES ('2', '被赔“葱”的宾利车主现身 称赔“葱”大爷有点儿意思', '2', '被赔“葱”的宾利车主现身 称赔“葱”大爷有点儿意思', 'www.baidu.com/2.jpg', '2017-09-29 14:35:29', '0', null);
INSERT INTO `man_simple_zone` VALUES ('3', '皇马续约阿森西奥至2023 年薪350万欧解约金5亿', '3', '皇马续约阿森西奥至2023 年薪350万欧解约金5亿', 'www.baidu.com/3.jpg', '2017-09-29 14:35:58', '0', null);
INSERT INTO `man_simple_zone` VALUES ('4', '英国发现罗马时期铜制小狗雕像 伸舌头表情生动', '4', '英国发现罗马时期铜制小狗雕像 伸舌头表情生动', 'www.baidu.com/4.jpg', '2017-09-29 14:36:37', '0', null);
INSERT INTO `man_simple_zone` VALUES ('5', '中国全面“封杀”比特币 外媒：戳破国际市场泡沫', '5', '中国全面“封杀”比特币 外媒：戳破国际市场泡沫', 'www.baidu.com/5.jpg', '2017-09-29 14:37:05', '0', null);
INSERT INTO `man_simple_zone` VALUES ('6', '测试', '2', '测试内容', 'www.baidu.com/dd.jpg', '2017-09-29 16:48:46', '1', '2017-09-29 17:11:50');
INSERT INTO `man_simple_zone` VALUES ('7', '测试1', '2', '测试内容1', 'www.baidu.com/dd1.jpg', '2017-09-29 16:50:17', '0', null);
INSERT INTO `man_simple_zone` VALUES ('8', '测试3', '3', '测试内容3', 'www.baidu.com/dd3.jpg', '2017-09-29 17:07:41', '0', null);
