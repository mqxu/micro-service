/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : content_center

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 18/10/2020 16:02:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mid_user_share
-- ----------------------------
DROP TABLE IF EXISTS `mid_user_share`;
CREATE TABLE `mid_user_share` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `share_id` int(11) NOT NULL COMMENT 'share.id',
  `user_id` int(11) NOT NULL COMMENT 'user.id',
  PRIMARY KEY (`id`),
  KEY `fk_mid_user_share_share1_idx` (`share_id`),
  KEY `fk_mid_user_share_user1_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COMMENT='用户-分享中间表【描述用户购买的分享】';

-- ----------------------------
-- Records of mid_user_share
-- ----------------------------
BEGIN;
INSERT INTO `mid_user_share` VALUES (1, 1, 1);
INSERT INTO `mid_user_share` VALUES (2, 2, 1);
INSERT INTO `mid_user_share` VALUES (3, 3, 1);
INSERT INTO `mid_user_share` VALUES (4, 4, 1);
INSERT INTO `mid_user_share` VALUES (5, 5, 1);
INSERT INTO `mid_user_share` VALUES (6, 6, 1);
INSERT INTO `mid_user_share` VALUES (7, 7, 1);
INSERT INTO `mid_user_share` VALUES (8, 8, 1);
INSERT INTO `mid_user_share` VALUES (9, 9, 1);
INSERT INTO `mid_user_share` VALUES (10, 10, 1);
INSERT INTO `mid_user_share` VALUES (11, 11, 1);
INSERT INTO `mid_user_share` VALUES (12, 12, 1);
INSERT INTO `mid_user_share` VALUES (13, 13, 1);
INSERT INTO `mid_user_share` VALUES (91, 19, 2);
INSERT INTO `mid_user_share` VALUES (92, 18, 2);
INSERT INTO `mid_user_share` VALUES (93, 16, 2);
INSERT INTO `mid_user_share` VALUES (105, 13, 2);
INSERT INTO `mid_user_share` VALUES (106, 12, 2);
INSERT INTO `mid_user_share` VALUES (107, 121, 2);
INSERT INTO `mid_user_share` VALUES (108, 11, 2);
INSERT INTO `mid_user_share` VALUES (109, 10, 2);
INSERT INTO `mid_user_share` VALUES (110, 9, 2);
INSERT INTO `mid_user_share` VALUES (111, 8, 2);
COMMIT;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(255) NOT NULL DEFAULT '' COMMENT '内容',
  `show_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否显示 0:否 1:是',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of notice
