/*
 Navicat Premium Data Transfer

 Source Server         : bookbest
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : task11

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 05/03/2018 16:24:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classlist
-- ----------------------------
DROP TABLE IF EXISTS `classlist`;
CREATE TABLE `classlist`  (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `classID` int(20) NOT NULL,
  `className` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classlist
-- ----------------------------
INSERT INTO `classlist` VALUES (0, 0, '闲散学生');
INSERT INTO `classlist` VALUES (1, 1, '一班');
INSERT INTO `classlist` VALUES (2, 2, '二班');
INSERT INTO `classlist` VALUES (3, 3, '三班');
INSERT INTO `classlist` VALUES (4, 4, '四班');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `BIRTHDATE` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `CLASSID` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (16, '权限管理', '19941212', '东京', 0);
INSERT INTO `student` VALUES (17, '产品上架', '19941212', '东京', 0);
INSERT INTO `student` VALUES (18, '后端开发', '19941212', '东京', 0);

-- ----------------------------
-- Table structure for usersinfo
-- ----------------------------
DROP TABLE IF EXISTS `usersinfo`;
CREATE TABLE `usersinfo`  (
  `USERID` int(10) NOT NULL AUTO_INCREMENT,
  `PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`USERID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usersinfo
-- ----------------------------
INSERT INTO `usersinfo` VALUES (1, '1');

SET FOREIGN_KEY_CHECKS = 1;
