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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `author_id` int DEFAULT NULL,
  `book_category_code` int DEFAULT NULL,
  `isbn` varchar(17) DEFAULT NULL,
  `publication_date` date NOT NULL,
  `date_aquired` date NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `recommended_price` double DEFAULT NULL,
  `comments` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT 'Placeholder.png',
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`),
  KEY `book_category_code` (`book_category_code`),
  CONSTRAINT `books_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`) ON DELETE CASCADE,
  CONSTRAINT `books_ibfk_2` FOREIGN KEY (`book_category_code`) REFERENCES `book_categories` (`code`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,1,1,'978-3-16-148410-0','2020-01-01','2021-01-01','The Great Adventure',19.99,'Bestseller','91AVoBT6p6L._AC_UF894,1000_QL80_.jpg'),(2,2,2,'978-1-23-456789-7','2019-01-01','2021-01-02','Science for Beginners',29.99,'Excellent for students','56440137.jpg'),(3,2,1,'123-4-56-789098-7','2019-09-10','2019-09-10','Java for Beginners',999.99,'Excellent for true javers','9789325968509.jpg'),(4,1,1,'978-3-16-148410-0','2020-01-01','2021-01-01','The Great Adventure',19.99,'Bestseller','Placeholder.png'),(5,2,2,'978-1-23-456789-7','2019-01-01','2021-01-02','Science for Beginners',29.99,'Excellent for students','Placeholder.png'),(6,2,1,'123-4-56-789098-7','2019-09-10','2019-09-10','Java for Beginners',999.99,'Excellent for true javers','Placeholder.png'),(12,1,1,'000-0-00-000000-0','2024-04-03','2024-04-03','A',1,'','Placeholder.png'),(43,92,1,'222-2-22-222222-2','2024-05-10','2024-05-10','222',222,'','kubik-rubika-plavlenie-cveta-31b747d.jpg'),(44,92,2,'222-2-22-222222-2','2024-05-10','2024-05-10','2222',2222,'','angular-icon-logo-5FC0C40EAC-seeklogo.com.png');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
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
