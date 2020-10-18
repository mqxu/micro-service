/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : user_center

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 18/10/2020 16:02:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bonus_event_log
-- ----------------------------
DROP TABLE IF EXISTS `bonus_event_log`;
CREATE TABLE `bonus_event_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `user_id` int(11) DEFAULT NULL COMMENT 'user.id',
  `value` int(11) DEFAULT NULL COMMENT '积分操作值',
  `event` varchar(20) DEFAULT NULL COMMENT '发生的事件',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  KEY `fk_bonus_event_log_user1_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COMMENT='积分变更记录表';

-- ----------------------------
-- Records of bonus_event_log
-- ----------------------------
BEGIN;
INSERT INTO `bonus_event_log` VALUES (104, 2, 50, 'CONTRIBUTE', '2020-10-18 13:04:23', '投稿加积分');
INSERT INTO `bonus_event_log` VALUES (105, 2, -20, 'BUY', '2020-10-18 13:07:08', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (106, 2, -10, 'BUY', '2020-10-18 13:07:23', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (107, 2, 50, 'CONTRIBUTE', '2020-10-18 13:12:06', '投稿加积分');
INSERT INTO `bonus_event_log` VALUES (108, 2, -10, 'BUY', '2020-10-18 13:43:44', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (109, 2, -10, 'BUY', '2020-10-18 13:44:22', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (110, 2, -5, 'BUY', '2020-10-18 13:45:14', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (111, 2, -10, 'BUY', '2020-10-18 13:50:29', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (112, 2, -10, 'BUY', '2020-10-18 13:51:40', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (113, 2, -15, 'BUY', '2020-10-18 13:56:39', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (114, 2, -10, 'BUY', '2020-10-18 14:07:34', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (115, 2, -5, 'BUY', '2020-10-18 14:07:59', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (116, 2, -20, 'BUY', '2020-10-18 14:10:19', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (117, 2, -10, 'BUY', '2020-10-18 14:10:28', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (118, 2, -10, 'BUY', '2020-10-18 14:12:33', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (119, 2, -10, 'BUY', '2020-10-18 14:14:29', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (120, 2, -10, 'BUY', '2020-10-18 14:15:55', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (121, 2, -5, 'BUY', '2020-10-18 14:19:01', '兑换分享');
INSERT INTO `bonus_event_log` VALUES (122, 2, -10, 'BUY', '2020-10-18 14:21:25', '兑换分享');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `mobile` varchar(11) NOT NULL COMMENT '手机号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `user_name` varchar(64) NOT NULL DEFAULT '' COMMENT '姓名',
  `avatar_url` varchar(255) NOT NULL DEFAULT '' COMMENT '头像地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='分享';

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, '13951905171', '123', '许莫淇', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/me.jpg', '2020-09-16 23:13:35', '2020-09-17 23:13:40');
INSERT INTO `t_user` VALUES (2, '13877776666', '123', '朱信磊', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/5.jpg', '2020-09-17 23:14:20', '2020-09-17 23:14:22');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `wx_id` varchar(64) NOT NULL DEFAULT '' COMMENT '微信id',
  `wx_nickname` varchar(64) NOT NULL DEFAULT '' COMMENT '微信昵称',
  `roles` varchar(100) NOT NULL DEFAULT '' COMMENT '角色',
  `avatar_url` varchar(255) NOT NULL DEFAULT '' COMMENT '头像地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `bonus` int(11) NOT NULL DEFAULT '300' COMMENT '积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='分享';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'oRrdQtzdq1JoBhC_q5G0xpy3JBAM', '许莫淇', 'admin', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo1G7u4FqibWzv1c3CWxjTG5MgOMOQw1GatHYgnTVSszRaNre7iakCT0ceibHdgxuicy84nFDicrggaf4g/132', '2020-10-16 06:23:50', '2020-10-16 06:23:50', 600);
INSERT INTO `user` VALUES (2, 'oNPLt4iSbaHgykdK1MtEGPKBRchI', '陶然然', 'user', 'https://i.loli.net/2020/10/18/Qr6nGAviczHeIRg.jpg', '2020-10-18 12:38:51', '2020-10-18 12:38:51', 120);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
