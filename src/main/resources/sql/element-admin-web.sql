/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : element-admin-web

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 28/11/2021 14:19:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES (1, 'test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'http://pic1.win4000.com/pic/7/b9/d3c51505435.jpg', 'test@qq.com', '测试账号', NULL, '2021-10-01 13:55:30', '2021-11-28 13:42:38', 1);
INSERT INTO `sys_admin` VALUES (3, 'admin', '$2a$10$qMovjce6wYUeJcz6c35Btu7vmQo40OZVU1t9ehmoUcIPPoM0.vqeG', 'http://pic1.win4000.com/pic/7/b9/d3c51505435.jpg', 'admin@163.com', '系统管理员', '系统管理员', '2021-10-08 13:32:47', '2021-11-28 13:42:15', 1);

-- ----------------------------
-- Table structure for sys_admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_login_log`;
CREATE TABLE `sys_admin_login_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_agent` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器登录类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 307 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_admin_login_log
-- ----------------------------
INSERT INTO `sys_admin_login_log` VALUES (287, 3, '2021-10-07 12:32:50', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (288, 3, '2021-10-07 12:32:54', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (289, 3, '2021-10-07 12:33:47', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (290, 3, '2021-10-07 12:35:12', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (291, 3, '2021-10-07 12:35:44', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (292, 3, '2021-10-07 13:27:56', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (293, 3, '2021-10-07 19:09:06', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (294, 3, '2021-10-10 10:06:29', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (295, 3, '2021-10-10 10:22:25', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (296, 3, '2021-10-10 10:49:33', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (297, 3, '2021-10-10 11:35:53', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (298, 3, '2021-10-10 12:17:55', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (299, 3, '2021-10-10 16:10:58', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (300, 3, '2021-11-20 12:50:54', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (301, 3, '2021-11-20 19:17:20', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (302, 3, '2021-11-27 11:29:00', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (303, 3, '2021-11-28 10:46:24', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (304, 3, '2021-11-28 12:24:54', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (305, 3, '2021-11-28 13:42:15', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `sys_admin_login_log` VALUES (306, 1, '2021-11-28 13:42:38', '0:0:0:0:0:0:0:1', NULL, NULL);

-- ----------------------------
-- Table structure for sys_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_role_relation`;
CREATE TABLE `sys_admin_role_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NULL DEFAULT NULL,
  `role_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户和角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_admin_role_relation
-- ----------------------------
INSERT INTO `sys_admin_role_relation` VALUES (26, 3, 5);
INSERT INTO `sys_admin_role_relation` VALUES (29, 1, 5);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `level` int(4) NULL DEFAULT NULL COMMENT '菜单级数',
  `sort` int(4) NULL DEFAULT NULL COMMENT '菜单排序',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端名称',
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端图标',
  `hidden` int(1) NULL DEFAULT NULL COMMENT '前端隐藏',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (21, 0, '2020-02-07 16:29:13', '系统权限', 0, 0, 'ums', 'ums', 0);
INSERT INTO `sys_menu` VALUES (22, 21, '2020-02-07 16:29:51', '用户列表', 1, 0, 'admin', 'ums-admin', 0);
INSERT INTO `sys_menu` VALUES (23, 21, '2020-02-07 16:30:13', '角色列表', 1, 0, 'role', 'ums-role', 0);
INSERT INTO `sys_menu` VALUES (24, 21, '2020-02-07 16:30:53', '菜单列表', 1, 0, 'menu', 'ums-menu', 0);
INSERT INTO `sys_menu` VALUES (25, 21, '2020-02-07 16:31:13', '资源列表', 1, 0, 'resource', 'ums-resource', 0);

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源URL',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '资源分类ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (25, '2020-02-07 16:47:34', '后台用户管理', '/admin/**', '', 4);
INSERT INTO `sys_resource` VALUES (26, '2020-02-07 16:48:24', '后台用户角色管理', '/role/**', '', 4);
INSERT INTO `sys_resource` VALUES (27, '2020-02-07 16:48:48', '后台菜单管理', '/menu/**', '', 4);
INSERT INTO `sys_resource` VALUES (28, '2020-02-07 16:49:18', '后台资源分类管理', '/resourceCategory/**', '', 4);
INSERT INTO `sys_resource` VALUES (29, '2020-02-07 16:49:45', '后台资源管理', '/resource/**', '', 4);

-- ----------------------------
-- Table structure for sys_resource_category
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource_category`;
CREATE TABLE `sys_resource_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `sort` int(4) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource_category
-- ----------------------------
INSERT INTO `sys_resource_category` VALUES (4, '2020-02-05 10:23:04', '权限模块', 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) NULL DEFAULT NULL COMMENT '后台用户数量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (5, '超级管理员', '拥有所有查看和操作功能', 0, '2020-02-02 15:11:05', 1, 0);
INSERT INTO `sys_role` VALUES (8, '权限管理员', '用于权限模块所有操作功能', 0, '2020-08-24 10:57:35', 1, 0);

-- ----------------------------
-- Table structure for sys_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu_relation`;
CREATE TABLE `sys_role_menu_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 126 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台角色菜单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu_relation
-- ----------------------------
INSERT INTO `sys_role_menu_relation` VALUES (111, 5, 21);
INSERT INTO `sys_role_menu_relation` VALUES (112, 5, 22);
INSERT INTO `sys_role_menu_relation` VALUES (113, 5, 23);
INSERT INTO `sys_role_menu_relation` VALUES (114, 5, 24);
INSERT INTO `sys_role_menu_relation` VALUES (115, 5, 25);
INSERT INTO `sys_role_menu_relation` VALUES (121, 8, 21);
INSERT INTO `sys_role_menu_relation` VALUES (122, 8, 22);
INSERT INTO `sys_role_menu_relation` VALUES (123, 8, 23);
INSERT INTO `sys_role_menu_relation` VALUES (124, 8, 24);
INSERT INTO `sys_role_menu_relation` VALUES (125, 8, 25);

-- ----------------------------
-- Table structure for sys_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource_relation`;
CREATE TABLE `sys_role_resource_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint(20) NULL DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 226 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台角色资源关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_resource_relation
-- ----------------------------
INSERT INTO `sys_role_resource_relation` VALUES (216, 5, 25);
INSERT INTO `sys_role_resource_relation` VALUES (217, 5, 26);
INSERT INTO `sys_role_resource_relation` VALUES (218, 5, 27);
INSERT INTO `sys_role_resource_relation` VALUES (219, 5, 28);
INSERT INTO `sys_role_resource_relation` VALUES (220, 5, 29);
INSERT INTO `sys_role_resource_relation` VALUES (221, 8, 25);
INSERT INTO `sys_role_resource_relation` VALUES (222, 8, 26);
INSERT INTO `sys_role_resource_relation` VALUES (223, 8, 27);
INSERT INTO `sys_role_resource_relation` VALUES (224, 8, 28);
INSERT INTO `sys_role_resource_relation` VALUES (225, 8, 29);

SET FOREIGN_KEY_CHECKS = 1;
