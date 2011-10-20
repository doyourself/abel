-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	6.0.0-alpha-community-nt-debug


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema abel
--

CREATE DATABASE IF NOT EXISTS abel;
USE abel;

--
-- Definition of table `blog`
--

DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `isAllowedComment` int(11) DEFAULT NULL,
  `isReprinted` int(11) DEFAULT NULL,
  `clickCount` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `categoryId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_14` (`uid`),
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客';

--
-- Dumping data for table `blog`
--

/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` (`id`,`title`,`content`,`isAllowedComment`,`isReprinted`,`clickCount`,`createTime`,`uid`,`categoryId`) VALUES 
 (1,'test','<p>\r\n	<strong>test</strong></p>\r\n',1,1,NULL,'2011-10-15 14:00:32',6,13),
 (2,'tesefasdf','<p>\r\n	awefqewf</p>\r\n',0,1,NULL,'2011-10-15 14:44:31',6,13),
 (3,'dddd','<p>\r\n	ddd</p>\r\n',0,1,NULL,'2011-10-15 14:53:44',6,14),
 (4,'dddd','<p>\r\n	ddd</p>\r\n',0,1,NULL,'2011-10-15 14:53:44',6,14),
 (5,'dddd','<p>\r\n	ddd</p>\r\n',0,1,NULL,'2011-10-15 14:53:44',6,14),
 (6,'dddd','<p>\r\n	ddd</p>\r\n',0,1,NULL,'2011-10-15 14:53:44',6,14),
 (7,'dddd','<p>\r\n	ddd</p>\r\n',0,1,NULL,'2011-10-15 14:53:44',6,14),
 (8,'dddd','<p>\r\n	ddd</p>\r\n',0,1,NULL,'2011-10-15 14:53:44',6,14),
 (9,'dddd','<p>\r\n	ddd</p>\r\n',0,1,NULL,'2011-10-15 14:53:44',6,14),
 (10,'dddd','<p>\r\n	ddd</p>\r\n',0,1,NULL,'2011-10-15 14:53:44',6,14),
 (11,'dddd','<p>\r\n	ddd</p>\r\n',0,1,NULL,'2011-10-15 14:53:44',6,14),
 (12,'dddd','<p>\r\n	ddd</p>\r\n',0,1,NULL,'2011-10-15 14:53:44',6,14),
 (13,'dddd','<p>\r\n	ddd</p>\r\n',0,1,NULL,'2011-10-15 14:53:44',6,14),
 (14,'uuu','<p>\r\n	uuu</p>\r\n',0,1,NULL,'2011-10-15 15:29:53',6,8),
 (15,'asdfasdfas','<p>\r\n	fwqefawefasdf</p>\r\n',0,1,NULL,'2011-10-15 22:39:05',6,14),
 (16,'dsrfgdsfgv','<p>\r\n	aergvwers</p>\r\n',0,1,NULL,'2011-10-16 08:01:00',6,13),
 (17,'asdfasdf','<p>\r\n	sadfsadfsaf</p>\r\n',0,1,NULL,'2011-10-17 21:00:49',6,13),
 (18,'asdfsadf','<p>\r\n	asdfsadf</p>\r\n',1,1,NULL,'2011-10-18 20:09:18',6,15),
 (19,'aewfsaf','<p>\r\n	awefawef</p>\r\n',1,1,NULL,'2011-10-18 22:33:24',6,5),
 (20,'asdfasdfa','<p>\r\n	asdfasdf</p>\r\n',1,1,NULL,'2011-10-19 20:17:13',6,15),
 (21,'asdfsadf','<p>\r\n	asdf</p>\r\n',1,1,NULL,'2011-10-19 20:17:13',6,15),
 (22,'sdfsadf','<p>\r\n	sadfasf</p>\r\n',1,1,NULL,'2011-10-19 22:42:59',6,7);
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;


--
-- Definition of table `blogreprint`
--

DROP TABLE IF EXISTS `blogreprint`;
CREATE TABLE `blogreprint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bolgId` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `oldUname` int(11) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_16` (`uid`),
  KEY `FK_Relationship_17` (`bolgId`),
  CONSTRAINT `FK_Relationship_16` FOREIGN KEY (`uid`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_Relationship_17` FOREIGN KEY (`bolgId`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博文转载表';

--
-- Dumping data for table `blogreprint`
--

/*!40000 ALTER TABLE `blogreprint` DISABLE KEYS */;
/*!40000 ALTER TABLE `blogreprint` ENABLE KEYS */;


--
-- Definition of table `bug`
--

DROP TABLE IF EXISTS `bug`;
CREATE TABLE `bug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` int(11) NOT NULL,
  `description` text,
  `createDate` date NOT NULL,
  `type` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bug`
--

/*!40000 ALTER TABLE `bug` DISABLE KEYS */;
/*!40000 ALTER TABLE `bug` ENABLE KEYS */;


--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '1、博客2、日志、3、BUG',
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_15` (`uid`),
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客分类';

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`,`name`,`createTime`,`uid`,`type`) VALUES 
 (1,'asdfasdfas','2011-10-15 13:08:32',6,1),
 (2,'asdfasdfas','2011-10-15 13:08:32',6,1),
 (3,'asdfasdfasdfw','2011-10-15 13:08:32',6,1),
 (4,'asdfasdferf3q','2011-10-15 13:08:32',6,1),
 (5,'awegfwevf','2011-10-15 13:08:32',6,1),
 (6,'awegfwevf333','2011-10-15 13:08:32',6,1),
 (7,'test','2011-10-15 13:08:32',6,1),
 (8,'xx','2011-10-15 13:37:28',6,1),
 (9,'ooo','2011-10-15 13:37:28',6,1),
 (10,'uuuu','2011-10-15 13:37:28',6,1),
 (11,'nnnnn','2011-10-15 13:37:28',6,1),
 (12,'mmm','2011-10-15 13:37:28',6,1),
 (13,'kkk','2011-10-15 13:37:28',6,1),
 (14,'asdfas','2011-10-15 13:37:28',6,1),
 (15,'gggg','2011-10-15 13:37:28',6,1),
 (16,'sadfsadf','2011-10-17 21:00:37',6,1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `description` text,
  `createTime` datetime DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL COMMENT '1、博文2、日志、3、bug',
  `sortId` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `support` int(11) NOT NULL DEFAULT '0' COMMENT '支持',
  `opposition` int(11) NOT NULL DEFAULT '0' COMMENT '反对',
  `report` int(11) NOT NULL DEFAULT '0' COMMENT '举报',
  `parentId` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_用户评论表` (`uid`),
  CONSTRAINT `FK_用户评论表` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `comment`
--

/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`id`,`uid`,`description`,`createTime`,`status`,`type`,`sortId`,`level`,`support`,`opposition`,`report`,`parentId`) VALUES 
 (300,6,'t32fasf','2011-10-17 22:14:59',0,1,16,0,0,0,0,290),
 (301,6,'2323','2011-10-17 22:15:03',0,1,300,1,0,0,0,NULL),
 (302,6,'asdfasdf','2011-10-17 22:15:09',0,1,301,2,0,0,0,NULL),
 (303,6,'asdfasdf','2011-10-17 22:15:16',0,1,300,1,0,0,0,300),
 (304,6,'asdfsadf','2011-10-17 22:16:12',0,1,16,0,0,0,0,300),
 (305,6,'2323','2011-10-17 22:16:17',0,1,304,1,0,0,0,304),
 (306,6,'wewe','2011-10-17 22:16:20',0,1,305,2,0,0,0,304),
 (307,6,'2323','2011-10-17 22:16:25',0,1,306,2,0,0,0,304),
 (308,6,'asdfsad','2011-10-17 22:16:28',0,1,305,2,0,0,0,304),
 (309,6,'qe4gfq4f','2011-10-18 20:09:22',0,1,18,0,0,0,0,NULL),
 (310,6,'2323','2011-10-18 20:09:26',0,1,309,1,0,0,0,309),
 (311,6,'asdfasdfasf','2011-10-18 20:09:31',0,1,310,2,0,0,0,309),
 (312,6,'2323','2011-10-18 20:09:39',0,1,311,2,0,0,0,309),
 (313,6,'asdfsadf','2011-10-18 22:01:40',0,1,310,2,0,0,0,309),
 (314,6,'asdfsadf','2011-10-18 22:01:50',0,1,311,2,0,0,0,309),
 (315,6,'22','2011-10-18 22:01:58',0,1,314,2,0,0,0,309),
 (316,6,'asdfasdf888','2011-10-18 22:02:12',0,1,314,2,0,0,0,309),
 (317,6,'6666','2011-10-18 22:02:18',0,1,315,2,0,0,0,309),
 (318,6,'sadfsad','2011-10-18 22:33:30',0,1,19,0,3,3,1,NULL),
 (319,6,'qewf','2011-10-18 22:33:39',0,1,318,1,0,0,0,318),
 (320,6,'asdfasdf','2011-10-19 20:17:19',0,1,20,0,2,1,0,NULL),
 (321,6,'asdfqwef','2011-10-19 20:17:30',0,1,320,1,0,0,0,320),
 (322,6,'awefwaf','2011-10-19 20:24:11',0,1,21,0,8,4,1,320),
 (323,6,'asdfasf','2011-10-19 20:35:24',0,1,322,1,2,2,1,322),
 (324,6,'sadfasf','2011-10-19 20:35:52',0,1,323,2,0,1,0,322),
 (325,6,'asfqwef','2011-10-19 20:38:15',0,1,323,2,1,1,0,322),
 (326,6,'232saf','2011-10-19 20:38:20',0,1,324,2,2,1,1,322),
 (327,6,'阿德法撒旦法','2011-10-19 20:48:23',0,1,21,0,0,0,0,322),
 (328,6,'asdfasdf','2011-10-19 20:49:25',0,1,327,1,0,0,0,327),
 (329,6,'asdfsadf','2011-10-19 20:51:24',0,1,21,0,0,0,0,327),
 (330,6,'asdfsadf','2011-10-19 21:15:11',0,1,21,0,0,0,0,327),
 (331,6,'asfqwef','2011-10-19 21:15:18',0,1,330,1,0,0,0,330);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


--
-- Definition of table `friends`
--

DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `friendID` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `createdTime` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_userFriends` (`uid`),
  CONSTRAINT `FK_userFriends` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `friends`
--

/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;


--
-- Definition of table `group_reply`
--

DROP TABLE IF EXISTS `group_reply`;
CREATE TABLE `group_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `gro_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_12` (`gro_id`),
  KEY `FK_replyUsers` (`uid`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`gro_id`) REFERENCES `group_topic` (`id`),
  CONSTRAINT `FK_replyUsers` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `group_reply`
--

/*!40000 ALTER TABLE `group_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_reply` ENABLE KEYS */;


--
-- Definition of table `group_topic`
--

DROP TABLE IF EXISTS `group_topic`;
CREATE TABLE `group_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `gro_id` int(11) NOT NULL,
  `title` varchar(300) NOT NULL,
  `content` text NOT NULL,
  `create_time` date NOT NULL,
  `is_top` int(11) DEFAULT '0',
  `is_allowed_reply` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_topicGroup` (`gro_id`),
  KEY `FK_topicUsers` (`uid`),
  CONSTRAINT `FK_topicGroup` FOREIGN KEY (`gro_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FK_topicUsers` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `group_topic`
--

/*!40000 ALTER TABLE `group_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_topic` ENABLE KEYS */;


--
-- Definition of table `group_user`
--

DROP TABLE IF EXISTS `group_user`;
CREATE TABLE `group_user` (
  `id` int(11) NOT NULL,
  `create_time` date NOT NULL,
  `role` int(11) DEFAULT '1' COMMENT '1�Ǵ�����2�ǹ���Ա3����ͨ��Ա',
  `userId` int(11) NOT NULL,
  `groupid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_userGroups` (`userId`),
  CONSTRAINT `FK_groupUser` FOREIGN KEY (`id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FK_userGroups` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `group_user`
--

/*!40000 ALTER TABLE `group_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_user` ENABLE KEYS */;


--
-- Definition of table `groups`
--

DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `avatar` varchar(100) NOT NULL,
  `description` varchar(50) NOT NULL,
  `add_permission` int(11) NOT NULL,
  `publish_permission` int(11) NOT NULL,
  `create_time` date NOT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groups`
--

/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;


--
-- Definition of table `newmessage`
--

DROP TABLE IF EXISTS `newmessage`;
CREATE TABLE `newmessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `new_id` int(11) NOT NULL,
  `newStatus` int(11) NOT NULL,
  `message` varchar(500) NOT NULL,
  `createTime` date NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_newsMessage` (`new_id`),
  CONSTRAINT `FK_newsMessage` FOREIGN KEY (`new_id`) REFERENCES `newstatus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `newmessage`
--

/*!40000 ALTER TABLE `newmessage` DISABLE KEYS */;
/*!40000 ALTER TABLE `newmessage` ENABLE KEYS */;


--
-- Definition of table `news`
--

DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `bugid` int(11) NOT NULL,
  `viewCount` int(11) NOT NULL,
  `priority` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_bugNews` FOREIGN KEY (`id`) REFERENCES `bug` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `news`
--

/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


--
-- Definition of table `newstatus`
--

DROP TABLE IF EXISTS `newstatus`;
CREATE TABLE `newstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `isRead` int(11) NOT NULL,
  `nmID` int(11) NOT NULL,
  `status` int(11) DEFAULT '0',
  `createTime` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usersNewsLoad` (`uid`),
  CONSTRAINT `FK_usersNewsLoad` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `newstatus`
--

/*!40000 ALTER TABLE `newstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `newstatus` ENABLE KEYS */;


--
-- Definition of table `notepad`
--

DROP TABLE IF EXISTS `notepad`;
CREATE TABLE `notepad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `title` varchar(300) NOT NULL,
  `description` text NOT NULL,
  `createTime` date NOT NULL,
  `comment` int(11) DEFAULT '0',
  `reproduced` int(11) DEFAULT '0',
  `orderType` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_notepadUsers` (`uid`),
  CONSTRAINT `FK_notepadUsers` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `notepad`
--

/*!40000 ALTER TABLE `notepad` DISABLE KEYS */;
/*!40000 ALTER TABLE `notepad` ENABLE KEYS */;


--
-- Definition of table `points`
--

DROP TABLE IF EXISTS `points`;
CREATE TABLE `points` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `createTime` date NOT NULL,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pointUsers` (`uid`),
  CONSTRAINT `FK_pointUsers` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `points`
--

/*!40000 ALTER TABLE `points` DISABLE KEYS */;
/*!40000 ALTER TABLE `points` ENABLE KEYS */;


--
-- Definition of table `priority`
--

DROP TABLE IF EXISTS `priority`;
CREATE TABLE `priority` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_porintsUsers` (`uid`),
  CONSTRAINT `FK_porintsUsers` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `priority`
--

/*!40000 ALTER TABLE `priority` DISABLE KEYS */;
/*!40000 ALTER TABLE `priority` ENABLE KEYS */;


--
-- Definition of table `publiccomment`
--

DROP TABLE IF EXISTS `publiccomment`;
CREATE TABLE `publiccomment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `description` text NOT NULL,
  `createTime` date NOT NULL,
  `status` int(11) DEFAULT '0',
  `type` int(11) DEFAULT '0',
  `resourcesID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_userComment` (`uid`),
  CONSTRAINT `FK_userComment` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `publiccomment`
--

/*!40000 ALTER TABLE `publiccomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `publiccomment` ENABLE KEYS */;


--
-- Definition of table `rulepoints`
--

DROP TABLE IF EXISTS `rulepoints`;
CREATE TABLE `rulepoints` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `createTime` date NOT NULL,
  `points` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rulepoints`
--

/*!40000 ALTER TABLE `rulepoints` DISABLE KEYS */;
/*!40000 ALTER TABLE `rulepoints` ENABLE KEYS */;


--
-- Definition of table `tag`
--

DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `resourcesId` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  `createTime` date NOT NULL,
  `type` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_userTags` (`uid`),
  CONSTRAINT `FK_userTags` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tag`
--

/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` (`id`,`uid`,`resourcesId`,`description`,`createTime`,`type`) VALUES 
 (1,6,3,'ddd','2011-10-15',1),
 (2,6,3,'asdasd','2011-10-15',1),
 (3,6,3,'grefg','2011-10-15',1),
 (4,6,4,'ddd','2011-10-15',1),
 (5,6,4,'asdasd','2011-10-15',1),
 (6,6,4,'grefg','2011-10-15',1),
 (7,6,5,'ddd','2011-10-15',1),
 (8,6,5,'asdasd','2011-10-15',1),
 (9,6,5,'grefg','2011-10-15',1),
 (10,6,6,'ddd','2011-10-15',1),
 (11,6,6,'asdasd','2011-10-15',1),
 (12,6,6,'grefg','2011-10-15',1),
 (13,6,7,'ddd','2011-10-15',1),
 (14,6,7,'asdasd','2011-10-15',1),
 (15,6,7,'grefg','2011-10-15',1),
 (16,6,8,'ddd','2011-10-15',1),
 (17,6,8,'asdasd','2011-10-15',1),
 (18,6,8,'grefg','2011-10-15',1),
 (19,6,9,'ddd','2011-10-15',1),
 (20,6,9,'asdasd','2011-10-15',1),
 (21,6,9,'grefg','2011-10-15',1),
 (22,6,10,'ddd','2011-10-15',1),
 (23,6,10,'asdasd','2011-10-15',1),
 (24,6,10,'grefg','2011-10-15',1),
 (25,6,11,'ddd','2011-10-15',1),
 (26,6,11,'asdasd','2011-10-15',1),
 (27,6,11,'grefg','2011-10-15',1),
 (28,6,12,'ddd','2011-10-15',1),
 (29,6,12,'asdasd','2011-10-15',1),
 (30,6,12,'grefg','2011-10-15',1),
 (31,6,13,'ddd','2011-10-15',1),
 (32,6,13,'asdasd','2011-10-15',1),
 (33,6,13,'grefg','2011-10-15',1),
 (34,6,14,'uuu','2011-10-15',1),
 (35,6,15,'asdf','2011-10-15',1),
 (36,6,15,'thgbdf','2011-10-15',1),
 (37,6,15,'ertg34','2011-10-15',1),
 (38,6,16,'fq3ef','2011-10-16',1),
 (39,6,16,'ytnjtey','2011-10-16',1),
 (40,6,17,'afdeasd','2011-10-17',1),
 (41,6,17,'4tt4g','2011-10-17',1),
 (42,6,18,'asdf','2011-10-18',1),
 (43,6,18,'qwerfsd','2011-10-18',1),
 (44,6,18,'2fsdf','2011-10-18',1),
 (45,6,19,'asdfasdf','2011-10-18',1),
 (46,6,19,'tbrwtfbgv','2011-10-18',1),
 (47,6,20,'asdf','2011-10-19',1),
 (48,6,20,'34fsdf','2011-10-19',1),
 (49,6,21,'asdf','2011-10-19',1),
 (50,6,21,'egarg','2011-10-19',1),
 (51,6,22,'asdf','2011-10-19',1),
 (52,6,22,'asdf','2011-10-19',1);
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_login` datetime NOT NULL,
  `home_style` int(11) DEFAULT '0',
  `home_name` varchar(30) DEFAULT NULL,
  `domain` varchar(20) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `mobile_check` varchar(11) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `email_check` varchar(11) DEFAULT NULL,
  `card` char(18) DEFAULT NULL,
  `avatar` varchar(100) DEFAULT NULL,
  `priority` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `type` int(11) DEFAULT '1',
  `sex` char(1) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `work` varchar(60) DEFAULT NULL,
  `qq` varchar(45) DEFAULT NULL,
  `points` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`name`,`nick_name`,`password`,`create_time`,`last_login`,`home_style`,`home_name`,`domain`,`mobile`,`mobile_check`,`phone`,`email`,`email_check`,`card`,`avatar`,`priority`,`status`,`type`,`sex`,`address`,`work`,`qq`,`points`) VALUES 
 (6,'abel',NULL,'3dc5f2a5448ea681ad7ec5a59ca11f2e','2011-10-14 21:46:08','2011-10-14 21:46:08',NULL,NULL,NULL,NULL,NULL,NULL,'xiangxiang1323@126.com',NULL,NULL,'622C657221E24DE3A7DDD9FDD65C862C.jpg',NULL,0,1,'1','address','work','380252551',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
