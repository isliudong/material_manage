/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 05/08/2020 10:39:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ssm_item
-- ----------------------------
DROP TABLE IF EXISTS `ssm_item`;
CREATE TABLE `ssm_item`  (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '表ID，主键，供其他表做外键',
  `item_code` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物料编码',
  `item_uom` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物料单位',
  `item_description` varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物料描述',
  `start_active_date` date NULL DEFAULT NULL COMMENT '生效起始时间',
  `end_active_date` date NULL DEFAULT NULL COMMENT '生效结束时间',
  `enabled_flag` tinyint(1) NOT NULL DEFAULT 1 COMMENT '启用标识',
  `object_version_number` bigint(20) NOT NULL DEFAULT 1 COMMENT '版本号',
  `creation_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL DEFAULT -1,
  `last_updated_by` bigint(20) NOT NULL DEFAULT -1,
  `last_update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`item_id`) USING BTREE,
  UNIQUE INDEX `ssm_item_u1`(`item_code`) USING BTREE,
  INDEX `ssm_item_n1`(`item_description`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 134 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '物料' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
