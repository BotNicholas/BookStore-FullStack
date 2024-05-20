CREATE DATABASE  IF NOT EXISTS `bookseller` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bookseller`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bookseller
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `initials` varchar(2) DEFAULT NULL,
  `birth_date` date NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `contact_details` varchar(100) DEFAULT NULL,
  `other_details` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT 'Placeholder.png',
  PRIMARY KEY (`id`),
  CONSTRAINT `authors_chk_1` CHECK (((`gender` = _utf8mb4'M') or (`gender` = _utf8mb4'F') or (`gender` = _utf8mb4'U')))
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'John1','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(2,'Janine','Smith','JS','1982-02-02','F','janine.smith@mail.com','Some details here','1654176069174.jpg'),(3,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(4,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(5,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(6,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(7,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(8,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(9,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(10,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(11,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(12,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(13,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(14,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(15,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(16,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(17,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(18,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(19,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(20,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(21,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(22,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(23,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(24,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(25,'John','Doe','JD','1970-01-01','M','john.doe@gmail.com','Some details here','Placeholder.png'),(26,'Jane','Smith','JS','1980-02-02','F','jane.smith@mail.com','Some details here','Placeholder.png'),(40,'Daa','Aaaa','DA','1999-06-08','U','','','Placeholder.png'),(41,'A','B','AB','1969-12-31','U','a.b@gmail.com','Some details here','Placeholder.png'),(92,'222','222','22','2002-02-21','M','222','222','image-placeholder-title.jpg');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-10 17:50:21
