/*
Navicat MySQL Data Transfer

Source Server         : root_conect
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : layui

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2021-01-21 09:59:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(255) DEFAULT NULL,
  `product_count` bigint(20) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `ispay` int(255) DEFAULT '0',
  `isdel` int(255) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '100', '2020-10-02', '2021-01-24', '山水集团', '15678999878', '1', '0');
INSERT INTO `order` VALUES ('2', '2', '100', '2020-11-21', '2021-03-20', 'Mr.Hang', '13456676567', '1', '1');
INSERT INTO `order` VALUES ('4', '1', '100', '2021-01-06', '2021-01-29', 'Mr.Hang', '15680098165', '1', '0');
INSERT INTO `order` VALUES ('5', '1', '100', '2021-01-05', '2021-01-21', 'Mr.Hang', '15680098165', '0', '0');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `count` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('10', 'asd', '4444', '1', '/var/uploaded_files/f16f81ca-dee7-4a5c-abe6-2e861c4b953b.PNG');

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('1', '金属');
INSERT INTO `product_type` VALUES ('2', '木材');
INSERT INTO `product_type` VALUES ('3', ' 水泥');
INSERT INTO `product_type` VALUES ('4', '邓');

-- ----------------------------
-- Table structure for tip
-- ----------------------------
DROP TABLE IF EXISTS `tip`;
CREATE TABLE `tip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `text` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tip
-- ----------------------------
INSERT INTO `tip` VALUES ('1', '你好', '2021-01-16 00:00:00', '你好你好你好你好');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'admin', '123456', '12320020136');
INSERT INTO `user` VALUES ('3', 'deng', '123456', '15899900909');
INSERT INTO `user` VALUES ('9', 'asd', 'asd', '15680098165');
INSERT INTO `user` VALUES ('10', 'admin', '123456', '15680098165');
INSERT INTO `user` VALUES ('11', 'admin', '123456', '15680098165');
