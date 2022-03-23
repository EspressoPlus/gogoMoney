-- DROP TABLE checkout;

-- needed if this script does not complete successfully
UNLOCK TABLES;

CREATE DATABASE  IF NOT EXISTS `mp07_MovieLibrary` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mp07_MovieLibrary`;
-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: mp07_MovieLibrary
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `uname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Clayton'),(2,'Annabelle'),(3,'Gabe'),(4,'Chris');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `movie_id` int unsigned NOT NULL,
  `date_out` datetime DEFAULT NULL,
  `date_in` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_transaction_user_idx` (`user_id`),
  CONSTRAINT `fk_transaction_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  KEY `fk_transaction_movie_idx` (`movie_id`),
  CONSTRAINT `fk_transaction_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(90) DEFAULT NULL,
  `description` varchar(450) DEFAULT NULL,
  `run_time` int unsigned DEFAULT NULL,
  `year_made` int unsigned DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `rating` varchar(45) DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `copies_total` int unsigned DEFAULT NULL,
  `copies_available` int unsigned DEFAULT NULL,
  /*`transaction_id` int unsigned NOT NULL,*/
  PRIMARY KEY (`id`) /*,
  KEY `fk_movie_transaction_idx` (`transaction_id`),
  CONSTRAINT `fk_movie_transaction` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`) */
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES 
    (1,'Fletch', 'Irwin M. "Fletch" Fletcher is a newspaper reporter being offered a large sum to off a cancerous millionaire, but is on the run, risking his job and finding clues when it''s clear the man is healthy.',98,1985,'1985-05-31','PG','Comedy, Crime, Mystery',3,3),
    (2,'Spider-Man: Into the Spider-Verse','Teen Miles Morales becomes the Spider-Man of his universe, and must join with five spider-powered individuals from other dimensions to stop a threat for all realities.',117,2018,'2018-12-14','PG','Animation, Action, Adventure, Comedy, Family, Fantasy, Sci-Fi',5,4),
    (3,'Avengers: Infinity War','The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.',149,2018,'2018-04-27','PG-13','Action, Adventure, Sci-Fi',2,2),
    (4,'Beasts of the Southern Wild','Faced with both her hot-tempered father''s fading health and melting ice-caps that flood her ramshackle bayou community and unleash ancient aurochs, six-year-old Hushpuppy must learn the ways of courage and love.',93,2012,'2012-07-05','PG-13','Adventure, Drama, Fantasy',6,6),
    (5,'Once','A modern-day musical about a busker and an immigrant and their eventful week in Dublin, as they write, rehearse and record songs that tell their love story.',86,2007,'2007-06-15','R','Drama, Music, Romance',1,1),
    (6,'Love Actually','Follows the lives of eight very different couples in dealing with their love lives in various loosely interrelated tales all set during a frantic month before Christmas in London, England',135,2003,'2003-11-09','R','Comedy, Drama, Romance',2,2)
;

/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
-- INSERT INTO `transaction` VALUES (1,1,1),(2,3,1),(3,2,2);
INSERT INTO `transaction` VALUES 
    (1,1,1,'2020-01-01','2020-01-02'),
    (2,3,1,'2018-01-01','2018-03-02'),
    (3,2,2,'2020-01-01','2020-01-02'),
    (4,1,2,'2021-12-04',null),
    (5,1,3,'2021-09-03','2021-10-02')
;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-12 19:23:09
