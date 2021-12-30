/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : subject

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 30/12/2021 18:25:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_subject
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `teacher` varchar(30) DEFAULT NULL,
  `contact` varchar(30) DEFAULT NULL,
  `s_id` varchar(255) DEFAULT NULL,
  `s_name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_subject_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
BEGIN;
INSERT INTO `t_subject` (`id`, `name`, `teacher`, `contact`, `s_id`, `s_name`, `status`) VALUES (1, '题目1', '马化腾', '122333221', '', '', 0);
INSERT INTO `t_subject` (`id`, `name`, `teacher`, `contact`, `s_id`, `s_name`, `status`) VALUES (2, '题目2', '雷军', '123322332', '', '', 0);
INSERT INTO `t_subject` (`id`, `name`, `teacher`, `contact`, `s_id`, `s_name`, `status`) VALUES (3, '题目3', '马云', '123321123', '', '', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
