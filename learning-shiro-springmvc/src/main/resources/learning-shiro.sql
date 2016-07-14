/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.27-log : Database - learning-shiro
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = '' */;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */`learning-shiro` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `learning-shiro`;

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `id`             BIGINT(20) NOT NULL,
  `permissionname` VARCHAR(255) DEFAULT NULL,
  `role_id`        BIGINT(20)   DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `t_permission` */

INSERT INTO `t_permission` (`id`, `permissionname`, `role_id`)
VALUES (1, 'add', 2), (2, 'del', 1), (3, 'update', 2), (4, 'query', 3);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id`       BIGINT(20) NOT NULL,
  `rolename` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `t_role` */

INSERT INTO `t_role` (`id`, `rolename`) VALUES (1, 'admin'), (2, 'manager'), (3, 'normal');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id`       BIGINT(20) NOT NULL,
  `username` VARCHAR(255) DEFAULT NULL,
  `password` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `t_user` */

INSERT INTO `t_user` (`id`, `username`, `password`)
VALUES (1, 'tom', '000000'), (2, 'jack', '000000'), (3, 'rose', '000000');

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `user_id` BIGINT(20) DEFAULT NULL,
  `role_id` BIGINT(20) DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `t_user_role` */

INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES (1, 1), (1, 3), (2, 2), (2, 3), (3, 3);

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
