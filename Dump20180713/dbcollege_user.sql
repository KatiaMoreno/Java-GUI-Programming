-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbcollege
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.26-MariaDB

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `name_user` varchar(30) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `login` varchar(15) NOT NULL,
  `password_user` varchar(8) NOT NULL,
  `profile_user` varchar(20) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `gender` enum('M','F') DEFAULT NULL,
  `course_current` int(11) NOT NULL,
  `course` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `id_user_UNIQUE` (`id_user`),
  KEY `course_current_idx` (`course_current`),
  CONSTRAINT `FK_couser` FOREIGN KEY (`course_current`) REFERENCES `course` (`id_course`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2018000,'KATIA MORENO','086 4546042','adm','adm','Administrator','59 beach hill ave','adm@itcollege.ie','Brasilian','F',0,'0'),(2018001,'KALIENY MORENO','086 888 1111','adm2','adm','Administrator','59 beach hill','mark@itcollege.ie','Brasilian','F',0,'0'),(2018002,'Philip Donald Estridge','081 888 9991','2018002','std','student','Paris Street','pde@gmail.com','American','M',1,'JAVA'),(2018003,'James Arthur Gosling','089  555 5556','2018003','std','student','Norway Street','jag@hotmail.com','Canadian','M',2,'PHP'),(2018004,'Mark Zuckerberg','088 454 4646','2018004','std','student','Lisbon Street','mz@hotmail.com','American','M',5,'Network Basic'),(2018005,'Bill Gates','087 999 5855','2018005','std','student','42, Malaga Street','bil@gmail.com','American','M',3,'HTML'),(2018006,'Steven Paul Jobs','086 111 2222','2018006','std','student','35, Rio de Janeiro Street','spj@gmail.com','American','M',3,'HTML'),(2018007,'Grace Hopper','089 787 4562','2018007','std','student','01, Japan Street','grace@yahoo.com','American','F',2,'PHP'),(2018008,'Radia Perlman','087  454 5252','2018008','std','student','88, Portugal Street','radia@hotmail.com','American','F',1,'JAVA');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-13 12:49:11
