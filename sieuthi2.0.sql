-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sieuthi
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
-- Table structure for table `kho`
--

DROP TABLE IF EXISTS `kho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kho` (
  `ID_Loai_Kho` int NOT NULL,
  `Ten_Loai_Kho` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_Loai_Kho`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kho`
--

LOCK TABLES `kho` WRITE;
/*!40000 ALTER TABLE `kho` DISABLE KEYS */;
/*!40000 ALTER TABLE `kho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khu_vuc`
--

DROP TABLE IF EXISTS `khu_vuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khu_vuc` (
  `ID_KV` varchar(100) NOT NULL,
  `ID_Loai_Kho` int NOT NULL,
  PRIMARY KEY (`ID_KV`),
  KEY `FK1_KV_idx` (`ID_Loai_Kho`),
  CONSTRAINT `FK1_KV` FOREIGN KEY (`ID_Loai_Kho`) REFERENCES `kho` (`ID_Loai_Kho`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khu_vuc`
--

LOCK TABLES `khu_vuc` WRITE;
/*!40000 ALTER TABLE `khu_vuc` DISABLE KEYS */;
/*!40000 ALTER TABLE `khu_vuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lo_san_pham`
--

DROP TABLE IF EXISTS `lo_san_pham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lo_san_pham` (
  `ID_Lo` int NOT NULL,
  `HSD` date NOT NULL,
  `NSX` date NOT NULL,
  `ID_SP` int NOT NULL,
  `So_Tien_SP` int NOT NULL,
  `ID_Phieu_Nhap` int NOT NULL,
  `So_Tien_Lo` int NOT NULL,
  PRIMARY KEY (`ID_Lo`),
  KEY `FK1_Lo_SP_idx` (`ID_SP`),
  KEY `FK2_Lo_SP_idx` (`ID_Phieu_Nhap`),
  CONSTRAINT `FK1_Lo_SP` FOREIGN KEY (`ID_SP`) REFERENCES `san_pham` (`ID_SP`),
  CONSTRAINT `FK2_Lo_SP` FOREIGN KEY (`ID_Phieu_Nhap`) REFERENCES `phieu_nhap` (`ID_Phieu_Nhap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lo_san_pham`
--

LOCK TABLES `lo_san_pham` WRITE;
/*!40000 ALTER TABLE `lo_san_pham` DISABLE KEYS */;
/*!40000 ALTER TABLE `lo_san_pham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loai_san_pham`
--

DROP TABLE IF EXISTS `loai_san_pham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_san_pham` (
  `ID_Loai_SP` int NOT NULL,
  `Ten_Loai_SP` varchar(100) NOT NULL,
  `Don_Vi` varchar(100) NOT NULL,
  `ID_KV` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_Loai_SP`),
  KEY `FK1_Loai_SP_idx` (`ID_KV`),
  CONSTRAINT `FK1_Loai_SP` FOREIGN KEY (`ID_KV`) REFERENCES `khu_vuc` (`ID_KV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_san_pham`
--

LOCK TABLES `loai_san_pham` WRITE;
/*!40000 ALTER TABLE `loai_san_pham` DISABLE KEYS */;
/*!40000 ALTER TABLE `loai_san_pham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguon_cc`
--

DROP TABLE IF EXISTS `nguon_cc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguon_cc` (
  `ID_CC` int NOT NULL,
  `Ten_Nha_CC` varchar(100) NOT NULL,
  `SDT` varchar(100) NOT NULL,
  `Dia_Chi` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Hinh_Anh` longblob NOT NULL,
  PRIMARY KEY (`ID_CC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguon_cc`
--

LOCK TABLES `nguon_cc` WRITE;
/*!40000 ALTER TABLE `nguon_cc` DISABLE KEYS */;
/*!40000 ALTER TABLE `nguon_cc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhan_vien` (
  `ID_NV` int NOT NULL,
  `Ten_NV` varchar(100) NOT NULL,
  `SDT` varchar(100) NOT NULL,
  `CCCD` varchar(100) NOT NULL,
  `Ngay_Sinh` date NOT NULL,
  `Hinh_Anh` longblob,
  PRIMARY KEY (`ID_NV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_kiem_ke_kv`
--

DROP TABLE IF EXISTS `phieu_kiem_ke_kv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_kiem_ke_kv` (
  `ID_Kiem_Ke` int NOT NULL,
  `So_Luong_Hao_Mon` int NOT NULL,
  `Thoi_Gian_Kiem` date NOT NULL,
  `ID_NV` int NOT NULL,
  `ID_KV` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_Kiem_Ke`),
  KEY `FK1_Phieu_Kiem_Ke_KV_idx` (`ID_NV`),
  KEY `FK2_Phieu_Kiem_Ke_KV_idx` (`ID_KV`),
  CONSTRAINT `FK1_Phieu_Kiem_Ke_KV` FOREIGN KEY (`ID_NV`) REFERENCES `nhan_vien` (`ID_NV`),
  CONSTRAINT `FK2_Phieu_Kiem_Ke_KV` FOREIGN KEY (`ID_KV`) REFERENCES `khu_vuc` (`ID_KV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_kiem_ke_kv`
--

LOCK TABLES `phieu_kiem_ke_kv` WRITE;
/*!40000 ALTER TABLE `phieu_kiem_ke_kv` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieu_kiem_ke_kv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_nhap`
--

DROP TABLE IF EXISTS `phieu_nhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_nhap` (
  `ID_Phieu_Nhap` int NOT NULL,
  `Thoi_Gian` varchar(100) NOT NULL,
  `ID_NV` int NOT NULL,
  `ID_CC` int NOT NULL,
  `So_Luong_Lo` int NOT NULL,
  PRIMARY KEY (`ID_Phieu_Nhap`),
  KEY `FK1_Phieu_Nhap_idx` (`ID_NV`),
  KEY `FK2_Phieu_Nhap_idx` (`ID_CC`),
  CONSTRAINT `FK1_Phieu_Nhap` FOREIGN KEY (`ID_NV`) REFERENCES `nhan_vien` (`ID_NV`),
  CONSTRAINT `FK2_Phieu_Nhap` FOREIGN KEY (`ID_CC`) REFERENCES `nguon_cc` (`ID_CC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_nhap`
--

LOCK TABLES `phieu_nhap` WRITE;
/*!40000 ALTER TABLE `phieu_nhap` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieu_nhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_tra_hang`
--

DROP TABLE IF EXISTS `phieu_tra_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_tra_hang` (
  `ID_Tra` int NOT NULL,
  `Thoi_Gian_Tra` date NOT NULL,
  `Mo_Ta` varchar(100) NOT NULL,
  `ID_NV` int NOT NULL,
  `ID_Lo` int NOT NULL,
  PRIMARY KEY (`ID_Tra`),
  KEY `FK1_Phieu_Tra_Hang_idx` (`ID_NV`),
  KEY `FK2_Phieu_Tra_Hang_idx` (`ID_Lo`),
  CONSTRAINT `FK1_Phieu_Tra_Hang` FOREIGN KEY (`ID_NV`) REFERENCES `nhan_vien` (`ID_NV`),
  CONSTRAINT `FK2_Phieu_Tra_Hang` FOREIGN KEY (`ID_Lo`) REFERENCES `lo_san_pham` (`ID_Lo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_tra_hang`
--

LOCK TABLES `phieu_tra_hang` WRITE;
/*!40000 ALTER TABLE `phieu_tra_hang` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieu_tra_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_xuat_kho`
--

DROP TABLE IF EXISTS `phieu_xuat_kho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_xuat_kho` (
  `ID_Phieu_Xuat` int NOT NULL,
  `Thoi_Gian_Xuat` date NOT NULL,
  `ID_Lo` int NOT NULL,
  `ID_NV` int NOT NULL,
  PRIMARY KEY (`ID_Phieu_Xuat`),
  KEY `FK1_Phieu_Xuat_Kho_idx` (`ID_Lo`),
  KEY `FK2_Phieu_Xuat_Kho_idx` (`ID_NV`),
  CONSTRAINT `FK1_Phieu_Xuat_Kho` FOREIGN KEY (`ID_Lo`) REFERENCES `lo_san_pham` (`ID_Lo`),
  CONSTRAINT `FK2_Phieu_Xuat_Kho` FOREIGN KEY (`ID_NV`) REFERENCES `nhan_vien` (`ID_NV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_xuat_kho`
--

LOCK TABLES `phieu_xuat_kho` WRITE;
/*!40000 ALTER TABLE `phieu_xuat_kho` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieu_xuat_kho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `san_pham`
--

DROP TABLE IF EXISTS `san_pham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `san_pham` (
  `ID_SP` int NOT NULL,
  `Ten_SP` varchar(100) NOT NULL,
  `Hinh_Anh` varchar(100) DEFAULT NULL,
  `ID_Loai_SP` int NOT NULL,
  PRIMARY KEY (`ID_SP`),
  KEY `FK1_SP_idx` (`ID_Loai_SP`),
  CONSTRAINT `FK1_SP` FOREIGN KEY (`ID_Loai_SP`) REFERENCES `loai_san_pham` (`ID_Loai_SP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `san_pham`
--

LOCK TABLES `san_pham` WRITE;
/*!40000 ALTER TABLE `san_pham` DISABLE KEYS */;
/*!40000 ALTER TABLE `san_pham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tai_khoan`
--

DROP TABLE IF EXISTS `tai_khoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan` (
  `ID_TK` int NOT NULL,
  `Ten_TK` varchar(100) NOT NULL,
  `Mat_Khau` varchar(100) NOT NULL,
  `ID_NV` int NOT NULL,
  `Loai_TK` int NOT NULL,
  PRIMARY KEY (`ID_TK`),
  KEY `FK1_idx` (`ID_NV`),
  CONSTRAINT `FK1_TK` FOREIGN KEY (`ID_NV`) REFERENCES `nhan_vien` (`ID_NV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan`
--

LOCK TABLES `tai_khoan` WRITE;
/*!40000 ALTER TABLE `tai_khoan` DISABLE KEYS */;
/*!40000 ALTER TABLE `tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-29 16:53:49
