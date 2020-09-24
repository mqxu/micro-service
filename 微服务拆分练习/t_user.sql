/*
 Navicat Premium Data Transfer

 Source Server         : aliyun-connect
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 39.98.143.134:3306
 Source Schema         : user_center

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 24/09/2020 14:58:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='分享';

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, '13951905171', '123', '许莫淇', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/me.jpg', '2020-09-16 23:13:35', '2020-09-17 23:13:40');
INSERT INTO `t_user` VALUES (2, '13877776666', '123', '朱信磊', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/5.jpg', '2020-09-17 23:14:20', '2020-09-17 23:14:22');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
