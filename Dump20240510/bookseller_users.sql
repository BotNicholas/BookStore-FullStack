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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `roles` varchar(100) NOT NULL,
  `customer_id` int DEFAULT NULL,
  `image` varchar(100) DEFAULT 'Placeholder.png',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (6,'admin','$2a$10$J/Ie3NLeEx06GsWSUT/44eW9z0Op8.McNBOIXbS64NoAhWZFBhNR2','ROLE_ADMIN',1,'admin.jpg'),(9,'manager','$2a$10$HsTZ5kONZrkxtIdZ2oNeCei4k/kKTTb2nghYtPpoplZZeUso4B8hO','ROLE_MANAGER',14,'Max-R_Headshot.jpg'),(18,'a','$2a$10$aiupfEqkX3j71x3ZH1hUzOrK1jhmeWlbrX9rDStiH9y3lyTpL6zIC','ROLE_USER',33,'1656254145919.jpg'),(24,'AAAAAAA','$2a$10$TJ9vBl/0stNCa73G8/SlB.Z6GGHOnU.6ZkfyktZCMbpkkqP1SLZaK','ROLE_ADMIN',35,'angular-icon-logo-5FC0C40EAC-seeklogo.com.png'),(31,'S1','$2a$10$v3.2/ESYFd3P7KJUHPIKnO7Uqauprv9eLBMk1GyNZ6GBxkEWvEOSW','ROLE_USER',47,'angular-icon-logo-5FC0C40EAC-seeklogo.com.png'),(32,'tesat','$2a$10$J/Ie3NLeEx06GsWSUT/44eW9z0Op8.McNBOIXbS64NoAhWZFBhNR2','ROLE_USER',48,'Placeholder.png'),(33,'Admin_12345','$2a$10$z6Te1mfg4Hz58y7McOmfWO9zik.2x3GxkXhM0rMYd8qj81z3/.IzS','ROLE_ADMIN',49,'Placeholder.png');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