-- ----------------------------
BEGIN;
INSERT INTO `notice` VALUES (1, '关注你我之书，发现更多精彩', 1, '2020-09-29 12:36:49');
INSERT INTO `notice` VALUES (2, 'aaa', 0, '2020-10-04 11:16:08');
INSERT INTO `notice` VALUES (3, 'bbb', 0, '2020-10-04 11:16:18');
COMMIT;

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '发布人id',
  `title` varchar(80) NOT NULL DEFAULT '' COMMENT '标题',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `is_original` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否原创 0:否 1:是',
  `author` varchar(45) NOT NULL DEFAULT '' COMMENT '作者',
  `cover` varchar(256) NOT NULL DEFAULT '' COMMENT '封面',
  `summary` varchar(256) NOT NULL DEFAULT '' COMMENT '概要信息',
  `price` int(11) NOT NULL DEFAULT '0' COMMENT '价格（需要的积分）',
  `download_url` varchar(256) NOT NULL DEFAULT '' COMMENT '下载地址',
  `buy_count` int(11) NOT NULL DEFAULT '0' COMMENT '下载数 ',
  `show_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否显示 0:否 1:是',
  `audit_status` varchar(10) NOT NULL DEFAULT '0' COMMENT '审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过',
  `reason` varchar(200) DEFAULT '' COMMENT '审核不通过原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4 COMMENT='分享表';

-- ----------------------------
-- Records of share
-- ----------------------------
BEGIN;
INSERT INTO `share` VALUES (1, 1, '测试课程', '2020-10-15 21:13:44', '2020-10-15 21:13:48', 0, '测试', 'https://img1.sycdn.imooc.com/szimg/5cf47ccf0834940306000338-240-180.jpg', '测试课程', 5, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 5, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (2, 2, 'Go语言从入门到达人之路', '2020-10-15 17:02:06', '2020-10-15 17:02:08', 0, 'Google工程师', 'https://img1.sycdn.imooc.com/szimg/5cf47ccf0834940306000338-240-180.jpg', '从0开始搭建分布式爬虫，理解分布式系统设计思想\n从0开始搭建分布式爬虫，理解分布式系统设计思想\n从0开始搭建分布式爬虫，理解分布式系统设计思想\n从0开始搭建分布式爬虫，理解分布式系统设计思想\n', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 0, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (3, 1, 'Spring Cloud分布式微服务实战', '2020-10-15 16:00:23', '2020-10-15 16:00:26', 0, '风间影月', 'https://img3.mukewang.com/szimg/5f583a2609dc33b412000676-360-202.png', 'Spring Cloud分布式微服务实战\n养成应对复杂业务的综合技术能力\n分布式/前后端分离/项目分层聚合 一体化开发门户平台＋媒体中心+运营中心3大业务平台', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 0, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (4, 1, '算法与数据结构', '2020-10-01 17:19:56', '2020-10-01 17:19:58', 0, '算法爱好者', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/算法与数据结构.jpg', '数据结构是一种具有一定逻辑关系，在计算机中应用某种存储结构，并且封装了相应操作的数据元素集合。它包含三方面的内容，逻辑关系、存储关系及操作。', 5, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 20, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (5, 1, '微信小程序实战', '2020-10-01 17:19:56', '2020-10-01 17:19:58', 0, 'Tencent', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/微信小程序.jpg', '小程序是一种新的开放能力，开发者可以快速地开发一个小程序。小程序可以在微信内被便捷地获取和传播，同时具有出色的使用体验。', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 20, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (6, 1, '消息队列rabbitMQ', '2020-10-01 17:19:56', '2020-10-01 17:19:58', 0, 'MQ社区', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/rabbitMQ.jpg', '消息（Message）是指在应用间传送的数据。消息可以非常简单，比如只包含文本字符串，也可以更复杂，可能包含嵌入对象。', 15, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 20, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (7, 1, 'Vue.js中文文档', '2020-10-01 17:19:56', '2020-10-01 17:19:58', 0, '尤雨溪', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Vue.jpg', 'Vue是一套用于构建用户界面的渐进式框架。与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 20, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (8, 1, 'Spring Cloud Alibaba实战', '2020-10-01 17:19:56', '2020-10-01 17:19:58', 0, '阿里巴巴', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Spring Cloud Alibaba.jpg', 'Spring Cloud Alibaba 致力于提供微服务开发的一站式解决方案。此项目包含开发分布式应用服务的必需组件，方便开发者通过 Spring Cloud 编程模型轻松使用这些组件来开发分布式应用服务。', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 20, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (9, 1, 'Python学习笔记', '2020-10-01 17:19:56', '2020-10-01 17:19:58', 1, 'Python之父', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Python.jpg', 'Python 是一种解释型、面向对象、动态数据类型的高级程序设计语言。Python 由 Guido van Rossum 于 1989 年底发明，第一个公开发行版发行于 1991 年。', 5, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 20, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (10, 1, 'Linux学习笔记', '2020-10-01 17:19:56', '2020-10-01 17:19:58', 1, 'Linux之父', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Linux.jpg', '一提到 Linux，许多人都会说到“自由”，但我不认为他们都知道“自由”的真正涵义。“自由”是一种权力， 它决定你的计算机能做什么，同时能够拥有这种“自由”的唯一方式就是知道计算机正在做什么。 “自由”是指一台没有任何秘密的计算机，你可以从它那里了解一切，只要你用心的去寻找。', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 20, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (11, 1, 'JavaScript学习笔记', '2020-10-01 17:19:56', '2020-10-01 17:19:58', 1, 'JS大神', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/JavaScript.jpg', 'JavaScript ( JS ) 是一种具有函数优先的轻量级，解释型或即时编译型的编程语言。', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 20, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (12, 1, 'Java并发编程实战', '2020-09-29 16:14:21', '2020-09-29 16:14:24', 0, 'Java大神', 'https://coding.imooc.com/static/module/class/content/img/132/section2-1.png', '对于一个Java 程序员而言，能否熟练掌握并发编程是判断他优秀与否的重要标准之一。因为并发编程是Java 语言中最为晦涩的知识点，它涉及操作系统、内存、CPU、编程语言等多方面的基础能力，更为考验一个程序员的内功。', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 20, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (13, 1, '微服务技术', '2020-09-29 12:35:16', '2020-09-29 12:35:20', 1, '佚名', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Spring%20Cloud%20Alibaba.jpg', 'Spring 要理解微服务，首先要先理解不是微服务的那些。通常跟微服务相对的是单体应用，即将所有功能都打包成在一个独立单元的应用程序。从单体应用到微服务并不是一蹴而就的，这是一个逐渐演变的过程。', 20, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 30, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (14, 2, '计算机基础', '2020-10-17 20:02:37', '2020-10-17 20:02:37', 1, 'mqxu', 'https://img2.sycdn.imooc.com/szimg/5b3082da0001d7e905400300-360-202.jpg', '计算机基础知识大全', 5, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 5, 0, 'PASS', '通过审核');
INSERT INTO `share` VALUES (15, 2, '测试资源', '2020-10-17 20:42:13', '2020-10-17 20:42:13', 1, '陶然然', 'https://img3.sycdn.imooc.com/szimg/5b3082da0001d7e905400300-360-202.jpg', '测试资源', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 0, 0, 'NOT_YET', '未审核');
INSERT INTO `share` VALUES (16, 2, 'HTTP协议', '2020-10-18 00:07:16', '2020-10-18 00:07:16', 0, 'mqxu', 'https://img2.sycdn.imooc.com/szimg/5d1032ab08719e0906000338-360-202.jpg', 'HTTP协议相关知识', 5, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 0, 0, 'PASS', '通过审核');
INSERT INTO `share` VALUES (17, 2, 'JavaScript中的算法', '2020-10-18 10:59:09', '2020-10-18 10:59:09', 0, 'Lewis', 'https://img4.sycdn.imooc.com/szimg/5edf24fd081fde7906000338-360-202.jpg', '用JS语言解决LeetCode上的经典算法题，对每一道题都进行线上测试，每题都有时间/空间复杂度分析。结合前端实际开发情景，带你掌握数据结构与算法。', 15, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 0, 0, 'NOT_YET', '未审核');
INSERT INTO `share` VALUES (18, 2, 'Node.js调试入门', '2020-10-18 11:38:10', '2020-10-18 11:38:10', 1, 'Lewis', 'https://img3.sycdn.imooc.com/5c3eaa0a08d7052706000338-360-202.jpg', '学会高效调试 Node.js 会让日常开发更高效', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 0, 0, 'REJECT', '地址不合法');
INSERT INTO `share` VALUES (19, 2, '软件测试进阶之路', '2020-10-18 11:39:58', '2020-10-18 11:39:58', 1, '风落几番', 'https://img3.sycdn.imooc.com/5c60f2e80984689c05400300-360-202.png', '新时代软件测试人员的职责、功能测试、性能测试等知识，让测试人员能更好的掌握学习路线。', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 0, 1, 'PASS', '通过审核');
INSERT INTO `share` VALUES (20, 1, 'Vue2.x 核心技术', '2020-10-18 11:41:05', '2020-10-18 11:41:05', 0, 'Brian', 'https://img3.sycdn.imooc.com/5c21e60d0822d58e06000338-360-202.jpg', '了解vue2.x的核心技术，建立前端组件化的思想', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 0, 0, 'NOT_YET', '未审核');
INSERT INTO `share` VALUES (21, 1, '测试资源', '2020-10-18 12:22:53', '2020-10-18 12:22:53', 1, 'Taoranran ', 'https://img2.sycdn.imooc.com/szimg/5b3082da0001d7e905400300-360-202.jpg', '这是个优秀的资源', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 0, 0, 'NOT_YET', '未审核');
INSERT INTO `share` VALUES (121, 2, 'test', '2020-10-18 13:10:27', '2020-10-18 13:10:27', 0, 'mqxu', 'https://img2.sycdn.imooc.com/szimg/5b3082da0001d7e905400300-360-202.jpg', 'test资源', 10, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn', 0, 1, 'PASS', '通过审核');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
