/*
Navicat MySQL Data Transfer

Source Server         : poe
Source Server Version : 50153
Source Host           : localhost:3307
Source Database       : contacts

Target Server Type    : MYSQL
Target Server Version : 50153
File Encoding         : 65001

Date: 2022-10-17 23:22:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `contact`
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birthdate` date NOT NULL,
  `company` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `notes` varchar(2000) DEFAULT NULL,
  `phone` varchar(50) NOT NULL,
  `position` varchar(100) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKocgv3kwr75e9klbx0u0jpq3ou` (`id_user`),
  CONSTRAINT `FKocgv3kwr75e9klbx0u0jpq3ou` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('1', '1985-07-03', 'Google', 'rosa.doe@gmail.com', 'Rosa', 'Doe', 'à rappeler la semaine prochaine', '0785422632', 'Ingénieure logiciel', '5');
INSERT INTO `contact` VALUES ('2', '1969-01-20', 'Facebook', 'jack.davis@hotmail.fr', 'Jack', 'Davis', '', '0632569849', 'Business Analyst', '5');
INSERT INTO `contact` VALUES ('3', '1995-10-16', 'Business Geografic', 'richard.clement@hotmail.fr', 'Clément', 'Richard', 'Rdv familial lundi prochain', '0745856596', 'Data Analyst', '6');

-- ----------------------------
-- Table structure for `relationship`
-- ----------------------------
DROP TABLE IF EXISTS `relationship`;
CREATE TABLE `relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `relationship` varchar(50) NOT NULL,
  `id_contact` bigint(20) NOT NULL,
  `id_relationship` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbvh6p13gypuh7g6ijmyscma03` (`id_contact`),
  KEY `FKi2g2lwpcx5wu0o0u21v1xrcki` (`id_relationship`),
  CONSTRAINT `FKi2g2lwpcx5wu0o0u21v1xrcki` FOREIGN KEY (`id_relationship`) REFERENCES `contact` (`id`),
  CONSTRAINT `FKbvh6p13gypuh7g6ijmyscma03` FOREIGN KEY (`id_contact`) REFERENCES `contact` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of relationship
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `photo` varchar(2000) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', 'Doe', 'John', 'john.doe@gmail.com', null, '$2a$10$gCHWqS8UhSZH4frUHyAmeOvuHDGJcvXfin3liJSMk4kflleoclhNK');
INSERT INTO `user` VALUES ('6', 'Richard', 'Monica', 'mrichard@gmail.com', null, '$2a$10$7zyQRxfj4wc/MKfKI6tEcemAXVu08mSrn4jHHDB//xvBBS2RK5Ae.');
