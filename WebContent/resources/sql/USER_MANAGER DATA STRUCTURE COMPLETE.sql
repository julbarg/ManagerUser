CREATE DATABASE  IF NOT EXISTS `manager` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `manager`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: manager
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `audit`
--

DROP TABLE IF EXISTS `audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(60) NOT NULL,
  `column_name` varchar(60) NOT NULL,
  `id_register` int(11) NOT NULL,
  `old_value` varchar(60) DEFAULT NULL,
  `new_value` varchar(60) NOT NULL,
  `user` varchar(100) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit`
--

LOCK TABLES `audit` WRITE;
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
INSERT INTO `audit` (`id`, `table_name`, `column_name`, `id_register`, `old_value`, `new_value`, `user`, `date`) VALUES (1,'usuario_operacion','cedula',1,NULL,'1024501252','test','2015-10-30 10:17:53'),(2,'usuario_operacion','nombre',1,NULL,'JULIAN BARRAGAN','test','2015-10-30 10:17:53'),(3,'usuario_operacion','compania',1,NULL,'STEFANINI','test','2015-10-30 10:17:53'),(4,'usuario_operacion','sap',1,NULL,'1023','test','2015-10-30 10:17:53'),(5,'usuario_operacion','email',1,NULL,'julbarg@gmail.com','test','2015-10-30 10:17:53'),(6,'usuario_operacion','phone',1,NULL,'3123089218','test','2015-10-30 10:17:53'),(7,'usuario_operacion','estado',1,NULL,'A','test','2015-10-30 10:17:53'),(8,'usuario_operacion','estado_contrasena',1,NULL,'C','test','2015-10-30 10:17:53'),(9,'usuario_operacion','cedula',2,NULL,'1024501253','test','2015-10-30 10:26:09'),(10,'usuario_operacion','nombre',2,NULL,'CAMILO SIERRA','test','2015-10-30 10:26:09'),(11,'usuario_operacion','compania',2,NULL,'STEFANINI','test','2015-10-30 10:26:09'),(12,'usuario_operacion','sap',2,NULL,'1098','test','2015-10-30 10:26:09'),(13,'usuario_operacion','email',2,NULL,'camilo.sierra@stefanini.com','test','2015-10-30 10:26:09'),(14,'usuario_operacion','phone',2,NULL,'3213214354','test','2015-10-30 10:26:09'),(15,'usuario_operacion','estado',2,NULL,'A','test','2015-10-30 10:26:09'),(16,'usuario_operacion','estado_contrasena',2,NULL,'C','test','2015-10-30 10:26:09'),(17,'usuario_operacion','cedula',3,NULL,'1024501254','test','2015-10-30 10:26:52'),(18,'usuario_operacion','nombre',3,NULL,'IVAN MONTEALEGRE','test','2015-10-30 10:26:52'),(19,'usuario_operacion','compania',3,NULL,'STEFANINI','test','2015-10-30 10:26:52'),(20,'usuario_operacion','sap',3,NULL,'39048309','test','2015-10-30 10:26:52'),(21,'usuario_operacion','email',3,NULL,'ivan.montealegre@stefanini.com','test','2015-10-30 10:26:52'),(22,'usuario_operacion','phone',3,NULL,'9082350923','test','2015-10-30 10:26:53'),(23,'usuario_operacion','estado',3,NULL,'A','test','2015-10-30 10:26:53'),(24,'usuario_operacion','estado_contrasena',3,NULL,'C','test','2015-10-30 10:26:53'),(25,'usuario_operacion','cedula',4,NULL,'1024501256','test','2015-10-30 14:21:13'),(26,'usuario_operacion','nombre',4,NULL,'VANESA TRIANA','test','2015-10-30 14:21:13'),(27,'usuario_operacion','compania',4,NULL,'STEFANINI','test','2015-10-30 14:21:13'),(28,'usuario_operacion','sap',4,NULL,'3689043860','test','2015-10-30 14:21:13'),(29,'usuario_operacion','email',4,NULL,'vanesa.triana@stefanini.com','test','2015-10-30 14:21:13'),(30,'usuario_operacion','phone',4,NULL,'3214325465','test','2015-10-30 14:21:13'),(31,'usuario_operacion','estado',4,NULL,'A','test','2015-10-30 14:21:13'),(32,'usuario_operacion','estado_contrasena',4,NULL,'C','test','2015-10-30 14:21:13'),(33,'usuario_operacion','consulta_por_cuenta',1,'S','N','test','2015-10-30 14:28:51'),(34,'usuario_operacion','cargo',1,'Software Developer','','test','2015-10-30 14:29:09'),(35,'usuario_operacion','cedula',5,NULL,'1024501255','test','2015-10-30 14:30:06'),(36,'usuario_operacion','nombre',5,NULL,'JENNIFER AVILA','test','2015-10-30 14:30:06'),(37,'usuario_operacion','compania',5,NULL,'STEFANINI','test','2015-10-30 14:30:06'),(38,'usuario_operacion','sap',5,NULL,'2042687','test','2015-10-30 14:30:06'),(39,'usuario_operacion','email',5,NULL,'jennifer.avila@stefanini.com','test','2015-10-30 14:30:06'),(40,'usuario_operacion','phone',5,NULL,'3213213232','test','2015-10-30 14:30:06'),(41,'usuario_operacion','estado',5,NULL,'A','test','2015-10-30 14:30:06'),(42,'usuario_operacion','estado_contrasena',5,NULL,'C','test','2015-10-30 14:30:06'),(43,'usuario_operacion','cargo',5,NULL,'','test','2015-10-30 14:30:06'),(44,'usuario_operacion','consulta_por_cuenta',5,NULL,'N','test','2015-10-30 14:30:06'),(45,'usuario_operacion','cargo',5,'','Arquitecto','test','2015-10-30 14:30:34'),(46,'usuario_operacion','consulta_por_cuenta',5,'N','S','test','2015-10-30 14:30:34'),(47,'usuario_operacion','cargo',1,'','Contratista','test','2015-10-30 14:40:15'),(48,'usuario_operacion','cargo',1,'Contratista','','test','2015-10-30 14:40:28'),(49,'usuario_operacion','cargo',1,'','Desarrollador','test','2015-10-30 14:53:31'),(50,'usuario_operacion','consulta_por_cuenta',1,'N','S','test','2015-10-30 14:53:31'),(81,'usuario_operacion','cedula',10,NULL,'123456789','test','2015-11-04 11:51:18'),(82,'usuario_operacion','nombre',10,NULL,'ANDRES JUAN PEREZ','test','2015-11-04 11:51:18'),(83,'usuario_operacion','compania',10,NULL,' CLARO','test','2015-11-04 11:51:18'),(84,'usuario_operacion','sap',10,NULL,'123456789','test','2015-11-04 11:51:18'),(85,'usuario_operacion','email',10,NULL,'andres@claro.com','test','2015-11-04 11:51:18'),(86,'usuario_operacion','phone',10,NULL,'3218769421','test','2015-11-04 11:51:18'),(87,'usuario_operacion','estado',10,NULL,'A','test','2015-11-04 11:51:18'),(88,'usuario_operacion','estado_contrasena',10,NULL,'C','test','2015-11-04 11:51:18'),(89,'usuario_operacion','cargo',10,NULL,'Medico','test','2015-11-04 11:51:18'),(90,'usuario_operacion','consulta_por_cuenta',10,NULL,'S','test','2015-11-04 11:51:18'),(91,'usuario_operacion','cedula',11,NULL,'987654321','test','2015-11-04 11:51:18'),(92,'usuario_operacion','nombre',11,NULL,'MARIA ANDREA LOPEZ','test','2015-11-04 11:51:18'),(93,'usuario_operacion','compania',11,NULL,' CLARO','test','2015-11-04 11:51:18'),(94,'usuario_operacion','sap',11,NULL,'987654321','test','2015-11-04 11:51:18'),(95,'usuario_operacion','email',11,NULL,'maria@claro.com','test','2015-11-04 11:51:18'),(96,'usuario_operacion','phone',11,NULL,'3218769421','test','2015-11-04 11:51:18'),(97,'usuario_operacion','estado',11,NULL,'A','test','2015-11-04 11:51:18'),(98,'usuario_operacion','estado_contrasena',11,NULL,'C','test','2015-11-04 11:51:18'),(99,'usuario_operacion','cargo',11,NULL,'Arquitecto','test','2015-11-04 11:51:18'),(100,'usuario_operacion','consulta_por_cuenta',11,NULL,'S','test','2015-11-04 11:51:18'),(101,'usuario_operacion','cedula',12,NULL,'1234598765','test','2015-11-04 11:51:18'),(102,'usuario_operacion','nombre',12,NULL,'JUAN CAMILO RODIRGUEZ','test','2015-11-04 11:51:18'),(103,'usuario_operacion','compania',12,NULL,' CLARO','test','2015-11-04 11:51:18'),(104,'usuario_operacion','sap',12,NULL,'1234598765','test','2015-11-04 11:51:18'),(105,'usuario_operacion','email',12,NULL,'juan@claro.com','test','2015-11-04 11:51:18'),(106,'usuario_operacion','phone',12,NULL,'3218769421','test','2015-11-04 11:51:18'),(107,'usuario_operacion','estado',12,NULL,'A','test','2015-11-04 11:51:18'),(108,'usuario_operacion','estado_contrasena',12,NULL,'C','test','2015-11-04 11:51:18'),(109,'usuario_operacion','cargo',12,NULL,'Ingeniero','test','2015-11-04 11:51:18'),(110,'usuario_operacion','consulta_por_cuenta',12,NULL,'N','test','2015-11-04 11:51:18'),(111,'usuario_operacion','cedula',13,NULL,'987651234','test','2015-11-04 11:51:18'),(112,'usuario_operacion','nombre',13,NULL,'JUAN ANDRES PEREZ','test','2015-11-04 11:51:18'),(113,'usuario_operacion','compania',13,NULL,' CLARO','test','2015-11-04 11:51:18'),(114,'usuario_operacion','sap',13,NULL,'987651234','test','2015-11-04 11:51:18'),(115,'usuario_operacion','email',13,NULL,'andres.perez@claro.com','test','2015-11-04 11:51:18'),(116,'usuario_operacion','phone',13,NULL,'3218769421','test','2015-11-04 11:51:18'),(117,'usuario_operacion','estado',13,NULL,'A','test','2015-11-04 11:51:18'),(118,'usuario_operacion','estado_contrasena',13,NULL,'C','test','2015-11-04 11:51:18'),(119,'usuario_operacion','cargo',13,NULL,'Profesor','test','2015-11-04 11:51:18'),(120,'usuario_operacion','consulta_por_cuenta',13,NULL,'N','test','2015-11-04 11:51:18'),(121,'usuario_operacion','cedula',14,NULL,'123456789','test','2015-11-04 14:53:44'),(122,'usuario_operacion','nombre',14,NULL,'ANDRES JUAN PEREZ','test','2015-11-04 14:53:44'),(123,'usuario_operacion','compania',14,NULL,'CLARO','test','2015-11-04 14:53:44'),(124,'usuario_operacion','sap',14,NULL,'123456789','test','2015-11-04 14:53:44'),(125,'usuario_operacion','email',14,NULL,'andres2@claro.com','test','2015-11-04 14:53:44'),(126,'usuario_operacion','phone',14,NULL,'3218769421','test','2015-11-04 14:53:44'),(127,'usuario_operacion','estado',14,NULL,'A','test','2015-11-04 14:53:44'),(128,'usuario_operacion','estado_contrasena',14,NULL,'C','test','2015-11-04 14:53:44'),(129,'usuario_operacion','cargo',14,NULL,'MEDICO','test','2015-11-04 14:53:44'),(130,'usuario_operacion','consulta_por_cuenta',14,NULL,'S','test','2015-11-04 14:53:44'),(131,'usuario_operacion','cedula',15,NULL,'987654321','test','2015-11-04 14:53:44'),(132,'usuario_operacion','nombre',15,NULL,'MARIA ANDREA LOPEZ','test','2015-11-04 14:53:44'),(133,'usuario_operacion','compania',15,NULL,'MOVISTAR','test','2015-11-04 14:53:44'),(134,'usuario_operacion','sap',15,NULL,'987654321','test','2015-11-04 14:53:44'),(135,'usuario_operacion','email',15,NULL,'maria2@claro.com','test','2015-11-04 14:53:44'),(136,'usuario_operacion','phone',15,NULL,'3218769421','test','2015-11-04 14:53:44'),(137,'usuario_operacion','estado',15,NULL,'A','test','2015-11-04 14:53:44'),(138,'usuario_operacion','estado_contrasena',15,NULL,'C','test','2015-11-04 14:53:44'),(139,'usuario_operacion','cargo',15,NULL,'ARQUITECTO','test','2015-11-04 14:53:44'),(140,'usuario_operacion','consulta_por_cuenta',15,NULL,'S','test','2015-11-04 14:53:44'),(141,'usuario_operacion','cedula',16,NULL,'1234598765','test','2015-11-04 14:53:44'),(142,'usuario_operacion','nombre',16,NULL,'JUAN CAMILO RODIRGUEZ','test','2015-11-04 14:53:44'),(143,'usuario_operacion','compania',16,NULL,'TIGO','test','2015-11-04 14:53:44'),(144,'usuario_operacion','sap',16,NULL,'1234598765','test','2015-11-04 14:53:44'),(145,'usuario_operacion','email',16,NULL,'juan2@claro.com','test','2015-11-04 14:53:44'),(146,'usuario_operacion','phone',16,NULL,'3218769421','test','2015-11-04 14:53:44'),(147,'usuario_operacion','estado',16,NULL,'A','test','2015-11-04 14:53:44'),(148,'usuario_operacion','estado_contrasena',16,NULL,'C','test','2015-11-04 14:53:44'),(149,'usuario_operacion','cargo',16,NULL,'INGENIERO','test','2015-11-04 14:53:44'),(150,'usuario_operacion','consulta_por_cuenta',16,NULL,'N','test','2015-11-04 14:53:44'),(151,'usuario_operacion','cedula',17,NULL,'987651234','test','2015-11-04 14:53:44'),(152,'usuario_operacion','nombre',17,NULL,'JUAN ANDRES PEREZ','test','2015-11-04 14:53:44'),(153,'usuario_operacion','compania',17,NULL,'CAFAM','test','2015-11-04 14:53:44'),(154,'usuario_operacion','sap',17,NULL,'987651234','test','2015-11-04 14:53:44'),(155,'usuario_operacion','email',17,NULL,'andres.perez2@claro.com','test','2015-11-04 14:53:44'),(156,'usuario_operacion','phone',17,NULL,'3218769421','test','2015-11-04 14:53:44'),(157,'usuario_operacion','estado',17,NULL,'A','test','2015-11-04 14:53:44'),(158,'usuario_operacion','estado_contrasena',17,NULL,'C','test','2015-11-04 14:53:44'),(159,'usuario_operacion','cargo',17,NULL,'PROFESOR','test','2015-11-04 14:53:44'),(160,'usuario_operacion','consulta_por_cuenta',17,NULL,'N','test','2015-11-04 14:53:44'),(161,'usuario_operacion','cargo',14,'MEDICO','ARQUITECTO','test','2015-11-04 14:54:32'),(162,'usuario_operacion','cedula',18,NULL,'123456789','test','2015-11-04 14:57:07'),(163,'usuario_operacion','nombre',18,NULL,'ANDRES JUAN PEREZ','test','2015-11-04 14:57:07'),(164,'usuario_operacion','compania',18,NULL,'CLARO','test','2015-11-04 14:57:07'),(165,'usuario_operacion','sap',18,NULL,'123456789','test','2015-11-04 14:57:07'),(166,'usuario_operacion','email',18,NULL,'andres2@claro.com','test','2015-11-04 14:57:07'),(167,'usuario_operacion','phone',18,NULL,'3218769421','test','2015-11-04 14:57:07'),(168,'usuario_operacion','estado',18,NULL,'A','test','2015-11-04 14:57:07'),(169,'usuario_operacion','estado_contrasena',18,NULL,'C','test','2015-11-04 14:57:07'),(170,'usuario_operacion','cargo',18,NULL,'MEDICO','test','2015-11-04 14:57:07'),(171,'usuario_operacion','consulta_por_cuenta',18,NULL,'S','test','2015-11-04 14:57:07'),(172,'usuario_operacion','cedula',19,NULL,'987654321','test','2015-11-04 14:57:07'),(173,'usuario_operacion','nombre',19,NULL,'MARIA ANDREA LOPEZ','test','2015-11-04 14:57:07'),(174,'usuario_operacion','compania',19,NULL,'MOVISTAR','test','2015-11-04 14:57:07'),(175,'usuario_operacion','sap',19,NULL,'987654321','test','2015-11-04 14:57:07'),(176,'usuario_operacion','email',19,NULL,'maria2@claro.com','test','2015-11-04 14:57:07'),(177,'usuario_operacion','phone',19,NULL,'3218769421','test','2015-11-04 14:57:07'),(178,'usuario_operacion','estado',19,NULL,'A','test','2015-11-04 14:57:07'),(179,'usuario_operacion','estado_contrasena',19,NULL,'C','test','2015-11-04 14:57:07'),(180,'usuario_operacion','cargo',19,NULL,'ARQUITECTO','test','2015-11-04 14:57:07'),(181,'usuario_operacion','consulta_por_cuenta',19,NULL,'S','test','2015-11-04 14:57:07'),(182,'usuario_operacion','cedula',20,NULL,'1234598765','test','2015-11-04 14:57:07'),(183,'usuario_operacion','nombre',20,NULL,'JUAN CAMILO RODIRGUEZ','test','2015-11-04 14:57:07'),(184,'usuario_operacion','compania',20,NULL,'TIGO','test','2015-11-04 14:57:07'),(185,'usuario_operacion','sap',20,NULL,'1234598765','test','2015-11-04 14:57:07'),(186,'usuario_operacion','email',20,NULL,'juan2@claro.com','test','2015-11-04 14:57:07'),(187,'usuario_operacion','phone',20,NULL,'3218769421','test','2015-11-04 14:57:07'),(188,'usuario_operacion','estado',20,NULL,'A','test','2015-11-04 14:57:07'),(189,'usuario_operacion','estado_contrasena',20,NULL,'C','test','2015-11-04 14:57:07'),(190,'usuario_operacion','cargo',20,NULL,'INGENIERO','test','2015-11-04 14:57:07'),(191,'usuario_operacion','consulta_por_cuenta',20,NULL,'N','test','2015-11-04 14:57:07'),(192,'usuario_operacion','cedula',21,NULL,'987651234','test','2015-11-04 14:57:07'),(193,'usuario_operacion','nombre',21,NULL,'JUAN ANDRES PEREZ','test','2015-11-04 14:57:07'),(194,'usuario_operacion','compania',21,NULL,'CAFAM','test','2015-11-04 14:57:07'),(195,'usuario_operacion','sap',21,NULL,'987651234','test','2015-11-04 14:57:07'),(196,'usuario_operacion','email',21,NULL,'andres.perez2@claro.com','test','2015-11-04 14:57:07'),(197,'usuario_operacion','phone',21,NULL,'3218769421','test','2015-11-04 14:57:07'),(198,'usuario_operacion','estado',21,NULL,'A','test','2015-11-04 14:57:07'),(199,'usuario_operacion','estado_contrasena',21,NULL,'C','test','2015-11-04 14:57:07'),(200,'usuario_operacion','cargo',21,NULL,'PROFESOR','test','2015-11-04 14:57:07'),(201,'usuario_operacion','consulta_por_cuenta',21,NULL,'N','test','2015-11-04 14:57:07'),(202,'usuario_operacion','cargo',18,'MEDICO','ingeniero','test','2015-11-04 14:57:41');
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_allowed`
--

DROP TABLE IF EXISTS `user_allowed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_allowed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name_allowed` varchar(45) NOT NULL,
  `admin` varchar(1) DEFAULT NULL,
  `user_create` varchar(45) NOT NULL,
  `date_create` date NOT NULL,
  `user_update` varchar(45) DEFAULT NULL,
  `date_update` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_allowed_UNIQUE` (`user_name_allowed`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_allowed`
--

LOCK TABLES `user_allowed` WRITE;
/*!40000 ALTER TABLE `user_allowed` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_allowed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_operacion`
--

DROP TABLE IF EXISTS `usuario_operacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_operacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` bigint(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `compania` varchar(200) DEFAULT NULL,
  `sap` bigint(20) NOT NULL,
  `estado` varchar(1) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `estado_contrasena` varchar(1) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` bigint(15) DEFAULT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  `consulta_por_cuenta` varchar(2) DEFAULT NULL,
  `user_create` varchar(45) DEFAULT NULL,
  `date_create` datetime DEFAULT NULL,
  `user_update` varchar(45) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `cedula_UNIQUE` (`cedula`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_operacion`
--

LOCK TABLES `usuario_operacion` WRITE;
/*!40000 ALTER TABLE `usuario_operacion` DISABLE KEYS */;
INSERT INTO `usuario_operacion` (`id`, `cedula`, `nombre`, `compania`, `sap`, `estado`, `contrasena`, `estado_contrasena`, `email`, `phone`, `cargo`, `consulta_por_cuenta`, `user_create`, `date_create`, `user_update`, `date_update`) VALUES (18,123456789,'ANDRES JUAN PEREZ','CLARO',123456789,'A','123456789','C','andres2@claro.com',3218769421,'ingeniero','S','test','2015-11-04 14:57:06','test','2015-11-04 15:00:20'),(19,987654321,'MARIA ANDREA LOPEZ','MOVISTAR',987654321,'A',' 987654321','C','maria2@claro.com',3218769421,'ARQUITECTO','S','test','2015-11-04 14:57:07',NULL,NULL),(20,1234598765,'JUAN CAMILO RODIRGUEZ','TIGO',1234598765,'A',' 1234598765','C','juan2@claro.com',3218769421,'INGENIERO','N','test','2015-11-04 14:57:07',NULL,NULL),(21,987651234,'JUAN ANDRES PEREZ','CAFAM',987651234,'A',' 987651234','C','andres.perez2@claro.com',3218769421,'PROFESOR','N','test','2015-11-04 14:57:07',NULL,NULL);
/*!40000 ALTER TABLE `usuario_operacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-17 17:10:18
