/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : mtfance

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 12/10/2020 23:14:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for r_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `r_role_resource`;
CREATE TABLE `r_role_resource`  (
  `role_resource_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  `resource_id` bigint NOT NULL,
  PRIMARY KEY (`role_resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of r_role_resource
-- ----------------------------
INSERT INTO `r_role_resource` VALUES (1315649387870949376, 1315646910287187968, 1315647876671606784);
INSERT INTO `r_role_resource` VALUES (1315649387896115200, 1315646910287187968, 1315647904505008128);
INSERT INTO `r_role_resource` VALUES (1315649387917086720, 1315646910287187968, 1315647953876160512);
INSERT INTO `r_role_resource` VALUES (1315649387942252544, 1315646910287187968, 1315647994313445376);
INSERT INTO `r_role_resource` VALUES (1315649387963224064, 1315646910287187968, 1315648029163917312);
INSERT INTO `r_role_resource` VALUES (1315649592099999744, 1315646910287187968, 1315648052178063360);
INSERT INTO `r_role_resource` VALUES (1315649592129359872, 1315646910287187968, 1315648076861542400);
INSERT INTO `r_role_resource` VALUES (1315649592154525696, 1315646910287187968, 1315648107228303360);
INSERT INTO `r_role_resource` VALUES (1315649592179691520, 1315646910287187968, 1315648133002301440);
INSERT INTO `r_role_resource` VALUES (1315649592204857344, 1315646910287187968, 1315648170608431104);

-- ----------------------------
-- Table structure for r_user_role
-- ----------------------------
DROP TABLE IF EXISTS `r_user_role`;
CREATE TABLE `r_user_role`  (
  `user_role_id` bigint NOT NULL,
  `user_id` bigint NULL DEFAULT NULL,
  `role_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of r_user_role
-- ----------------------------
INSERT INTO `r_user_role` VALUES (1315648705742901248, 1315637456103673856, 1315646857921302528);
INSERT INTO `r_user_role` VALUES (1315648775313821696, 1315646253870223360, 1315646910287187968);
INSERT INTO `r_user_role` VALUES (1315648864505696256, 1315646301207138304, 1315646910287187968);
INSERT INTO `r_user_role` VALUES (1315648864535056384, 1315646301207138304, 1315646857921302528);

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource`  (
  `resource_id` bigint NOT NULL,
  `resource_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `route_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES (1315647876671606784, 'p1', '/v1/t1', -1, NULL, NULL);
INSERT INTO `t_resource` VALUES (1315647904505008128, 'p2', '/v1/t2', -1, NULL, NULL);
INSERT INTO `t_resource` VALUES (1315647953876160512, 'p3', '/v1/t3', -1, NULL, NULL);
INSERT INTO `t_resource` VALUES (1315647994313445376, 'p4', '/v1/t4', -1, NULL, NULL);
INSERT INTO `t_resource` VALUES (1315648029163917312, 'p5', '/v1/t5', -1, NULL, NULL);
INSERT INTO `t_resource` VALUES (1315648052178063360, 'p6', '/v1/t6', -1, NULL, NULL);
INSERT INTO `t_resource` VALUES (1315648076861542400, 'p7', '/v1/t7', -1, NULL, NULL);
INSERT INTO `t_resource` VALUES (1315648107228303360, 'p8', '/v1/t8', -1, NULL, NULL);
INSERT INTO `t_resource` VALUES (1315648133002301440, 'p9', '/v1/t9', -1, NULL, NULL);
INSERT INTO `t_resource` VALUES (1315648170608431104, 'p10', '/v1/t10', -1, NULL, NULL);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `role_id` bigint NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1315646857921302528, 'admin', NULL, NULL, NULL, NULL);
INSERT INTO `t_role` VALUES (1315646910287187968, 'client', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` bigint NOT NULL,
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int NULL DEFAULT NULL,
  `head_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1315637456103673856, 'zero', '$2a$10$BdTidnCBpuW3KhoziuyVV.d5sqA8NywuZOHBfeHfG4NX2m/RNsRuG', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (1315646253870223360, 'alex', '$2a$10$I3Zfx3ypErYB8Nzxgbxc4.iLqCQoUX8n1Z6i0UrCxIHkQHwK3iLH.', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (1315646301207138304, 'alexander', '$2a$10$AnivaqbrJflxtn9eCCBlGeNomvEE41yj7Ue3SaQ7/Q6NiabTttmxa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
