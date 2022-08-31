-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_jik
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `co_num` int NOT NULL AUTO_INCREMENT,
  `co_me_id` varchar(20) NOT NULL,
  `co_bd_num` int NOT NULL,
  `co_content` longtext NOT NULL,
  `co_ori_num` int NOT NULL,
  `co_depth` int NOT NULL DEFAULT '1',
  `co_reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `co_order` int NOT NULL,
  PRIMARY KEY (`co_num`),
  KEY `co_me_id_idx` (`co_me_id`),
  KEY `co_bd_num_idx` (`co_bd_num`),
  CONSTRAINT `co_bd_num` FOREIGN KEY (`co_bd_num`) REFERENCES `board` (`bd_num`),
  CONSTRAINT `co_me_id` FOREIGN KEY (`co_me_id`) REFERENCES `member` (`me_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'qwe',15,'댓글',1,1,'2022-08-17 15:00:09',0),(2,'qwe',15,'댓글 테스트2',2,1,'2022-08-17 15:03:55',0),(3,'qwe',15,'123',3,1,'2022-08-17 16:23:06',0),(4,'qwe',15,'456',4,1,'2022-08-17 16:26:04',0),(5,'qwe',15,'댓글 등록',5,1,'2022-08-17 16:27:04',0),(6,'qwe',15,'1',6,1,'2022-08-17 16:55:10',0),(10,'qwe123',15,'123',7,1,'2022-08-18 10:45:04',0),(11,'qwe123',15,'댓글 수정햇습니다. - 12',11,1,'2022-08-18 10:58:33',0),(12,'qwe123',15,'123',12,1,'2022-08-18 11:47:31',0),(13,'asd',15,'123',13,1,'2022-08-18 15:08:51',0),(15,'qwe',29,'456',15,1,'2022-08-18 16:30:41',1),(16,'qwe',29,'123',16,1,'2022-08-18 17:07:12',1),(17,'qwe',29,'789',15,2,'2022-08-18 17:07:24',2),(18,'qwe',29,'789012',15,3,'2022-08-18 17:12:26',4),(19,'qwe',29,'12345',15,4,'2022-08-18 17:13:09',5),(20,'qwe',29,'123',15,3,'2022-08-18 17:13:33',3),(21,'qwe',29,'└123-답글-수정',16,2,'2022-08-19 09:48:47',2),(22,'qwe',39,'댓글 복습',22,1,'2022-08-22 17:13:36',1),(23,'qwe',39,'댓글복습2',23,1,'2022-08-22 17:16:56',1),(24,'qwe',39,'댓글등록',24,1,'2022-08-23 09:31:28',1),(25,'qwe',39,'댓글 등록',25,1,'2022-08-23 14:21:23',1),(26,'qwe',39,'1',26,1,'2022-08-23 15:30:17',1),(27,'qwe',39,'2',27,1,'2022-08-23 15:30:19',1),(28,'qwe',39,'3',28,1,'2022-08-23 15:30:21',1),(29,'qwe',39,'4',29,1,'2022-08-23 15:30:24',1),(30,'qwe',39,'5',30,1,'2022-08-23 15:30:26',1),(31,'qwe',39,'6-수정',31,1,'2022-08-23 15:30:28',1),(32,'qwe',39,'7-수정',32,1,'2022-08-23 15:30:30',1),(35,'asd',39,'123',35,1,'2022-08-23 16:37:30',1),(36,'qwe',41,'qwe1',36,1,'2022-08-30 09:24:39',1),(37,'qwe',44,'qwe',37,1,'2022-08-30 10:49:21',1),(42,'qwe',44,'qwe123',37,2,'2022-08-30 12:07:33',2),(43,'qwe',44,'qweqwe123',37,3,'2022-08-30 12:07:41',3);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-31  9:27:29
