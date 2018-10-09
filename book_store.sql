-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: book_store
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bs_author`
--
create database if not exists book_store;

use book_store;
DROP TABLE IF EXISTS `bs_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bs_author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `dob` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bs_author`
--

LOCK TABLES `bs_author` WRITE;
/*!40000 ALTER TABLE `bs_author` DISABLE KEYS */;
INSERT INTO `bs_author` VALUES (1,'Fujiko Fujio','1962-12-21 00:00:00'),(2,'?oàn Qu?nh','1952-12-21 00:00:00'),(3,'V?n Nh? C??ng','1932-12-21 00:00:00'),(4,'Nam Cao','1922-12-21 00:00:00'),(5,'Nguy?n Nh?t Ánh','1972-12-21 00:00:00');
/*!40000 ALTER TABLE `bs_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bs_author_book`
--

DROP TABLE IF EXISTS `bs_author_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bs_author_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `revenue_share` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bs_author_book`
--

LOCK TABLES `bs_author_book` WRITE;
/*!40000 ALTER TABLE `bs_author_book` DISABLE KEYS */;
INSERT INTO `bs_author_book` VALUES (1,1,1,1.00),(2,2,2,0.30),(3,3,2,0.70),(4,4,3,1.00),(5,5,4,1.00),(6,4,5,1.00);
/*!40000 ALTER TABLE `bs_author_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bs_book`
--

DROP TABLE IF EXISTS `bs_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bs_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  `sold_number` int(11) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bs_book`
--

LOCK TABLES `bs_book` WRITE;
/*!40000 ALTER TABLE `bs_book` DISABLE KEYS */;
INSERT INTO `bs_book` VALUES (1,'Doremon',1,10,30.00),(2,'Hinh hoc 11',2,100,15.00),(3,'Chi pheo',3,2,100.00),(4,'Kính v?n hoa',3,5,50.00),(5,'Lao hac',3,1,100.00);
/*!40000 ALTER TABLE `bs_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bs_category`
--

DROP TABLE IF EXISTS `bs_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bs_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bs_category`
--

LOCK TABLES `bs_category` WRITE;
/*!40000 ALTER TABLE `bs_category` DISABLE KEYS */;
INSERT INTO `bs_category` VALUES (1,'truyen hai huoc'),(2,'sach giao khoa'),(3,'tieu thuyet');
/*!40000 ALTER TABLE `bs_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-24  9:20:57
