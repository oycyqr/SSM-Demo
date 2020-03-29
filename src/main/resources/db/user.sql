/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 16/04/2019 00:34:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `ssm_demo`.`user`(`id`, `username`, `sex`, `phone`, `create_time`, `update_time`) VALUES (1, 'oy', 18, '18012345678', '2020-03-29 10:50:15', '2020-03-29 10:50:15');
INSERT INTO `ssm_demo`.`user`(`id`, `username`, `sex`, `phone`, `create_time`, `update_time`) VALUES (2, 'oy1', 18, '13700990099', '2020-03-29 10:49:47', '2020-03-29 10:49:47');
INSERT INTO `ssm_demo`.`user`(`id`, `username`, `sex`, `phone`, `create_time`, `update_time`) VALUES (3, 'oy2', 18, '13700990099', '2020-03-29 10:49:51', '2020-03-29 10:49:51');
INSERT INTO `ssm_demo`.`user`(`id`, `username`, `sex`, `phone`, `create_time`, `update_time`) VALUES (4, 'oy3', 18, '13700990099', '2020-03-29 10:49:54', '2020-03-29 10:49:54');
INSERT INTO `ssm_demo`.`user`(`id`, `username`, `sex`, `phone`, `create_time`, `update_time`) VALUES (5, 'oy4', 18, '13700990099', '2020-03-29 10:49:58', '2020-03-29 10:49:58');

SET FOREIGN_KEY_CHECKS = 1;
