/*
 Navicat Premium Data Transfer

 Source Server         : aliyun-connect
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 39.98.143.134:3306
 Source Schema         : course_center

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 24/09/2020 14:58:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int NOT NULL COMMENT '课程id',
  `user_id` int NOT NULL COMMENT '创建者id',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '封面图',
  `finished` tinyint NOT NULL DEFAULT '0' COMMENT '是否结束（0 未结束， 1 已结束）',
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_course
-- ----------------------------
BEGIN;
INSERT INTO `t_course` VALUES (1, 1, 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/cover/1.jpg', 0, ' 软件_1851');
INSERT INTO `t_course` VALUES (2, 2, 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/cover/2.jpg', 0, ' 软件_1851');
INSERT INTO `t_course` VALUES (3, 1, 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/cover/3jpg', 1, ' 软件_1851');
INSERT INTO `t_course` VALUES (4, 1, 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/cover/4.jpg', 1, ' 软件_1851');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
