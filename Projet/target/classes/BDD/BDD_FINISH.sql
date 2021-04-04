-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ap2_gsb
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `agents`
--

DROP TABLE IF EXISTS `agents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agents` (
  `ag_matricule` int NOT NULL AUTO_INCREMENT,
  `ag_nom_utilisateur` varchar(45) NOT NULL,
  `ag_password` varchar(45) NOT NULL,
  `fk_se` int NOT NULL,
  `fk_ta` int NOT NULL,
  `fk_ve` char(7) DEFAULT NULL,
  PRIMARY KEY (`ag_matricule`),
  UNIQUE KEY `ag_matricule_UNIQUE` (`ag_matricule`),
  UNIQUE KEY `ag_nom_utilisateur_UNIQUE` (`ag_nom_utilisateur`),
  KEY `fk_AGENTS_1_idx` (`fk_se`),
  KEY `fk_AGENTS_2_idx` (`fk_ta`),
  KEY `fk_AGENTS_3_idx` (`fk_ve`),
  CONSTRAINT `fk_AGENTS_1` FOREIGN KEY (`fk_se`) REFERENCES `secteurs` (`se_id`),
  CONSTRAINT `fk_AGENTS_2` FOREIGN KEY (`fk_ta`) REFERENCES `type_agent` (`ta_id`),
  CONSTRAINT `fk_AGENTS_3` FOREIGN KEY (`fk_ve`) REFERENCES `vehicules` (`ve_immat`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agents`
--

LOCK TABLES `agents` WRITE;
/*!40000 ALTER TABLE `agents` DISABLE KEYS */;
INSERT INTO `agents` VALUES (1,'Simon','password1',1,1,'AAAAAAA'),(2,'Lucas','password2',2,1,'AAAAAAB'),(3,'Thibault','password3',3,1,'AAAAAAC'),(4,'Benjamin','password4',4,2,NULL),(5,'Louis','password5',1,1,'AAAAAAD');
/*!40000 ALTER TABLE `agents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fdrm`
--

DROP TABLE IF EXISTS `fdrm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fdrm` (
  `fk_ag` int NOT NULL,
  `fdrm_mois` char(5) NOT NULL,
  `fdrm_reception` date DEFAULT NULL,
  `fdrm_validation` date DEFAULT NULL,
  `fdrm_paiement` date DEFAULT NULL,
  `fdrm_remboursement` date DEFAULT NULL,
  `nbrj_conges` tinyint DEFAULT NULL,
  `fk_ag_comptable` int NOT NULL,
  PRIMARY KEY (`fk_ag`,`fdrm_mois`),
  KEY `fk_FDRM_1_idx` (`fk_ag`),
  KEY `fk_FDRM_2_idx` (`fk_ag_comptable`),
  CONSTRAINT `fk_FDRM_1` FOREIGN KEY (`fk_ag`) REFERENCES `agents` (`ag_matricule`),
  CONSTRAINT `fk_FDRM_2` FOREIGN KEY (`fk_ag_comptable`) REFERENCES `agents` (`ag_matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fdrm`
--

LOCK TABLES `fdrm` WRITE;
/*!40000 ALTER TABLE `fdrm` DISABLE KEYS */;
INSERT INTO `fdrm` VALUES (1,'04/20','1111-11-11',NULL,NULL,NULL,NULL,4),(1,'12/20',NULL,NULL,NULL,NULL,NULL,4);
/*!40000 ALTER TABLE `fdrm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frais`
--

DROP TABLE IF EXISTS `frais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `frais` (
  `fr_id` int NOT NULL AUTO_INCREMENT,
  `fr_libelle_libre` varchar(45) DEFAULT NULL,
  `fr_date` date NOT NULL,
  `fr_quantite` int NOT NULL,
  `fr_montant` decimal(6,2) DEFAULT NULL,
  `fr_taxe` decimal(6,2) NOT NULL,
  `fk_tre` int DEFAULT NULL,
  `fk_mfr` int DEFAULT NULL,
  `fk_fdrm_ag` int NOT NULL,
  `fk_fdrm_mois` char(5) NOT NULL,
  PRIMARY KEY (`fr_id`),
  KEY `fk_FRAIS_1_idx` (`fk_tre`),
  KEY `fk_FRAIS_2_idx` (`fk_mfr`),
  KEY `fk_FRAIS_3_idx` (`fk_fdrm_ag`,`fk_fdrm_mois`),
  CONSTRAINT `fk_FRAIS_1` FOREIGN KEY (`fk_tre`) REFERENCES `type_refus` (`tre_id`),
  CONSTRAINT `fk_FRAIS_2` FOREIGN KEY (`fk_mfr`) REFERENCES `modele_frais` (`mfr_id`),
  CONSTRAINT `fk_FRAIS_3` FOREIGN KEY (`fk_fdrm_ag`, `fk_fdrm_mois`) REFERENCES `fdrm` (`fk_ag`, `fdrm_mois`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frais`
--

LOCK TABLES `frais` WRITE;
/*!40000 ALTER TABLE `frais` DISABLE KEYS */;
INSERT INTO `frais` VALUES (5,'TEST1','2020-04-01',3,50.00,5.00,NULL,NULL,1,'04/20'),(6,'TEST2','2020-12-01',5,100.00,5.00,NULL,NULL,1,'12/20'),(7,NULL,'2020-12-01',4,100.00,5.00,NULL,2,1,'12/20'),(8,'TEST3','2020-04-01',2,142.00,5.00,NULL,5,1,'04/20');
/*!40000 ALTER TABLE `frais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frais_km`
--

DROP TABLE IF EXISTS `frais_km`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `frais_km` (
  `fkm_id` int NOT NULL AUTO_INCREMENT,
  `fkm_cv` int NOT NULL,
  `fkm_carburant` varchar(45) NOT NULL,
  `fkm_remb` decimal(4,2) NOT NULL,
  PRIMARY KEY (`fkm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frais_km`
--

LOCK TABLES `frais_km` WRITE;
/*!40000 ALTER TABLE `frais_km` DISABLE KEYS */;
INSERT INTO `frais_km` VALUES (1,4,'Diesel',0.52),(2,5,'Diesel',0.58),(3,6,'Diesel',0.58),(4,4,'Essence',0.62),(5,5,'Essence',0.67),(6,6,'Essence',0.67);
/*!40000 ALTER TABLE `frais_km` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modele_frais`
--

DROP TABLE IF EXISTS `modele_frais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modele_frais` (
  `mfr_id` int NOT NULL COMMENT '	',
  `mfr_libelle` varchar(45) NOT NULL,
  `mfr_montant_unitaire` decimal(6,2) NOT NULL,
  PRIMARY KEY (`mfr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modele_frais`
--

LOCK TABLES `modele_frais` WRITE;
/*!40000 ALTER TABLE `modele_frais` DISABLE KEYS */;
INSERT INTO `modele_frais` VALUES (1,'Repas midi (R1)',23.00),(2,'Repas midi (R2)',25.00),(3,'Repas midi (R3)',29.00),(4,'Nuitée simple (R1)',66.00),(5,'Nuitée simple (R2)',71.00),(6,'Nuitée simple (R3)',80.00),(7,'Repas soir + nuitée (R1)',77.00),(8,'Repas soir + nuitée (R2)',82.00),(9,'Repas soir + nuitée (R3)',92.00);
/*!40000 ALTER TABLE `modele_frais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametres`
--

DROP TABLE IF EXISTS `parametres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parametres` (
  `pa_id` int NOT NULL AUTO_INCREMENT,
  `validite_depense` int NOT NULL,
  `clorure_envoi_fdrm` int NOT NULL,
  `nbjr_atravaille` int NOT NULL,
  PRIMARY KEY (`pa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametres`
--

LOCK TABLES `parametres` WRITE;
/*!40000 ALTER TABLE `parametres` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secteurs`
--

DROP TABLE IF EXISTS `secteurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `secteurs` (
  `se_id` int NOT NULL AUTO_INCREMENT,
  `se_libelle` varchar(45) NOT NULL,
  PRIMARY KEY (`se_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secteurs`
--

LOCK TABLES `secteurs` WRITE;
/*!40000 ALTER TABLE `secteurs` DISABLE KEYS */;
INSERT INTO `secteurs` VALUES (1,'R1'),(2,'R2'),(3,'R3'),(4,'COMPTABLE R1'),(5,'COMPTABLE R2'),(6,'COMPTABLE R3');
/*!40000 ALTER TABLE `secteurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_agent`
--

DROP TABLE IF EXISTS `type_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_agent` (
  `ta_id` int NOT NULL AUTO_INCREMENT,
  `ta_libelle` varchar(45) NOT NULL,
  PRIMARY KEY (`ta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_agent`
--

LOCK TABLES `type_agent` WRITE;
/*!40000 ALTER TABLE `type_agent` DISABLE KEYS */;
INSERT INTO `type_agent` VALUES (1,'Visiteur'),(2,'Comptable');
/*!40000 ALTER TABLE `type_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_refus`
--

DROP TABLE IF EXISTS `type_refus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_refus` (
  `tre_id` int NOT NULL AUTO_INCREMENT,
  `tre_libelle` varchar(45) NOT NULL,
  PRIMARY KEY (`tre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_refus`
--

LOCK TABLES `type_refus` WRITE;
/*!40000 ALTER TABLE `type_refus` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_refus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicules`
--

DROP TABLE IF EXISTS `vehicules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicules` (
  `ve_immat` char(7) NOT NULL,
  `ve_marque` varchar(45) NOT NULL,
  `ve_model` varchar(45) NOT NULL,
  `fk_fkm` int NOT NULL,
  PRIMARY KEY (`ve_immat`),
  KEY `fk_VEHICULES_1_idx` (`fk_fkm`),
  CONSTRAINT `fk_VEHICULES_1` FOREIGN KEY (`fk_fkm`) REFERENCES `frais_km` (`fkm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicules`
--

LOCK TABLES `vehicules` WRITE;
/*!40000 ALTER TABLE `vehicules` DISABLE KEYS */;
INSERT INTO `vehicules` VALUES ('AAAAAAA','Test1','Truc1',1),('AAAAAAB','Test2','Truc2',2),('AAAAAAC','Test3','Truc3',3),('AAAAAAD','Test4','Truc4',4),('AAAAAAE','Test5','Truc5',5),('AAAAAAF','Test6','Truc6',6),('AAAAAAG','Test7','Truc7',1);
/*!40000 ALTER TABLE `vehicules` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-26 12:07:47
