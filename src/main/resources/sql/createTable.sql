/*
 Navicat Premium Data Transfer

 Source Server         : Rick
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : Demo02

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 03/01/2020 14:05:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chain
-- ----------------------------
DROP TABLE IF EXISTS `chain`;
CREATE TABLE `chain` (
  `ID` int(11) NOT NULL,
  `restaurantID` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of chain
-- ----------------------------
BEGIN;
INSERT INTO `chain` VALUES (1, 1, 'Rick');
COMMIT;

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `foodType` varchar(255) DEFAULT NULL,
  `restaurantID` int(11) DEFAULT NULL,
  `imageURL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_food` (`restaurantID`),
  CONSTRAINT `fk_food` FOREIGN KEY (`restaurantID`) REFERENCES `restaurant` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of food
-- ----------------------------
BEGIN;
INSERT INTO `food` VALUES (1001, '牛排', 50.00, '西餐拍档', 1, 'https://tva1.sinaimg.cn/large/006tNbRwly1gai397g2xyj30ou0m04qp.jpg');
INSERT INTO `food` VALUES (1002, '意面', 30.00, '西餐拍档', 1, 'https://tva1.sinaimg.cn/large/006tNbRwly1gaioiofxuaj30to0pce81.jpg');
INSERT INTO `food` VALUES (1003, '汉堡', 15.00, '西餐拍档', 1, 'https://tva1.sinaimg.cn/large/006tNbRwly1gaiokywu3nj30p40k41kx.jpg');
INSERT INTO `food` VALUES (1004, '水饺', 20.00, '特色中餐', 1, 'https://tva1.sinaimg.cn/large/006tNbRwly1gaiojs6yu6j30mc0h0wxq.jpg');
INSERT INTO `food` VALUES (1005, '水煮牛肉', 50.00, '特色川菜', 1, 'https://tva1.sinaimg.cn/large/006tNbRwly1gaiomkgodcj30va0om4qp.jpg');
INSERT INTO `food` VALUES (1006, '炸鸡', 20.00, '西餐拍档', 1, 'https://tva1.sinaimg.cn/large/006tNbRwly1gaiooi8cfmj30ug0mqkjl.jpg');
INSERT INTO `food` VALUES (1007, '雪碧', 5.00, '缤纷盛夏', 1, 'https://tva1.sinaimg.cn/large/006tNbRwly1gaioqbcu48j30hq0g8qc2.jpg');
COMMIT;

-- ----------------------------
-- Table structure for host
-- ----------------------------
DROP TABLE IF EXISTS `host`;
CREATE TABLE `host` (
  `account` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `restaurantID` int(11) DEFAULT NULL,
  PRIMARY KEY (`account`),
  KEY `fk_table_2` (`restaurantID`),
  CONSTRAINT `fk_table_2` FOREIGN KEY (`restaurantID`) REFERENCES `restaurant` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of host
-- ----------------------------
BEGIN;
INSERT INTO `host` VALUES ('Rick', '123456', 1);
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `price` decimal(10,2) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `style` char(10) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES (1, 100.00, '2020-01-01 00:00:00', '多点辣', '外带', '已处理');
INSERT INTO `order` VALUES (9, 150.00, '19:30', 'xxxxxx', '堂食', NULL);
INSERT INTO `order` VALUES (10, 150.00, '19:30', 'xxxxxx', '堂食', '已处理');
COMMIT;

-- ----------------------------
-- Table structure for orderTofood
-- ----------------------------
DROP TABLE IF EXISTS `orderTofood`;
CREATE TABLE `orderTofood` (
  `orderID` int(11) NOT NULL,
  `foodID` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `tasteID` int(11) NOT NULL,
  KEY `fk_orderTofood` (`orderID`),
  KEY `fk_orderTofood_1` (`foodID`),
  CONSTRAINT `fk_orderTofood` FOREIGN KEY (`orderID`) REFERENCES `order` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_orderTofood_1` FOREIGN KEY (`foodID`) REFERENCES `food` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orderTofood
-- ----------------------------
BEGIN;
INSERT INTO `orderTofood` VALUES (1, 1001, 2, 1);
INSERT INTO `orderTofood` VALUES (1, 1002, 1, 1);
INSERT INTO `orderTofood` VALUES (9, 1001, 2, 1);
INSERT INTO `orderTofood` VALUES (9, 1005, 1, 3);
INSERT INTO `orderTofood` VALUES (10, 1001, 2, 1);
INSERT INTO `orderTofood` VALUES (10, 1005, 1, 3);
COMMIT;

-- ----------------------------
-- Table structure for restaurant
-- ----------------------------
DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE `restaurant` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `longitude` decimal(30,0) DEFAULT NULL,
  `latitude` decimal(30,0) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `chainID` int(11) NOT NULL,
  `resType` varchar(255) NOT NULL,
  `sellinfo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_restaurant` (`chainID`),
  CONSTRAINT `fk_restaurant` FOREIGN KEY (`chainID`) REFERENCES `chain` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of restaurant
-- ----------------------------
BEGIN;
INSERT INTO `restaurant` VALUES (1, '钶氏连锁', 123, 123, '电子科技大学', '13228199285', 1, '1', 'www.baidu.com');
INSERT INTO `restaurant` VALUES (2, '轩氏连锁', NULL, NULL, '电子科技大学', '13228199285', 1, '1', NULL);
INSERT INTO `restaurant` VALUES (3, '范氏连锁', NULL, NULL, '电子科技大学', '13228199285', 1, '1', NULL);
INSERT INTO `restaurant` VALUES (4, '刘氏连锁', NULL, NULL, '电子科技大学', '13228199285', 1, '1', NULL);
INSERT INTO `restaurant` VALUES (5, '李氏连锁', NULL, NULL, '电子科技大学', '13228199285', 1, '1', NULL);
INSERT INTO `restaurant` VALUES (6, '钱氏连锁', NULL, NULL, '电子科技大学', '13228199285', 1, '1', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tastetype
-- ----------------------------
DROP TABLE IF EXISTS `tastetype`;
CREATE TABLE `tastetype` (
  `foodID` int(11) NOT NULL,
  `tasteID` int(11) NOT NULL,
  `tastename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`foodID`,`tasteID`),
  CONSTRAINT `fk_tastetype` FOREIGN KEY (`foodID`) REFERENCES `food` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tastetype
-- ----------------------------
BEGIN;
INSERT INTO `tastetype` VALUES (1001, 1, '九分熟');
INSERT INTO `tastetype` VALUES (1001, 2, '七分熟');
INSERT INTO `tastetype` VALUES (1001, 3, '五分熟');
INSERT INTO `tastetype` VALUES (1002, 1, '正常');
INSERT INTO `tastetype` VALUES (1002, 2, '加糖');
INSERT INTO `tastetype` VALUES (1003, 1, '加芝士');
INSERT INTO `tastetype` VALUES (1004, 1, '加醋');
INSERT INTO `tastetype` VALUES (1004, 2, '加辣椒');
INSERT INTO `tastetype` VALUES (1004, 3, '加辣加醋');
INSERT INTO `tastetype` VALUES (1005, 1, '微麻');
INSERT INTO `tastetype` VALUES (1005, 2, '中麻');
INSERT INTO `tastetype` VALUES (1005, 3, '特麻');
INSERT INTO `tastetype` VALUES (1006, 1, '正常');
INSERT INTO `tastetype` VALUES (1007, 1, '正常');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
