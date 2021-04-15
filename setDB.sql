CREATE DATABASE  IF NOT EXISTS `covid`;
USE `covid`;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `district`;

CREATE TABLE `district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `NAME_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
INSERT INTO `district` VALUES 
	(1,'Djibouti'),
	(2,'Ali-sabieh'),
	(3,'Dikhil'),
	(4,'Tadjourah'),
	(5,'Obock'),
	(6,'Arta');



DROP TABLE IF EXISTS `cas`;

CREATE TABLE `cas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `district_id` int(45)  NOT NULL,
  `healed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  
	KEY `FK_DISTRICT_idx` (`district_id`),
  
  CONSTRAINT `FK_DISTRICT` 
  FOREIGN KEY (`district_id`) 
  REFERENCES `district` (`id`) 
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

