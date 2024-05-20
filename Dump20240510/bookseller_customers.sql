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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idnp` varchar(13) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `customers_chk_1` CHECK ((`email` like _utf8mb4'%@%.com'))
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'1234567890123','Alice Brown','123 Main St','+37360000001','alice.brown@yahoo.com'),(2,'9876543210987','Boby Johnson','456 Elm St','+37360000002','boby.johnson@hotmail.com'),(3,'1234567890123','Andrew Smith','123 Main St','+37379355259','andrew24@gmail.com'),(6,'9876543230287','Freddy Fazber','Pizzeria','+37360000911','Freddy@hotmail.com'),(14,'0000000000000','manager Nick','unset','+37300000000','#unset#@gmail.com'),(33,'0000000000000','a','unset','+37300000000','#unset#@gmail.com'),(35,'0000000000000','AAAAAAA','unset','+37300000000','#unset#@gmail.com'),(36,'0000000000000','ФФФ','ФФФ','+37300000000','FFF@gmail.com'),(37,'0000000000000','bbb','unset','+37300000000','#unset#@gmail.com'),(38,'0000000000000','C','unset','+37300000000','#unset#@gmail.com'),(39,'0000000000000','D','unset','+37300000000','#unset#@gmail.com'),(42,'0000000000000','TEST','unset','+37300000000','#unset#@gmail.com'),(43,'0000000000000','BA','unset','+37300000000','#unset#@gmail.com'),(47,'0000000000000','S1','unset','+37300000000','#unset#@gmail.com'),(48,'0000000000000','tesat','unset','+37300000000','#unset#@gmail.com'),(49,'0000000000000','Admin_12345','unset','+37300000000','#unset#@gmail.com');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-10 17:50:20
