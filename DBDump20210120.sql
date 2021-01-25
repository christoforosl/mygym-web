CREATE DATABASE  IF NOT EXISTS `e6edpymv83gonwa5` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `e6edpymv83gonwa5`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: zpfp07ebhm2zgmrm.chr7pe7iynqr.eu-west-1.rds.amazonaws.com    Database: e6edpymv83gonwa5
-- ------------------------------------------------------
-- Server version	5.7.26-log

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `body_part`
--

DROP TABLE IF EXISTS `body_part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `body_part` (
  `body_part_id` int(11) NOT NULL AUTO_INCREMENT,
  `body_part_name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  `update_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`body_part_id`),
  UNIQUE KEY `body_part_name_UNIQUE` (`body_part_name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `body_part`
--

LOCK TABLES `body_part` WRITE;
/*!40000 ALTER TABLE `body_part` DISABLE KEYS */;
INSERT INTO `body_part` VALUES (1,'Abs','2021-01-20 13:09:27','2021-01-20 13:09:27','admin','admin'),(2,'Forearms','2021-01-20 13:09:27','2021-01-20 13:09:27','admin','admin'),(3,'Triceps','2021-01-20 13:09:27','2021-01-20 13:09:27','admin','admin'),(4,'Legs','2021-01-20 13:09:27','2021-01-20 13:09:27','admin','admin'),(5,'Core','2021-01-20 13:09:27','2021-01-20 13:09:27','admin','admin'),(11,'Chest','2021-01-20 13:09:27','2021-01-20 13:09:27','admin','admin');
/*!40000 ALTER TABLE `body_part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `body_part_exercise`
--

DROP TABLE IF EXISTS `body_part_exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `body_part_exercise` (
  `body_part_exercise_id` int(11) NOT NULL AUTO_INCREMENT,
  `body_part_id` int(11) NOT NULL,
  `exercise_id` int(11) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  `update_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`body_part_exercise_id`),
  UNIQUE KEY `body_part_exercise_uq` (`body_part_id`,`exercise_id`),
  KEY `body_part_exercise_r02` (`exercise_id`),
  CONSTRAINT `body_part_exercise_r01` FOREIGN KEY (`body_part_id`) REFERENCES `body_part` (`body_part_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `body_part_exercise_r02` FOREIGN KEY (`exercise_id`) REFERENCES `exercise_definition` (`exercise_definition_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='links exercises with body parts';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `body_part_exercise`
--

LOCK TABLES `body_part_exercise` WRITE;
/*!40000 ALTER TABLE `body_part_exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `body_part_exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipment` (
  `equipment_id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  `update_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`equipment_id`),
  UNIQUE KEY `equipment_name_UNIQUE` (`equipment_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='stores equipment needed for exercises';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (1,'Body Part Exercise, no Equipment Needed','2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(2,'Dumbells','2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(3,'Bar','2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(4,'Latex Band','2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin');
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_definition`
--

DROP TABLE IF EXISTS `exercise_definition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_definition` (
  `exercise_definition_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `video_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(1500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `equipment_id` int(11) NOT NULL DEFAULT '1' COMMENT 'what type of equiment is required to execute the exercise',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) COLLATE utf8_esperanto_ci NOT NULL DEFAULT 'admin',
  `update_user` varchar(50) COLLATE utf8_esperanto_ci NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`exercise_definition_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci COMMENT='stores exercise definitions';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_definition`
--

LOCK TABLES `exercise_definition` WRITE;
/*!40000 ALTER TABLE `exercise_definition` DISABLE KEYS */;
INSERT INTO `exercise_definition` VALUES (1,'Push Up',NULL,'Classic Push Up',1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(2,'Wide Hands Push Up',NULL,'Push Up with hands placed wide ',1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(3,'Narrow Hands Push Up',NULL,'Push Up with hands placed norrrowly under the chest',1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(4,'Chin Ups',NULL,NULL,3,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(5,'Lunge to Front Kick - R',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(6,'Lunge to Front Kick - L',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(7,'Backward Lunges',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(8,'Walking Lunges',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(9,'Squat',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(10,'Frog Squat',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(11,'Classic Burpee',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(12,'6 Count Burpee (with push up)',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(13,'Forward Jump Squat',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(14,'Jump Squat',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(15,'Scissor kicks','https://www.youtube.com/watch?v=WoNCIBVLbgY',NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(16,'Bicycle Crunches','https://www.youtube.com/watch?v=Iwyvozckjak',NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(17,'Pull Up',NULL,NULL,3,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(18,'Up Downs',NULL,'Going from low to high plunk and back',1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(19,'Low Plank',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(20,'High Plank',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(21,'Punches',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(22,'Jumping Jacks',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(23,'Russian Twist',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(24,'Skier Abs',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(25,'Leg Raises',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(26,'Mountain Climbers',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(27,'Push-up Site Planks',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(28,'Arm Circles Forward',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(29,'Arm Circles Backward',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(30,'Superman',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(31,'Bridge',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(32,'Crunches',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(33,'High Plank Leg Lifts',NULL,NULL,1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(34,'Pec Stretch',NULL,'nterlock your hands behind the back, keeping your arms straight while pulling your hands down towards the floor. Squeeze your shoulder blades together.',1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(35,'Thoracic Extension',NULL,'What it helps: Reduces hunching in the middle back and opens up the chest to alleviate neck and upper-back pain. This exercise will help correct a slouched forward posture. How to do it: Clasp both hands behind your head and gently pull backward, squeezing your shoulder blades together. Hold for five breaths.',1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(36,'Back Bend',NULL,'What it helps: This exercise takes pressure off your spine and reduces lower-back pain.',1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(37,'Reclining Twist',NULL,'What it helps: This exercise stretches the back, chest, and glutes.',1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(38,'Supported Backbend','https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/option-b1-backbend-deep-backbend-1499798986.jpg','Why: Bending backward helps improve posture and supports the muscles that stabilize your spine.',1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(39,'Number 4 Sit','https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/number4-sit-1499798989.jpg?resize=768:*','',1,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin');
/*!40000 ALTER TABLE `exercise_definition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_type`
--

DROP TABLE IF EXISTS `exercise_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_type` (
  `exercise_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `exercise_type` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  `update_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`exercise_type_id`),
  UNIQUE KEY `exercise_type_UNIQUE` (`exercise_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_type`
--

LOCK TABLES `exercise_type` WRITE;
/*!40000 ALTER TABLE `exercise_type` DISABLE KEYS */;
INSERT INTO `exercise_type` VALUES (1,'Exercise','2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(2,'Warmup','2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(3,'Stretch','2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin');
/*!40000 ALTER TABLE `exercise_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_type_link`
--

DROP TABLE IF EXISTS `exercise_type_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_type_link` (
  `exercise_type_link_id` int(11) NOT NULL AUTO_INCREMENT,
  `exercise_type_id` int(11) NOT NULL,
  `exercise_id` int(11) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  `update_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`exercise_type_link_id`),
  UNIQUE KEY `exercise_type_link_uq` (`exercise_type_id`,`exercise_id`),
  KEY `exercise_type_link_r02` (`exercise_id`),
  CONSTRAINT `exercise_type_link_r01` FOREIGN KEY (`exercise_type_id`) REFERENCES `exercise_type` (`exercise_type_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `exercise_type_link_r02` FOREIGN KEY (`exercise_id`) REFERENCES `exercise_definition` (`exercise_definition_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='links exercises with exercise types';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_type_link`
--

LOCK TABLES `exercise_type_link` WRITE;
/*!40000 ALTER TABLE `exercise_type_link` DISABLE KEYS */;
INSERT INTO `exercise_type_link` VALUES (1,3,30,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(2,3,33,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(3,3,31,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(4,3,32,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(5,3,28,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(6,3,29,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(7,2,24,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(8,2,25,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(9,2,26,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(10,2,27,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(11,3,34,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(12,3,35,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(13,3,36,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(14,3,37,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(15,3,38,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin'),(16,3,39,'2021-01-20 13:09:28','2021-01-20 13:09:28','admin','admin');
/*!40000 ALTER TABLE `exercise_type_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user`
--

DROP TABLE IF EXISTS `system_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_user` (
  `system_user_id` int(10) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_active` int(1) NOT NULL DEFAULT '1',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  `update_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`system_user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='stores system users';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user`
--

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_exercise_definition`
--

DROP TABLE IF EXISTS `v_exercise_definition`;
/*!50001 DROP VIEW IF EXISTS `v_exercise_definition`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_exercise_definition` AS SELECT 
 1 AS `EXERCISE_DEFINITION_ID`,
 1 AS `NAME`,
 1 AS `VIDEO_URL`,
 1 AS `body_part_name`,
 1 AS `exercise_type`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `workout`
--

DROP TABLE IF EXISTS `workout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout` (
  `workout_id` int(10) NOT NULL AUTO_INCREMENT,
  `system_user_id` int(10) NOT NULL,
  `workout_start` timestamp NOT NULL,
  `workout_end` timestamp NOT NULL,
  `notes` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `scheduled_workout_id` int(11) DEFAULT NULL,
  `workout_definition_id` int(11) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  `update_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`workout_id`),
  KEY `workout_r01_idx` (`system_user_id`),
  KEY `workout_r02` (`scheduled_workout_id`),
  CONSTRAINT `workout_r01` FOREIGN KEY (`system_user_id`) REFERENCES `system_user` (`system_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `workout_r02` FOREIGN KEY (`scheduled_workout_id`) REFERENCES `workout_definition` (`WORKOUT_DEFINITION_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='RECORDING OF A WORKOUT';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout`
--

LOCK TABLES `workout` WRITE;
/*!40000 ALTER TABLE `workout` DISABLE KEYS */;
/*!40000 ALTER TABLE `workout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_definition`
--

DROP TABLE IF EXISTS `workout_definition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout_definition` (
  `WORKOUT_DEFINITION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(1500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  `update_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`WORKOUT_DEFINITION_ID`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_definition`
--

LOCK TABLES `workout_definition` WRITE;
/*!40000 ALTER TABLE `workout_definition` DISABLE KEYS */;
/*!40000 ALTER TABLE `workout_definition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_exercise`
--

DROP TABLE IF EXISTS `workout_exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout_exercise` (
  `workout_exercise_id` int(11) NOT NULL AUTO_INCREMENT,
  `workout_id` int(10) NOT NULL,
  `sequence` int(4) NOT NULL,
  `exercise_id` int(11) NOT NULL,
  `number_of_sets` int(2) NOT NULL DEFAULT '1',
  `repetitions_each_set` int(3) DEFAULT NULL COMMENT 'number of repetitions of exercise',
  `duration_seconds` int(5) DEFAULT NULL COMMENT 'time to execute exercise, in seconds',
  `rest_seconds` int(5) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  `update_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`workout_exercise_id`),
  KEY `workout_exercise_r02_idx` (`workout_id`),
  KEY `workout_exercise_r01` (`exercise_id`),
  CONSTRAINT `workout_exercise_r01` FOREIGN KEY (`exercise_id`) REFERENCES `exercise_definition` (`exercise_definition_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `workout_exercise_r02` FOREIGN KEY (`workout_id`) REFERENCES `workout` (`workout_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Links Workouts with exercises';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_exercise`
--

LOCK TABLES `workout_exercise` WRITE;
/*!40000 ALTER TABLE `workout_exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `workout_exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'e6edpymv83gonwa5'
--

--
-- Final view structure for view `v_exercise_definition`
--

/*!50001 DROP VIEW IF EXISTS `v_exercise_definition`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`drpskrhz840bqf1w`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_exercise_definition` AS select `t`.`exercise_definition_id` AS `EXERCISE_DEFINITION_ID`,`t`.`name` AS `NAME`,`t`.`video_url` AS `VIDEO_URL`,(select `p`.`body_part_name` from (`body_part` `p` join `body_part_exercise` `pe`) where ((`pe`.`body_part_id` = `p`.`body_part_id`) and (`pe`.`exercise_id` = `t`.`exercise_definition_id`))) AS `body_part_name`,(select `p`.`exercise_type` from (`exercise_type` `p` join `exercise_type_link` `pe`) where ((`pe`.`exercise_type_id` = `p`.`exercise_type_id`) and (`pe`.`exercise_id` = `t`.`exercise_definition_id`))) AS `exercise_type` from `exercise_definition` `t` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-20 15:11:35
