-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: myprojv1
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Dumping data for table `board_detail`
--

LOCK TABLES `board_detail` WRITE;
/*!40000 ALTER TABLE `board_detail` DISABLE KEYS */;
INSERT INTO `board_detail` VALUES (1,'124124214','2017305056','<p>안녕하세요~ test 중입니다.</p>\r\n','2023-09-13 02:26:04','87401353-cd81-43e9-802a-e2b52909b99e.pdf',5,1),(2,'test','2017305056','<p>really?</p>\r\n','2023-09-15 23:25:45',NULL,5,1),(3,'test q&a','2017305056','<p>testetset</p>\r\n','2023-09-17 23:52:35','c75ace72-315a-493a-84bc-b49cb97704c2.jpg',6,1),(4,'test2','2017305056','<p>asdfsdfsd</p>\r\n','2023-09-17 23:53:28',NULL,6,1),(5,'tetst3','201730533','<p>rwawerqrwqr</p>\r\n','2023-09-17 23:58:44',NULL,6,1),(6,'hello new test','201730533','<p>hello evety one</p>\r\n','2023-09-21 01:43:36','95736a70-b098-42af-946b-f4df82ea6f5c.jpg',5,1),(7,'test info','2017305056','<p>ffds</p>\r\n','2023-10-02 15:09:54','1cc26fb3-abee-432a-ab54-8ba13e2a5686.pdf',2,1);
/*!40000 ALTER TABLE `board_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `board_type`
--

LOCK TABLES `board_type` WRITE;
/*!40000 ALTER TABLE `board_type` DISABLE KEYS */;
INSERT INTO `board_type` VALUES (1,'공지사항'),(2,'Q&A 게시판'),(3,'수업자료'),(4,'\"수업 보조 자료\"');
/*!40000 ALTER TABLE `board_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category_type`
--

LOCK TABLES `category_type` WRITE;
/*!40000 ALTER TABLE `category_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `class_board_type`
--

LOCK TABLES `class_board_type` WRITE;
/*!40000 ALTER TABLE `class_board_type` DISABLE KEYS */;
INSERT INTO `class_board_type` VALUES (2,1,19,'N'),(3,2,19,'N'),(4,3,19,'Y'),(5,1,8,'N'),(6,2,8,'N'),(8,1,28,'N'),(10,2,20,'Y'),(12,1,20,'N'),(13,3,8,'N');
/*!40000 ALTER TABLE `class_board_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `class_code`
--

LOCK TABLES `class_code` WRITE;
/*!40000 ALTER TABLE `class_code` DISABLE KEYS */;
INSERT INTO `class_code` VALUES (8,'임베디드','202301','N'),(13,'12312','202301','N'),(19,'컴구','202301','N'),(20,'딥러닝','202301','N'),(28,'test15','202301','N');
/*!40000 ALTER TABLE `class_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `class_member`
--

LOCK TABLES `class_member` WRITE;
/*!40000 ALTER TABLE `class_member` DISABLE KEYS */;
INSERT INTO `class_member` VALUES ('2017305056','test@a.com','1234','lsw','01012345678','kyo',2,'2023-08-26 00:29:30'),('201730533','abc@test.com','1234','asdf','123453',NULL,2,'2023-09-17 01:17:14'),('admin','test','1234','lsw','123','1',1,'2023-08-22 00:00:00'),('test100','testuser100@test.com','1234','testuser100',NULL,NULL,2,'2023-08-26 16:10:37'),('test101','testuser101@test.com','1234','testuser101',NULL,NULL,2,'2023-08-26 16:10:37'),('test102','testuser102@test.com','1234','testuser102',NULL,NULL,2,'2023-08-26 16:10:37'),('test103','testuser103@test.com','1234','testuser103',NULL,NULL,2,'2023-08-26 16:10:37'),('test104','testuser104@test.com','1234','testuser104',NULL,NULL,2,'2023-08-26 16:10:37'),('test105','testuser105@test.com','1234','testuser105',NULL,NULL,2,'2023-08-26 16:10:37'),('test106','testuser106@test.com','1234','testuser106',NULL,NULL,2,'2023-08-26 16:10:37'),('test107','testuser107@test.com','1234','testuser107',NULL,NULL,2,'2023-08-26 16:10:37'),('test108','testuser108@test.com','1234','testuser108',NULL,NULL,2,'2023-08-26 16:10:37'),('test109','testuser109@test.com','1234','testuser109',NULL,NULL,2,'2023-08-26 16:10:37'),('test110','testuser110@test.com','1234','testuser110',NULL,NULL,2,'2023-08-26 16:10:37'),('test111','testuser111@test.com','1234','testuser111',NULL,NULL,2,'2023-08-26 16:10:37'),('test112','testuser112@test.com','1234','testuser112',NULL,NULL,2,'2023-08-26 16:10:37'),('test113','testuser113@test.com','1234','testuser113',NULL,NULL,2,'2023-08-26 16:10:37'),('test114','testuser114@test.com','1234','testuser114',NULL,NULL,2,'2023-08-26 16:10:37'),('test115','testuser115@test.com','1234','testuser115',NULL,NULL,2,'2023-08-26 16:10:37'),('test116','testuser116@test.com','1234','testuser116',NULL,NULL,2,'2023-08-26 16:10:37'),('test117','testuser117@test.com','1234','testuser117',NULL,NULL,2,'2023-08-26 16:10:37'),('test118','testuser118@test.com','1234','testuser118',NULL,NULL,2,'2023-08-26 16:10:37'),('test119','testuser119@test.com','1234','testuser119',NULL,NULL,2,'2023-08-26 16:10:37'),('test120','testuser120@test.com','1234','testuser120',NULL,NULL,2,'2023-08-26 16:10:37'),('test121','testuser121@test.com','1234','testuser121',NULL,NULL,2,'2023-08-26 16:10:37'),('test122','testuser122@test.com','1234','testuser122',NULL,NULL,2,'2023-08-26 16:10:37'),('test123','testuser123@test.com','1234','testuser123',NULL,NULL,2,'2023-08-26 16:10:37'),('test124','testuser124@test.com','1234','testuser124',NULL,NULL,2,'2023-08-26 16:10:37'),('test125','testuser125@test.com','1234','testuser125',NULL,NULL,2,'2023-08-26 16:10:37'),('test126','testuser126@test.com','1234','testuser126',NULL,NULL,2,'2023-08-26 16:10:37'),('test127','testuser127@test.com','1234','testuser127',NULL,NULL,2,'2023-08-26 16:10:37'),('test128','testuser128@test.com','1234','testuser128',NULL,NULL,2,'2023-08-26 16:10:37'),('test129','testuser129@test.com','1234','testuser129',NULL,NULL,2,'2023-08-26 16:10:37'),('test130','testuser130@test.com','1234','testuser130',NULL,NULL,2,'2023-08-26 16:10:37'),('test131','testuser131@test.com','1234','testuser131',NULL,NULL,2,'2023-08-26 16:10:37'),('test132','testuser132@test.com','1234','testuser132',NULL,NULL,2,'2023-08-26 16:10:37'),('test133','testuser133@test.com','1234','testuser133',NULL,NULL,2,'2023-08-26 16:10:37'),('test134','testuser134@test.com','1234','testuser134',NULL,NULL,2,'2023-08-26 16:10:37'),('test135','testuser135@test.com','1234','testuser135',NULL,NULL,2,'2023-08-26 16:10:37'),('test136','testuser136@test.com','1234','testuser136',NULL,NULL,2,'2023-08-26 16:10:37'),('test137','testuser137@test.com','1234','testuser137',NULL,NULL,2,'2023-08-26 16:10:37'),('test138','testuser138@test.com','1234','testuser138',NULL,NULL,2,'2023-08-26 16:10:37'),('test139','testuser139@test.com','1234','testuser139',NULL,NULL,2,'2023-08-26 16:10:37'),('test140','testuser140@test.com','1234','testuser140',NULL,NULL,2,'2023-08-26 16:10:37'),('test141','testuser141@test.com','1234','testuser141',NULL,NULL,2,'2023-08-26 16:10:37'),('test142','testuser142@test.com','1234','testuser142',NULL,NULL,2,'2023-08-26 16:10:37'),('test143','testuser143@test.com','1234','testuser143',NULL,NULL,2,'2023-08-26 16:10:37'),('test144','testuser144@test.com','1234','testuser144',NULL,NULL,2,'2023-08-26 16:10:37'),('test145','testuser145@test.com','1234','testuser145',NULL,NULL,2,'2023-08-26 16:10:37'),('test146','testuser146@test.com','1234','testuser146',NULL,NULL,2,'2023-08-26 16:10:37'),('test147','testuser147@test.com','1234','testuser147',NULL,NULL,2,'2023-08-26 16:10:37'),('test148','testuser148@test.com','1234','testuser148',NULL,NULL,2,'2023-08-26 16:10:37'),('test149','testuser149@test.com','1234','testuser149',NULL,NULL,2,'2023-08-26 16:10:37'),('test150','testuser150@test.com','1234','testuser150',NULL,NULL,2,'2023-08-26 16:10:37'),('test151','testuser151@test.com','1234','testuser151',NULL,NULL,2,'2023-08-26 16:10:37'),('test152','testuser152@test.com','1234','testuser152',NULL,NULL,2,'2023-08-26 16:10:37'),('test153','testuser153@test.com','1234','testuser153',NULL,NULL,2,'2023-08-26 16:10:37'),('test154','testuser154@test.com','1234','testuser154',NULL,NULL,2,'2023-08-26 16:10:37'),('test155','testuser155@test.com','1234','testuser155',NULL,NULL,2,'2023-08-26 16:10:37'),('test156','testuser156@test.com','1234','testuser156',NULL,NULL,2,'2023-08-26 16:10:37'),('test157','testuser157@test.com','1234','testuser157',NULL,NULL,2,'2023-08-26 16:10:37'),('test158','testuser158@test.com','1234','testuser158',NULL,NULL,2,'2023-08-26 16:10:37'),('test159','testuser159@test.com','1234','testuser159',NULL,NULL,2,'2023-08-26 16:10:37'),('test160','testuser160@test.com','1234','testuser160',NULL,NULL,2,'2023-08-26 16:10:37'),('test161','testuser161@test.com','1234','testuser161',NULL,NULL,2,'2023-08-26 16:10:37'),('test162','testuser162@test.com','1234','testuser162',NULL,NULL,2,'2023-08-26 16:10:37'),('test163','testuser163@test.com','1234','testuser163',NULL,NULL,2,'2023-08-26 16:10:37'),('test164','testuser164@test.com','1234','testuser164',NULL,NULL,2,'2023-08-26 16:10:37'),('test165','testuser165@test.com','1234','testuser165',NULL,NULL,2,'2023-08-26 16:10:37'),('test166','testuser166@test.com','1234','testuser166',NULL,NULL,2,'2023-08-26 16:10:37'),('test167','testuser167@test.com','1234','testuser167',NULL,NULL,2,'2023-08-26 16:10:37'),('test168','testuser168@test.com','1234','testuser168',NULL,NULL,2,'2023-08-26 16:10:37'),('test169','testuser169@test.com','1234','testuser169',NULL,NULL,2,'2023-08-26 16:10:37'),('test170','testuser170@test.com','1234','testuser170',NULL,NULL,2,'2023-08-26 16:10:37'),('test171','testuser171@test.com','1234','testuser171',NULL,NULL,2,'2023-08-26 16:10:37'),('test172','testuser172@test.com','1234','testuser172',NULL,NULL,2,'2023-08-26 16:10:37'),('test173','testuser173@test.com','1234','testuser173',NULL,NULL,2,'2023-08-26 16:10:37'),('test174','testuser174@test.com','1234','testuser174',NULL,NULL,2,'2023-08-26 16:10:37'),('test175','testuser175@test.com','1234','testuser175',NULL,NULL,2,'2023-08-26 16:10:37'),('test176','testuser176@test.com','1234','testuser176',NULL,NULL,2,'2023-08-26 16:10:37'),('test177','testuser177@test.com','1234','testuser177',NULL,NULL,2,'2023-08-26 16:10:37'),('test178','testuser178@test.com','1234','testuser178',NULL,NULL,2,'2023-08-26 16:10:37'),('test179','testuser179@test.com','1234','testuser179',NULL,NULL,2,'2023-08-26 16:10:37'),('test180','testuser180@test.com','1234','testuser180',NULL,NULL,2,'2023-08-26 16:10:37'),('test181','testuser181@test.com','1234','testuser181',NULL,NULL,2,'2023-08-26 16:10:37'),('test182','testuser182@test.com','1234','testuser182',NULL,NULL,2,'2023-08-26 16:10:37'),('test183','testuser183@test.com','1234','testuser183',NULL,NULL,2,'2023-08-26 16:10:37'),('test184','testuser184@test.com','1234','testuser184',NULL,NULL,2,'2023-08-26 16:10:37'),('test185','testuser185@test.com','1234','testuser185',NULL,NULL,2,'2023-08-26 16:10:37'),('test186','testuser186@test.com','1234','testuser186',NULL,NULL,2,'2023-08-26 16:10:37'),('test187','testuser187@test.com','1234','testuser187',NULL,NULL,2,'2023-08-26 16:10:37'),('test188','testuser188@test.com','1234','testuser188',NULL,NULL,2,'2023-08-26 16:10:37'),('test189','testuser189@test.com','1234','testuser189',NULL,NULL,2,'2023-08-26 16:10:37'),('test190','testuser190@test.com','1234','testuser190',NULL,NULL,2,'2023-08-26 16:10:37'),('test191','testuser191@test.com','1234','testuser191',NULL,NULL,2,'2023-08-26 16:10:37'),('test192','testuser192@test.com','1234','testuser192',NULL,NULL,2,'2023-08-26 16:10:37'),('test193','testuser193@test.com','1234','testuser193',NULL,NULL,2,'2023-08-26 16:10:37'),('test194','testuser194@test.com','1234','testuser194',NULL,NULL,2,'2023-08-26 16:10:37'),('test195','testuser195@test.com','1234','testuser195',NULL,NULL,2,'2023-08-26 16:10:37'),('test196','testuser196@test.com','1234','testuser196',NULL,NULL,2,'2023-08-26 16:10:37'),('test197','testuser197@test.com','1234','testuser197',NULL,NULL,2,'2023-08-26 16:10:37'),('test198','testuser198@test.com','1234','testuser198',NULL,NULL,2,'2023-08-26 16:10:37'),('test199','testuser199@test.com','1234','testuser199',NULL,NULL,2,'2023-08-26 16:10:37'),('test200','testuser200@test.com','1234','testuser200',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser16','testuser16@test.com','1234','testuser16',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser17','testuser17@test.com','1234','testuser17',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser18','testuser18@test.com','1234','testuser18',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser19','testuser19@test.com','1234','testuser19',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser20','testuser20@test.com','1234','testuser20',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser21','testuser21@test.com','1234','testuser21',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser22','testuser22@test.com','1234','testuser22',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser23','testuser23@test.com','1234','testuser23',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser24','testuser24@test.com','1234','testuser24',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser25','testuser25@test.com','1234','testuser25',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser26','testuser26@test.com','1234','testuser26',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser27','testuser27@test.com','1234','testuser27',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser28','testuser28@test.com','1234','testuser28',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser29','testuser29@test.com','1234','testuser29',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser30','testuser30@test.com','1234','testuser30',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser31','testuser31@test.com','1234','testuser31',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser32','testuser32@test.com','1234','testuser32',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser33','testuser33@test.com','1234','testuser33',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser34','testuser34@test.com','1234','testuser34',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser35','testuser35@test.com','1234','testuser35',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser36','testuser36@test.com','1234','testuser36',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser37','testuser37@test.com','1234','testuser37',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser38','testuser38@test.com','1234','testuser38',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser39','testuser39@test.com','1234','testuser39',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser40','testuser40@test.com','1234','testuser40',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser41','testuser41@test.com','1234','testuser41',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser42','testuser42@test.com','1234','testuser42',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser43','testuser43@test.com','1234','testuser43',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser44','testuser44@test.com','1234','testuser44',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser45','testuser45@test.com','1234','testuser45',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser46','testuser46@test.com','1234','testuser46',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser47','testuser47@test.com','1234','testuser47',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser48','testuser48@test.com','1234','testuser48',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser49','testuser49@test.com','1234','testuser49',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser50','testuser50@test.com','1234','testuser50',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser51','testuser51@test.com','1234','testuser51',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser52','testuser52@test.com','1234','testuser52',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser53','testuser53@test.com','1234','testuser53',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser54','testuser54@test.com','1234','testuser54',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser55','testuser55@test.com','1234','testuser55',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser56','testuser56@test.com','1234','testuser56',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser57','testuser57@test.com','1234','testuser57',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser58','testuser58@test.com','1234','testuser58',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser59','testuser59@test.com','1234','testuser59',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser60','testuser60@test.com','1234','testuser60',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser61','testuser61@test.com','1234','testuser61',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser62','testuser62@test.com','1234','testuser62',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser63','testuser63@test.com','1234','testuser63',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser64','testuser64@test.com','1234','testuser64',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser65','testuser65@test.com','1234','testuser65',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser66','testuser66@test.com','1234','testuser66',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser67','testuser67@test.com','1234','testuser67',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser68','testuser68@test.com','1234','testuser68',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser69','testuser69@test.com','1234','testuser69',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser70','testuser70@test.com','1234','testuser70',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser71','testuser71@test.com','1234','testuser71',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser72','testuser72@test.com','1234','testuser72',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser73','testuser73@test.com','1234','testuser73',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser74','testuser74@test.com','1234','testuser74',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser75','testuser75@test.com','1234','testuser75',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser76','testuser76@test.com','1234','testuser76',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser77','testuser77@test.com','1234','testuser77',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser78','testuser78@test.com','1234','testuser78',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser79','testuser79@test.com','1234','testuser79',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser80','testuser80@test.com','1234','testuser80',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser81','testuser81@test.com','1234','testuser81',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser82','testuser82@test.com','1234','testuser82',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser83','testuser83@test.com','1234','testuser83',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser84','testuser84@test.com','1234','testuser84',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser85','testuser85@test.com','1234','testuser85',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser86','testuser86@test.com','1234','testuser86',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser87','testuser87@test.com','1234','testuser87',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser88','testuser88@test.com','1234','testuser88',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser89','testuser89@test.com','1234','testuser89',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser90','testuser90@test.com','1234','testuser90',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser91','testuser91@test.com','1234','testuser91',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser92','testuser92@test.com','1234','testuser92',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser93','testuser93@test.com','1234','testuser93',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser94','testuser94@test.com','1234','testuser94',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser95','testuser95@test.com','1234','testuser95',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser96','testuser96@test.com','1234','testuser96',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser97','testuser97@test.com','1234','testuser97',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser98','testuser98@test.com','1234','testuser98',NULL,NULL,2,'2023-08-26 16:10:37'),('testuser99','testuser99@test.com','1234','testuser99',NULL,NULL,2,'2023-08-26 16:10:37');
/*!40000 ALTER TABLE `class_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'test','2023-09-17 23:32:43',1,1,'2017305056'),(2,'ok thank you','2023-09-18 00:03:36',1,1,'201730533'),(4,'hi hi update test','2023-09-21 01:42:39',1,1,'201730533');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_registration`
--

LOCK TABLES `course_registration` WRITE;
/*!40000 ALTER TABLE `course_registration` DISABLE KEYS */;
INSERT INTO `course_registration` VALUES (5,'2017305056',19),(6,'201730533',8),(7,'201730533',20),(8,'2017305056',8);
/*!40000 ALTER TABLE `course_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `grade_code`
--

LOCK TABLES `grade_code` WRITE;
/*!40000 ALTER TABLE `grade_code` DISABLE KEYS */;
INSERT INTO `grade_code` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `grade_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` VALUES (1,'ALL'),(2,'BASIC');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'ALL'),(2,'BASIC');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'test@a.com','1234','lsw','','','lsw',1,1),(17,'testuser1@test.com','1234','testuser1',NULL,NULL,'testuser1',2,1),(18,'testuser2@test.com','1234','testuser2',NULL,NULL,'testuser2',2,1),(19,'testuser3@test.com','1234','testuser3',NULL,NULL,'testuser3',2,1),(20,'testuser4@test.com','1234','testuser4',NULL,NULL,'testuser4',2,1),(21,'testuser5@test.com','1234','testuser5',NULL,NULL,'testuser5',2,1),(22,'testuser6@test.com','1234','testuser6',NULL,NULL,'testuser6',2,1),(23,'testuser7@test.com','1234','testuser7',NULL,NULL,'testuser7',2,1),(24,'testuser8@test.com','1234','testuser8',NULL,NULL,'testuser8',2,1),(25,'testuser9@test.com','1234','testuser9',NULL,NULL,'testuser9',2,1),(26,'testuser10@test.com','1234','testuser10',NULL,NULL,'testuser10',2,1),(27,'testuser11@test.com','1234','testuser11',NULL,NULL,'testuser11',2,1),(28,'testuser12@test.com','1234','testuser12',NULL,NULL,'testuser12',2,1),(29,'testuser13@test.com','1234','testuser13',NULL,NULL,'testuser13',2,1),(30,'testuser14@test.com','1234','testuser14',NULL,NULL,'testuser14',2,1),(31,'testuser15@test.com','1234','testuser15',NULL,NULL,'testuser15',2,1),(32,'testuser16@test.com','1234','testuser16',NULL,NULL,'testuser16',2,1),(33,'testuser17@test.com','1234','testuser17',NULL,NULL,'testuser17',2,1),(34,'testuser18@test.com','1234','testuser18',NULL,NULL,'testuser18',2,1),(35,'testuser19@test.com','1234','testuser19',NULL,NULL,'testuser19',2,1),(36,'testuser20@test.com','1234','testuser20',NULL,NULL,'testuser20',2,1),(37,'testuser21@test.com','1234','testuser21',NULL,NULL,'testuser21',2,1),(38,'testuser22@test.com','1234','testuser22',NULL,NULL,'testuser22',2,1),(39,'testuser23@test.com','1234','testuser23',NULL,NULL,'testuser23',2,1),(40,'testuser24@test.com','1234','testuser24',NULL,NULL,'testuser24',2,1),(41,'testuser25@test.com','1234','testuser25',NULL,NULL,'testuser25',2,1),(42,'testuser26@test.com','1234','testuser26',NULL,NULL,'testuser26',2,1),(43,'testuser27@test.com','1234','testuser27',NULL,NULL,'testuser27',2,1),(44,'testuser28@test.com','1234','testuser28',NULL,NULL,'testuser28',2,1),(45,'testuser29@test.com','1234','testuser29',NULL,NULL,'testuser29',2,1),(46,'testuser30@test.com','1234','testuser30',NULL,NULL,'testuser30',2,1),(47,'testuser31@test.com','1234','testuser31',NULL,NULL,'testuser31',2,1),(48,'testuser32@test.com','1234','testuser32',NULL,NULL,'testuser32',2,1),(49,'testuser33@test.com','1234','testuser33',NULL,NULL,'testuser33',2,1),(50,'testuser34@test.com','1234','testuser34',NULL,NULL,'testuser34',2,1),(51,'testuser35@test.com','1234','testuser35',NULL,NULL,'testuser35',2,1),(52,'testuser36@test.com','1234','testuser36',NULL,NULL,'testuser36',2,1),(53,'testuser37@test.com','1234','testuser37',NULL,NULL,'testuser37',2,1),(54,'testuser38@test.com','1234','testuser38',NULL,NULL,'testuser38',2,1),(55,'testuser39@test.com','1234','testuser39',NULL,NULL,'testuser39',2,1),(56,'testuser40@test.com','1234','testuser40',NULL,NULL,'testuser40',2,1),(57,'testuser41@test.com','1234','testuser41',NULL,NULL,'testuser41',2,1),(58,'testuser42@test.com','1234','testuser42',NULL,NULL,'testuser42',2,1),(59,'testuser43@test.com','1234','testuser43',NULL,NULL,'testuser43',2,1),(60,'testuser44@test.com','1234','testuser44',NULL,NULL,'testuser44',2,1),(61,'testuser45@test.com','1234','testuser45',NULL,NULL,'testuser45',2,1),(62,'testuser46@test.com','1234','testuser46',NULL,NULL,'testuser46',2,1),(63,'testuser47@test.com','1234','testuser47',NULL,NULL,'testuser47',2,1),(64,'testuser48@test.com','1234','testuser48',NULL,NULL,'testuser48',2,1),(65,'testuser49@test.com','1234','testuser49',NULL,NULL,'testuser49',2,1),(66,'testuser50@test.com','1234','testuser50',NULL,NULL,'testuser50',2,1),(67,'testuser51@test.com','1234','testuser51',NULL,NULL,'testuser51',2,1),(68,'testuser52@test.com','1234','testuser52',NULL,NULL,'testuser52',2,1),(69,'testuser53@test.com','1234','testuser53',NULL,NULL,'testuser53',2,1),(70,'testuser54@test.com','1234','testuser54',NULL,NULL,'testuser54',2,1),(71,'testuser55@test.com','1234','testuser55',NULL,NULL,'testuser55',2,1),(72,'testuser56@test.com','1234','testuser56',NULL,NULL,'testuser56',2,1),(73,'testuser57@test.com','1234','testuser57',NULL,NULL,'testuser57',2,1),(74,'testuser58@test.com','1234','testuser58',NULL,NULL,'testuser58',2,1),(75,'testuser59@test.com','1234','testuser59',NULL,NULL,'testuser59',2,1),(76,'testuser60@test.com','1234','testuser60',NULL,NULL,'testuser60',2,1),(77,'testuser61@test.com','1234','testuser61',NULL,NULL,'testuser61',2,1),(78,'testuser62@test.com','1234','testuser62',NULL,NULL,'testuser62',2,1),(79,'testuser63@test.com','1234','testuser63',NULL,NULL,'testuser63',2,1),(80,'testuser64@test.com','1234','testuser64',NULL,NULL,'testuser64',2,1),(81,'testuser65@test.com','1234','testuser65',NULL,NULL,'testuser65',2,1),(82,'testuser66@test.com','1234','testuser66',NULL,NULL,'testuser66',2,1),(83,'testuser67@test.com','1234','testuser67',NULL,NULL,'testuser67',2,1),(84,'testuser68@test.com','1234','testuser68',NULL,NULL,'testuser68',2,1),(85,'testuser69@test.com','1234','testuser69',NULL,NULL,'testuser69',2,1),(86,'testuser70@test.com','1234','testuser70',NULL,NULL,'testuser70',2,1),(87,'testuser71@test.com','1234','testuser71',NULL,NULL,'testuser71',2,1),(88,'testuser72@test.com','1234','testuser72',NULL,NULL,'testuser72',2,1),(89,'testuser73@test.com','1234','testuser73',NULL,NULL,'testuser73',2,1),(90,'testuser74@test.com','1234','testuser74',NULL,NULL,'testuser74',2,1),(91,'testuser75@test.com','1234','testuser75',NULL,NULL,'testuser75',2,1),(92,'testuser76@test.com','1234','testuser76',NULL,NULL,'testuser76',2,1),(93,'testuser77@test.com','1234','testuser77',NULL,NULL,'testuser77',2,1),(94,'testuser78@test.com','1234','testuser78',NULL,NULL,'testuser78',2,1),(95,'testuser79@test.com','1234','testuser79',NULL,NULL,'testuser79',2,1),(96,'testuser80@test.com','1234','testuser80',NULL,NULL,'testuser80',2,1),(97,'testuser81@test.com','1234','testuser81',NULL,NULL,'testuser81',2,1),(98,'testuser82@test.com','1234','testuser82',NULL,NULL,'testuser82',2,1),(99,'testuser83@test.com','1234','testuser83',NULL,NULL,'testuser83',2,1),(100,'testuser84@test.com','1234','testuser84',NULL,NULL,'testuser84',2,1),(101,'testuser85@test.com','1234','testuser85',NULL,NULL,'testuser85',2,1),(102,'testuser86@test.com','1234','testuser86',NULL,NULL,'testuser86',2,1),(103,'testuser87@test.com','1234','testuser87',NULL,NULL,'testuser87',2,1),(104,'testuser88@test.com','1234','testuser88',NULL,NULL,'testuser88',2,1),(105,'testuser89@test.com','1234','testuser89',NULL,NULL,'testuser89',2,1),(106,'testuser90@test.com','1234','testuser90',NULL,NULL,'testuser90',2,1),(107,'testuser91@test.com','1234','testuser91',NULL,NULL,'testuser91',2,1),(108,'testuser92@test.com','1234','testuser92',NULL,NULL,'testuser92',2,1),(109,'testuser93@test.com','1234','testuser93',NULL,NULL,'testuser93',2,1),(110,'testuser94@test.com','1234','testuser94',NULL,NULL,'testuser94',2,1),(111,'testuser95@test.com','1234','testuser95',NULL,NULL,'testuser95',2,1),(112,'testuser96@test.com','1234','testuser96',NULL,NULL,'testuser96',2,1),(113,'testuser97@test.com','1234','testuser97',NULL,NULL,'testuser97',2,1),(114,'testuser98@test.com','1234','testuser98',NULL,NULL,'testuser98',2,1),(115,'testuser99@test.com','1234','testuser99',NULL,NULL,'testuser99',2,1),(116,'testuser100@test.com','1234','testuser100',NULL,NULL,'testuser100',2,1);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `restrict`
--

LOCK TABLES `restrict` WRITE;
/*!40000 ALTER TABLE `restrict` DISABLE KEYS */;
INSERT INTO `restrict` VALUES (1,17,'testuser1@test.com',2,1);
/*!40000 ALTER TABLE `restrict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `restrict_member`
--

LOCK TABLES `restrict_member` WRITE;
/*!40000 ALTER TABLE `restrict_member` DISABLE KEYS */;
INSERT INTO `restrict_member` VALUES (1,'2017305056',1);
/*!40000 ALTER TABLE `restrict_member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-02 17:37:46
