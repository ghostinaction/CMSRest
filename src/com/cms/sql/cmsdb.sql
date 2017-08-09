/*
Navicat MySQL Data Transfer

Source Server         : aaa
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : cmsdb

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-04-01 15:08:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `carouseltbl`
-- ----------------------------
DROP TABLE IF EXISTS `carouseltbl`;
CREATE TABLE `carouseltbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(100) DEFAULT '',
  `hrefUrl` varchar(100) DEFAULT '',
  `desic` varchar(100) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carouseltbl
-- ----------------------------
INSERT INTO `carouseltbl` VALUES ('1', 'image/mbrDffi7ai.jpg', '11111', '222222');
INSERT INTO `carouseltbl` VALUES ('2', 'image/HCqx4roq2w.jpg', 'www.hao123.com', '跳到好123');
INSERT INTO `carouseltbl` VALUES ('3', 'image/OPKcZFvHuX.jpg', 'www.baidu.com', '11');
INSERT INTO `carouseltbl` VALUES ('4', 'image/Y4DgPFQSaR.jpg', '广东', '我是中国人');

-- ----------------------------
-- Table structure for `cpyinfo`
-- ----------------------------
DROP TABLE IF EXISTS `cpyinfo`;
CREATE TABLE `cpyinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司信息表Id',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `chuanzheng` varchar(50) DEFAULT NULL COMMENT '传真',
  `people` varchar(50) DEFAULT NULL COMMENT '联系人',
  `bus_email` varchar(50) DEFAULT NULL COMMENT '业务邮箱',
  `tech_email` varchar(50) DEFAULT NULL COMMENT '技术邮箱',
  `page` varchar(100) DEFAULT NULL COMMENT '主页',
  `business` varchar(200) DEFAULT NULL COMMENT '主营',
  `qqchat` varchar(20) DEFAULT NULL COMMENT '咨询QQ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cpyinfo
-- ----------------------------
INSERT INTO `cpyinfo` VALUES ('1', '213', '11111111', '1', '1', '1', '1', '1111', '111', '820743769');

-- ----------------------------
-- Table structure for `cpyinst`
-- ----------------------------
DROP TABLE IF EXISTS `cpyinst`;
CREATE TABLE `cpyinst` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司简介表ID',
  `inst_type` varchar(20) DEFAULT NULL COMMENT '简介类型',
  `content` longtext COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cpyinst
-- ----------------------------
INSERT INTO `cpyinst` VALUES ('1', '公司简介', '<img src=\"/CMSRest/image/6eBot76YLP.jpg\" alt=\"\" />');
INSERT INTO `cpyinst` VALUES ('2', '企业资质', '111');
INSERT INTO `cpyinst` VALUES ('3', '企业文化', '');
INSERT INTO `cpyinst` VALUES ('4', '客户资源', '');
INSERT INTO `cpyinst` VALUES ('5', '合作伙伴', '<img src=\"/CMSRest/image/demoUpload1-140Z212350AF.jpg\" alt=\"\" /><img src=\"/CMSRest/image/e5auznXtiy.jpg\" alt=\"\" />');
INSERT INTO `cpyinst` VALUES ('6', '公司简短介绍', '');

-- ----------------------------
-- Table structure for `kindtbl`
-- ----------------------------
DROP TABLE IF EXISTS `kindtbl`;
CREATE TABLE `kindtbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品分类ID',
  `kindName` varchar(80) DEFAULT NULL COMMENT '产品分类名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kindtbl
-- ----------------------------
INSERT INTO `kindtbl` VALUES ('6', '123');

-- ----------------------------
-- Table structure for `leavemessage`
-- ----------------------------
DROP TABLE IF EXISTS `leavemessage`;
CREATE TABLE `leavemessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) DEFAULT NULL COMMENT '称呼',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `bus_name` varchar(50) DEFAULT NULL COMMENT '企业名称',
  `bus_address` varchar(100) DEFAULT NULL COMMENT '公司地址',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `leaveTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leavemessage
-- ----------------------------

-- ----------------------------
-- Table structure for `producttbl`
-- ----------------------------
DROP TABLE IF EXISTS `producttbl`;
CREATE TABLE `producttbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `kindId` int(11) DEFAULT NULL COMMENT '产品分类ID',
  `productName` varchar(200) DEFAULT NULL COMMENT '产品名',
  `detailUrl` varchar(200) DEFAULT NULL COMMENT '详情主图',
  `mainUrl` varchar(200) DEFAULT NULL COMMENT '主图url',
  `productInfo` text COMMENT '产品信息',
  `productDetail` longtext COMMENT '产品详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of producttbl
-- ----------------------------
INSERT INTO `producttbl` VALUES ('25', '6', '111', 'image/GqvvSg1HIh.jpg', 'image/nrsQyBLb9y.jpg', '', '<img src=\"/CMSRest/image/l2mx22awV4.jpg\" alt=\"\" />');

-- ----------------------------
-- Table structure for `usertbl`
-- ----------------------------
DROP TABLE IF EXISTS `usertbl`;
CREATE TABLE `usertbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(80) DEFAULT NULL,
  `passWord` varchar(100) DEFAULT NULL,
  `canUse` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertbl
-- ----------------------------
INSERT INTO `usertbl` VALUES ('1', 'admin', '202CB962AC59075B964B07152D234B70', 'YES');
