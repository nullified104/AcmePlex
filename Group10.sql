-- MySQL dump 10.13  Distrib 9.0.1, for macos15.1 (arm64)
--
-- Host: localhost    Database: acmeplex_db
-- ------------------------------------------------------
-- Server version	9.0.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `duration` int DEFAULT NULL,
  `id` int NOT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (180,1,'Sci-Fi','The Matrix','A computer hacker learns about the true nature of reality.'),(160,2,'Sci-Fi','Inception','A thief with the ability to enter dreams is given a final chance.'),(175,3,'Romance/Drama','Titanic','A young couple\'s love story unfolds on the ill-fated ship.');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_seq`
--

DROP TABLE IF EXISTS `movie_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_seq`
--

LOCK TABLES `movie_seq` WRITE;
/*!40000 ALTER TABLE `movie_seq` DISABLE KEYS */;
INSERT INTO `movie_seq` VALUES (4);
/*!40000 ALTER TABLE `movie_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registered_user`
--

DROP TABLE IF EXISTS `registered_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registered_user` (
  `annual_fee_paid` bit(1) NOT NULL,
  `id` int NOT NULL,
  `registration_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKmcfc3lkkshw71oewrhbvl806l` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registered_user`
--

LOCK TABLES `registered_user` WRITE;
/*!40000 ALTER TABLE `registered_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `registered_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `row_number` int NOT NULL,
  `seat_number` int NOT NULL,
  `is_available` tinyint(1) NOT NULL DEFAULT '1',
  `showtime_id` int DEFAULT NULL,
  `reserved_byru` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `showtime_id` (`showtime_id`),
  CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`showtime_id`) REFERENCES `Showtime` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,1,1,1,1,_binary '\0'),(2,1,2,1,1,_binary '\0'),(3,1,3,1,1,_binary '\0'),(4,1,4,1,1,_binary '\0'),(5,1,5,1,1,_binary '\0'),(6,1,6,1,1,_binary '\0'),(7,1,7,1,1,_binary '\0'),(8,1,8,1,1,_binary '\0'),(9,1,9,1,1,_binary '\0'),(10,1,10,1,1,_binary '\0'),(11,2,1,1,1,_binary '\0'),(12,2,2,1,1,_binary '\0'),(13,2,3,1,1,_binary '\0'),(14,2,4,1,1,_binary '\0'),(15,2,5,1,1,_binary '\0'),(16,2,6,1,1,_binary '\0'),(17,2,7,1,1,_binary '\0'),(18,2,8,1,1,_binary '\0'),(19,2,9,1,1,_binary '\0'),(20,2,10,1,1,_binary '\0'),(21,1,1,1,2,_binary '\0'),(22,1,2,1,2,_binary '\0'),(23,1,3,1,2,_binary '\0'),(24,1,4,1,2,_binary '\0'),(25,1,5,1,2,_binary '\0'),(26,1,6,1,2,_binary '\0'),(27,1,7,1,2,_binary '\0'),(28,1,8,1,2,_binary '\0'),(29,1,9,1,2,_binary '\0'),(30,1,10,1,2,_binary '\0'),(31,2,1,1,2,_binary '\0'),(32,2,2,1,2,_binary '\0'),(33,2,3,1,2,_binary '\0'),(34,2,4,1,2,_binary '\0'),(35,2,5,1,2,_binary '\0'),(36,2,6,1,2,_binary '\0'),(37,2,7,1,2,_binary '\0'),(38,2,8,1,2,_binary '\0'),(39,2,9,1,2,_binary '\0'),(40,2,10,1,2,_binary '\0'),(41,1,1,1,3,_binary '\0'),(42,1,2,1,3,_binary '\0'),(43,1,3,1,3,_binary '\0'),(44,1,4,1,3,_binary '\0'),(45,1,5,1,3,_binary '\0'),(46,1,6,1,3,_binary '\0'),(47,1,7,1,3,_binary '\0'),(48,1,8,1,3,_binary '\0'),(49,1,9,1,3,_binary '\0'),(50,1,10,1,3,_binary '\0'),(51,2,1,1,3,_binary '\0'),(52,2,2,1,3,_binary '\0'),(53,2,3,1,3,_binary '\0'),(54,2,4,1,3,_binary '\0'),(55,2,5,1,3,_binary '\0'),(56,2,6,1,3,_binary '\0'),(57,2,7,1,3,_binary '\0'),(58,2,8,1,3,_binary '\0'),(59,2,9,1,3,_binary '\0'),(60,2,10,1,3,_binary '\0');
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_seq`
--

DROP TABLE IF EXISTS `seat_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_seq`
--

LOCK TABLES `seat_seq` WRITE;
/*!40000 ALTER TABLE `seat_seq` DISABLE KEYS */;
INSERT INTO `seat_seq` VALUES (151);
/*!40000 ALTER TABLE `seat_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showtime`
--

DROP TABLE IF EXISTS `showtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showtime` (
  `id` int NOT NULL,
  `movie_id` int DEFAULT NULL,
  `theater_id` int DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8i90asti16tydhva795c3qwj2` (`movie_id`),
  KEY `FKtrskrnsmrbdplbrd1bn8gcpli` (`theater_id`),
  CONSTRAINT `FK8i90asti16tydhva795c3qwj2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  CONSTRAINT `FKtrskrnsmrbdplbrd1bn8gcpli` FOREIGN KEY (`theater_id`) REFERENCES `theater` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtime`
--

LOCK TABLES `showtime` WRITE;
/*!40000 ALTER TABLE `showtime` DISABLE KEYS */;
INSERT INTO `showtime` VALUES (1,1,1,'2024-12-02 18:00:00.000000'),(2,2,2,'2024-12-03 19:30:00.000000'),(3,3,1,'2024-12-04 20:45:00.000000');
/*!40000 ALTER TABLE `showtime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showtime_seq`
--

DROP TABLE IF EXISTS `showtime_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showtime_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtime_seq`
--

LOCK TABLES `showtime_seq` WRITE;
/*!40000 ALTER TABLE `showtime_seq` DISABLE KEYS */;
INSERT INTO `showtime_seq` VALUES (4);
/*!40000 ALTER TABLE `showtime_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater`
--

DROP TABLE IF EXISTS `theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater`
--

LOCK TABLES `theater` WRITE;
/*!40000 ALTER TABLE `theater` DISABLE KEYS */;
INSERT INTO `theater` VALUES (1,'123 Main St','Downtown Cinema'),(2,'456 Elm St','Uptown Theater');
/*!40000 ALTER TABLE `theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater_seq`
--

DROP TABLE IF EXISTS `theater_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater_seq`
--

LOCK TABLES `theater_seq` WRITE;
/*!40000 ALTER TABLE `theater_seq` DISABLE KEYS */;
INSERT INTO `theater_seq` VALUES (3);
/*!40000 ALTER TABLE `theater_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int NOT NULL,
  `is_cancelled` bit(1) NOT NULL,
  `showtime_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `cancellation_date` datetime(6) DEFAULT NULL,
  `purchase_date` datetime(6) DEFAULT NULL,
  `seat_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK3yhl9h2vv803mhf1jpk8puq4a` (`seat_id`),
  KEY `FKcy6kx0fhbmd7y6gia8th4e0fu` (`showtime_id`),
  KEY `FKdvt57mcco3ogsosi97odw563o` (`user_id`),
  CONSTRAINT `FKcy6kx0fhbmd7y6gia8th4e0fu` FOREIGN KEY (`showtime_id`) REFERENCES `showtime` (`id`),
  CONSTRAINT `FKdvt57mcco3ogsosi97odw563o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqahao9a85drt47ikjp0b8syvh` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_seq`
--

DROP TABLE IF EXISTS `ticket_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_seq`
--

LOCK TABLES `ticket_seq` WRITE;
/*!40000 ALTER TABLE `ticket_seq` DISABLE KEYS */;
INSERT INTO `ticket_seq` VALUES (1);
/*!40000 ALTER TABLE `ticket_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `credit_card` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10,'123 Elm Street ','1234 4567 8901 2345','johndoe@email.com','password','johndoe');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (11);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-01 22:48:19
