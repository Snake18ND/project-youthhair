-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: youthhairs
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('admin','admin'),('staff','staff');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `RoleId` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_authority_account_idx` (`Username`),
  KEY `FK_authority_role_idx` (`RoleId`),
  CONSTRAINT `FK_authority_account` FOREIGN KEY (`Username`) REFERENCES `accounts` (`Username`),
  CONSTRAINT `FK_authority_role` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'admin',1),(2,'staff',3);
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `CreateDate` date NOT NULL,
  `TotalPrice` float NOT NULL,
  `TimeBooking` varchar(45) NOT NULL,
  `Note` varchar(455) DEFAULT NULL,
  `StylistId` int NOT NULL,
  `StatusId` varchar(5) NOT NULL,
  `CustormerId` int NOT NULL,
  `VotingId` int DEFAULT NULL,
  `VoucherDetailsID` int DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_booking_statusbooking_idx` (`StatusId`),
  KEY `FK_booking_customer_idx` (`CustormerId`),
  KEY `FK_booking_voting_idx` (`VotingId`),
  KEY `FK_booking_voucher_idx` (`VoucherDetailsID`),
  KEY `FK_booking_stylist_idx` (`StylistId`),
  CONSTRAINT `FK_booking_customer` FOREIGN KEY (`CustormerId`) REFERENCES `customers` (`Id`),
  CONSTRAINT `FK_booking_statusbooking` FOREIGN KEY (`StatusId`) REFERENCES `statusbooking` (`Id`),
  CONSTRAINT `FK_booking_stylist` FOREIGN KEY (`StylistId`) REFERENCES `employees` (`Id`),
  CONSTRAINT `FK_booking_voting` FOREIGN KEY (`VotingId`) REFERENCES `voting` (`Id`),
  CONSTRAINT `FK_booking_voucher` FOREIGN KEY (`VoucherDetailsID`) REFERENCES `voucherdetail` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (32,'2021-12-21',430000,'15h00',NULL,1,'WFC',42,NULL,NULL),(33,'2021-12-21',130000,'15h00','2',3,'CAN',43,NULL,NULL),(34,'2021-12-21',330000,'17h30','cho em một cô em xin gái gội đầu',7,'CPM',44,2,NULL),(35,'2021-12-21',130000,'13h00',NULL,8,'CAN',37,NULL,NULL),(36,'2021-12-21',430000,'20h00','hihi',1,'WFP',45,NULL,NULL),(37,'2021-12-21',520000,'17h00','đặt lịch 5h đến nhé',1,'WFC',46,NULL,NULL),(38,'2021-12-23',400000,'17h00','huyhoang',1,'COM',47,NULL,NULL),(39,'2021-11-26',400000,'17h00',NULL,3,'CPM',9,2,NULL),(40,'2021-11-20',400000,'15h00',NULL,9,'CPM',11,3,NULL),(41,'2021-12-20',100000,'8h00',NULL,8,'CPM',16,3,NULL),(42,'2021-12-22',99999,'9h00','cắt nhanh giúp tôi',7,'CAN',48,NULL,NULL),(43,'2021-12-22',450000,'13h00',NULL,7,'CAN',49,NULL,NULL),(44,'2021-12-20',100000,'8h00',NULL,3,'CPM',25,NULL,NULL),(45,'2021-12-20',80000,'8h00',NULL,7,'CPM',29,2,NULL),(46,'2021-12-21',450000,'8h30',NULL,7,'IAT',50,NULL,NULL),(47,'2021-12-21',420000,'9h00',NULL,9,'IAT',51,NULL,NULL),(48,'2021-12-22',230000,'10h30',NULL,3,'UCF',52,NULL,NULL),(49,'2021-12-21',450000,'14h00','nhuộm cho em tóc nào đẹp trai',7,'WFC',37,NULL,NULL),(50,'2021-12-21',120000,'9h00',NULL,9,'WFC',53,NULL,NULL),(51,'2021-12-21',150000,'14h30',NULL,9,'WFC',54,NULL,NULL);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookingdetails`
--

DROP TABLE IF EXISTS `bookingdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookingdetails` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `BookingId` int NOT NULL,
  `ServiceId` int NOT NULL,
  `Price` float NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_BookingDetai_Service_idx` (`ServiceId`),
  KEY `FK_BookingDetai_Booking` (`BookingId`),
  CONSTRAINT `FK_BookingDetai_Booking` FOREIGN KEY (`BookingId`) REFERENCES `booking` (`Id`),
  CONSTRAINT `FK_BookingDetai_Service` FOREIGN KEY (`ServiceId`) REFERENCES `services` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookingdetails`
--

LOCK TABLES `bookingdetails` WRITE;
/*!40000 ALTER TABLE `bookingdetails` DISABLE KEYS */;
INSERT INTO `bookingdetails` VALUES (78,33,2,30000),(79,33,1,100000),(80,34,2,30000),(81,34,4,300000),(82,35,1,100000),(83,35,2,30000),(84,36,2,30000),(85,36,3,400000),(90,38,4,300000),(91,38,1,100000),(93,42,5,99999),(103,46,1,120000),(104,46,2,30000),(105,46,4,300000),(110,48,7,200000),(111,48,2,30000),(114,37,3,400000),(115,37,1,120000),(116,32,2,30000),(117,32,3,400000),(120,43,4,300000),(121,43,1,120000),(122,43,2,30000),(129,49,1,120000),(130,49,2,30000),(131,49,4,300000),(135,47,1,120000),(136,47,4,300000),(138,50,1,120000),(143,51,1,120000),(144,51,2,30000);
/*!40000 ALTER TABLE `bookingdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacts` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `FullName` varchar(45) NOT NULL,
  `Phone` varchar(11) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Status` tinyint NOT NULL,
  `CreateDate` date NOT NULL,
  `Note` varchar(455) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (3,'Nguyễn Doãn Mạnh Toàn','0123456789','nam@gmail.com',1,'2021-11-21','Ồ'),(4,'Nguyễn Văn Dũng','0987678912','thanh@gmail.com',0,'2021-11-21','thanh nek'),(5,'Vương Sỹ Thị Quỳnh','0123321123','phongdt@gmail.com',0,'2021-11-21','p'),(6,'Nguyễn Thị Thùy Trang','0999999998','da@gmail.com',1,'2021-11-20','da'),(7,'Trần Đại Nghĩa','0987678987','hpt@gmail.com',1,'2021-11-12','h'),(8,'Nguyễn Phương Hằng','0123456543','dlx@gmail.com',1,'2021-12-19','dl'),(10,'Đàm Vĩnh Hưng','0987654321','test@gmail.com',0,'2021-12-21','test note'),(13,'Nguyễn Thị Thủy  Tiên','0987654323','test3@gmail.com',0,'2021-12-21','notest3'),(15,'Lê Công Vinh','0987654322','test2@gmail.com',0,'2021-12-21','notest23'),(17,'Lê Thị Linh','0987654324','test4@gmail.com',0,'2021-11-21','notest4');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `FullName` varchar(45) NOT NULL,
  `Email` varchar(145) NOT NULL,
  `Phone` varchar(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (8,'Nguyễn Công Thành','test@gmail.com','0987654321'),(9,'Dương Xuân Pháp','test2@gmail.com','0987654322'),(10,'Dương Lan Hương','test3@gmail.com','0987654323'),(11,'Nguyễn Thị Thùy Trang','test4@gmail.com','0987654324'),(12,'Nguyễn Lê Hoàng','dmNccm@jsdg','0987652122'),(13,'Hoàng Quang Minh','dmNccm@jsdg','0987652123'),(14,'Nguyễn Minh Đức','dmNccm@jsdg','0987652124'),(15,'Viên Văn Thoại','dmNccm@jsdg','0987652125'),(16,'Nguyễn Ngọc Anh','dmuyt@jsdg','0987652126'),(22,'Nguyễn Hồng Gấm','hainvph11578@fpt.edu.vn','0123456'),(23,'Bùi Thị Hoàng','hainvph11578@fpt.edu.vn','05555555555'),(24,'Nguyễn Vũ Hồng Nhung','hai@gmail.com','031321113'),(25,'Trần Thị Hậu','admin@gmail.com','123'),(26,'Nguyễn Văn Đạt','dd@gaiiii','0123'),(27,'Nguyễn Trung kiên','haii123@haaaa','0321654'),(28,'Hoàng Thanh Bình','admin@gmail.com','036987125'),(29,'Nguyễn Thị Phượng','',''),(30,'Nguyễn Thị Mỹ Duyên','kimtinh324@gmail.com','0977116022'),(31,'Lê Thành Hưng','hainv578@gmail.com','0977111111'),(32,'Lê Đắc Tùng','kimtinh324@gmail.com','0911116022'),(33,'Vũ Văn Tuấn','buidao1705@gmail.com','0977116027'),(34,'Phùng Duy Anh','kimtinh324@gmail.com','0977116026'),(35,'Nguyễn Thành Nam','kimtinh324@gmail.com','0977116025'),(36,'Nguyễn Đăng Khoa','kimtinh324@gmail.com','0977116033'),(37,'Nguyễn Thành Nam','namnt@gmail.com','0344129025'),(38,'Nguyễn Thành Kiên','thanhnam692001@gmail.com','0358766782'),(39,'Thành Đại','thanhnam692001@gmail.com','0978399876'),(40,'Ngô Hải','hiango@gmail.com','0998877667'),(41,'Nam Nguyễn','namn@gmail.com','0987897654'),(42,'Huyền Phan','huyen123@gmail.com','0987656789'),(43,'Phùng Thanh Duy','duypt001@gmail.com','0378291089'),(44,'Hải Văn Trần','haivt1234@gmail.com','0323876584'),(45,'Nguyễn Văn Nữ','nuvanng321@gmail.com','0981235648'),(46,'Ngô Hoàng Hải','haingh2123@gmail.com','0983728172'),(47,'Hoàng Văn Huy','huyhoang12@gmail.com','0898328727'),(48,'Đặng Minh','minh@gmail.com','0987665276'),(49,'Nguyễn Nam Thành','namnt123@gmail.com','0344332211'),(50,'Ngô Văn Hải','hainv@gmial.com','0983718182'),(51,'Hoàng Văn Huy','huyhoang1@gmail.com','0982773829'),(52,'Hải Nguyễn','nguyenh@gmail.com','0927821718'),(53,'Nguyễn Thái Dương','duongnt2@gmail.com','0928718718'),(54,'Trình Quang Huy','huytq21@gmail.com','0928381719');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `dichvuhot`
--

DROP TABLE IF EXISTS `dichvuhot`;
/*!50001 DROP VIEW IF EXISTS `dichvuhot`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `dichvuhot` AS SELECT 
 1 AS `Id`,
 1 AS `ServiceName`,
 1 AS `Price`,
 1 AS `Status`,
 1 AS `Image`,
 1 AS `Note`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `FullName` varchar(45) NOT NULL,
  `Nickname` varchar(45) DEFAULT NULL,
  `Gender` tinyint NOT NULL,
  `Image` varchar(145) NOT NULL,
  `Phone` varchar(11) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Salary` int NOT NULL,
  `StartDate` date NOT NULL,
  `StatusWork` tinyint NOT NULL,
  `RolesId` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_Emloyee_Role_idx` (`RolesId`),
  CONSTRAINT `FK_Emloyee_Role` FOREIGN KEY (`RolesId`) REFERENCES `roles` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Nguyễn Công Thành','Thành Công',1,'2a5af3bb.jpg','0987654321','Hai@gmail.com',5000000,'2021-11-11',1,2),(2,'Nguyễn Thành Nam','Nam Barber',1,'9828a0a2.jpg','0987654321','Hai@gmail.com',5000000,'2021-11-11',1,2),(3,'Phan Thị Huyền','Huyền Phan',1,'e450c9b3.jpg','0987654321','Hai@gmail.com',5000000,'2021-11-11',1,2),(4,'Phùng Duy Anh','Danh Baber',0,'person_4.jpg','0987654321','Hai@gmail.com',5000000,'2021-11-11',0,3),(5,'Ngô Thị Hải',NULL,0,'a2dc0f53.jpg','0987654321','Haigay@gmail.com',1000000,'2021-11-11',1,4),(6,'Lê Xuân Dương',NULL,0,'person_6.jpg','0987654321','Hai@gmail.com',5000000,'2021-11-11',0,1),(7,'Đặng Thanh Phong','Thanh Phong',0,'5662d4a.jpg','0316495551','aaaa',5000000,'2021-12-12',1,2),(8,'Nguyễn Thị Thùy Trang','Trang Thuỳ',1,'person_1.jpg','0968585858','viuyt@gmail.coij',5000000,'2021-11-10',0,2),(9,'Ngô Văn Hải','Đạt 09',0,'89ee1356.jpg','0912122121','cu@gmail.com',5000000,'2021-11-10',1,2),(10,'Phùng Duy Anh',NULL,1,'cb4797ce.jpg','0987656785','Bắc Từ Liêm, Hà Nội',3500000,'2021-09-10',1,5);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `lienhetk`
--

DROP TABLE IF EXISTS `lienhetk`;
/*!50001 DROP VIEW IF EXISTS `lienhetk`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `lienhetk` AS SELECT 
 1 AS `monthYear`,
 1 AS `Phone`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Quản lý'),(2,'Thợ cắt tóc'),(3,'Lễ tân'),(4,'Nhân viên massage'),(5,'Bảo vệ');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `ServiceName` varchar(45) NOT NULL,
  `Price` float NOT NULL,
  `Status` tinyint NOT NULL,
  `Image` varchar(145) NOT NULL,
  `Note` varchar(455) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'Cắt tóc nam, tạo kiểu',120000,1,'1f8c5831.jpg','Được thực hiện bởi các stylist hàng đầu tại Salon Tùng Ken với các kiểu tóc thời thượng nhất'),(2,'Gội đầu, massage',30000,1,'385dd622.jpg','Đây là gói gội đầu cho những người vừa muốn được gội đầu thư giãn vừa muốn được giải cơ vai cổ gáy'),(3,'Uốn tóc',400000,1,'83927a6b.jpg','Dễ tạo kiểu, có thể uốn cho hầu hết mọi kiểu tóc, chất tóc dày mỏng khác nhau, thích hợp với nhiều khuôn mặt và đa số những kiểu tóc phổ thông.'),(4,'Nhuộm tóc',300000,1,'8b5d9ccd.jpg','Tóc nhuộm thì có màu thời trang và màu công sở tùy sự lựa chọn.'),(5,'Combo Noel',99999,0,'67b6da6f.png','Gồm cắt tóc, gội đầu, tư vấn tạo kiểu, sấy tóc vuốt vuốt các thứ các thứ'),(6,'Nối tóc',250000,1,'3f71a2dd.jpg','Salon chuyên nối tóc với những công nghệ và kỹ thuật mới nhất, hiện đại nhất.'),(7,'Phục hồi tóc',200000,1,'5dd2a54.jpg','Salon phục hồi tóc hư tổn nặng bằng Keratin và tế bào gốc. Mái tóc được phục hồi không những đảm bảo vẻ đẹp tự nhiên mà còn bóng và suôn mượt làm hài lòng bạn.');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shifts`
--

DROP TABLE IF EXISTS `shifts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shifts` (
  `Id` int NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shifts`
--

LOCK TABLES `shifts` WRITE;
/*!40000 ALTER TABLE `shifts` DISABLE KEYS */;
INSERT INTO `shifts` VALUES (1,'AM'),(2,'PM');
/*!40000 ALTER TABLE `shifts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statusbooking`
--

DROP TABLE IF EXISTS `statusbooking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statusbooking` (
  `Id` varchar(5) NOT NULL,
  `StatusName` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statusbooking`
--

LOCK TABLES `statusbooking` WRITE;
/*!40000 ALTER TABLE `statusbooking` DISABLE KEYS */;
INSERT INTO `statusbooking` VALUES ('CAN','Hủy đơn'),('COM','Đã Xác Nhận'),('CPM','Đã thanh toán'),('IAT','Đang cắt'),('UCF','Chưa xác nhận'),('WFC','Chờ cắt'),('WFP','Chờ thanh toán');
/*!40000 ALTER TABLE `statusbooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `thongbaoucf`
--

DROP TABLE IF EXISTS `thongbaoucf`;
/*!50001 DROP VIEW IF EXISTS `thongbaoucf`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `thongbaoucf` AS SELECT 
 1 AS `Id`,
 1 AS `CreateDate`,
 1 AS `TimeBooking`,
 1 AS `StylistId`,
 1 AS `CustormerId`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `thongkedt`
--

DROP TABLE IF EXISTS `thongkedt`;
/*!50001 DROP VIEW IF EXISTS `thongkedt`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `thongkedt` AS SELECT 
 1 AS `monthYear`,
 1 AS `doanhThu`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `thongkehd`
--

DROP TABLE IF EXISTS `thongkehd`;
/*!50001 DROP VIEW IF EXISTS `thongkehd`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `thongkehd` AS SELECT 
 1 AS `monthYear`,
 1 AS `StatusId`,
 1 AS `CustormerId`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `timebooking`
--

DROP TABLE IF EXISTS `timebooking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timebooking` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `shifts_Id` int NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `shifts_fk_idx` (`shifts_Id`),
  CONSTRAINT `timebooking_shifts_fk` FOREIGN KEY (`shifts_Id`) REFERENCES `shifts` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timebooking`
--

LOCK TABLES `timebooking` WRITE;
/*!40000 ALTER TABLE `timebooking` DISABLE KEYS */;
INSERT INTO `timebooking` VALUES (1,1,'8h00'),(2,1,'8h30'),(3,1,'9h00'),(4,1,'9h30'),(5,1,'10h00'),(6,1,'10h30'),(7,1,'11h00'),(8,1,'11h30'),(9,1,'13h00'),(10,1,'13h30'),(11,1,'14h00'),(12,1,'14h30'),(13,2,'15h00'),(14,2,'15h30'),(15,2,'16h00'),(16,2,'16h30'),(17,2,'17h00'),(18,2,'17h30'),(19,2,'18h00'),(20,2,'18h30'),(21,2,'19h00'),(22,2,'19h30'),(23,2,'20h00'),(24,2,'20h30');
/*!40000 ALTER TABLE `timebooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timebookingdetail`
--

DROP TABLE IF EXISTS `timebookingdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timebookingdetail` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `BookingId` int NOT NULL,
  `StylistId` int NOT NULL,
  `TimeBookingId` int NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timebookingdetail`
--

LOCK TABLES `timebookingdetail` WRITE;
/*!40000 ALTER TABLE `timebookingdetail` DISABLE KEYS */;
INSERT INTO `timebookingdetail` VALUES (22,33,3,12,'2021-12-22'),(23,33,3,13,'2021-12-22'),(24,33,3,14,'2021-12-22'),(25,34,7,17,'2021-12-21'),(26,34,7,18,'2021-12-21'),(27,34,7,19,'2021-12-21'),(28,35,8,8,'2021-12-21'),(29,35,8,9,'2021-12-21'),(30,35,8,10,'2021-12-21'),(31,36,1,22,'2021-12-21'),(32,36,1,23,'2021-12-21'),(33,36,1,24,'2021-12-21'),(40,38,1,16,'2021-12-23'),(41,38,1,17,'2021-12-23'),(42,38,1,18,'2021-12-23'),(51,46,3,1,'2021-12-21'),(52,46,3,2,'2021-12-21'),(53,46,3,3,'2021-12-21'),(57,48,3,5,'2021-12-22'),(58,48,3,6,'2021-12-22'),(59,48,3,7,'2021-12-22'),(66,47,9,4,'2021-12-21'),(67,47,9,5,'2021-12-21'),(68,47,9,6,'2021-12-21'),(69,50,9,2,'2021-12-21'),(70,50,9,3,'2021-12-21'),(71,50,9,4,'2021-12-21');
/*!40000 ALTER TABLE `timebookingdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voting`
--

DROP TABLE IF EXISTS `voting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voting` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voting`
--

LOCK TABLES `voting` WRITE;
/*!40000 ALTER TABLE `voting` DISABLE KEYS */;
INSERT INTO `voting` VALUES (1,'Không hài lòng'),(2,'Hài lòng'),(3,'Rất hài lòng');
/*!40000 ALTER TABLE `voting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voucherdetail`
--

DROP TABLE IF EXISTS `voucherdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voucherdetail` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `VoucherId` varchar(5) NOT NULL,
  `CustomerId` int NOT NULL,
  `Status` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `FK_VoucherDetail_Voucher_idx` (`VoucherId`),
  KEY `FK_VoucherDetail_Customer_idx` (`CustomerId`),
  CONSTRAINT `FK_VoucherDetail_Customer` FOREIGN KEY (`CustomerId`) REFERENCES `customers` (`Id`),
  CONSTRAINT `FK_VoucherDetail_Voucher` FOREIGN KEY (`VoucherId`) REFERENCES `vouchers` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voucherdetail`
--

LOCK TABLES `voucherdetail` WRITE;
/*!40000 ALTER TABLE `voucherdetail` DISABLE KEYS */;
INSERT INTO `voucherdetail` VALUES (8,'NAW',44,1),(9,'HUY',29,1);
/*!40000 ALTER TABLE `voucherdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vouchers`
--

DROP TABLE IF EXISTS `vouchers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vouchers` (
  `Id` varchar(5) NOT NULL,
  `Price` float NOT NULL,
  `Condition` float NOT NULL,
  `Note` varchar(455) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vouchers`
--

LOCK TABLES `vouchers` WRITE;
/*!40000 ALTER TABLE `vouchers` DISABLE KEYS */;
INSERT INTO `vouchers` VALUES ('HAI',10000,100000,'A'),('HAI1',10000,100000,'A'),('HAI2',10000,100000,'A'),('HUY',20000,50000,'B'),('NAM1',1000,800000,'H'),('NAM2',50000,10000,'D'),('NAW',30000,100000,'C');
/*!40000 ALTER TABLE `vouchers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workassign`
--

DROP TABLE IF EXISTS `workassign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workassign` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `employees_Id` int NOT NULL,
  `shifts_Id` int NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `employees_fk_idx` (`employees_Id`),
  KEY `shifts_fk_idx` (`shifts_Id`),
  CONSTRAINT `workassign_employees_fk` FOREIGN KEY (`employees_Id`) REFERENCES `employees` (`Id`),
  CONSTRAINT `workassign_shifts_fk` FOREIGN KEY (`shifts_Id`) REFERENCES `shifts` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workassign`
--

LOCK TABLES `workassign` WRITE;
/*!40000 ALTER TABLE `workassign` DISABLE KEYS */;
INSERT INTO `workassign` VALUES (1,1,2,'2021-12-18'),(2,3,1,'2021-12-18'),(3,1,1,'2021-12-19'),(4,1,2,'2021-12-20'),(5,1,2,'2021-12-21'),(6,1,2,'2021-12-22'),(7,3,1,'2021-12-19'),(8,3,2,'2021-12-20'),(9,7,1,'2021-12-21'),(10,7,1,'2021-12-22'),(11,8,1,'2021-12-19'),(12,8,1,'2021-12-18'),(13,8,2,'2021-12-20'),(14,8,1,'2021-12-21'),(15,9,1,'2021-12-18'),(16,9,2,'2021-12-19'),(17,9,2,'2021-12-20'),(18,9,1,'2021-12-21'),(19,1,2,'2021-12-23'),(20,1,1,'2021-12-25'),(21,1,1,'2021-12-24'),(22,1,2,'2021-12-26'),(23,2,1,'2021-12-22'),(24,2,2,'2021-12-23'),(25,2,2,'2021-12-24'),(26,3,1,'2021-12-22'),(27,3,2,'2021-12-23'),(28,3,2,'2021-12-25'),(29,7,1,'2021-12-24'),(30,9,1,'2021-12-22'),(31,9,1,'2021-12-24'),(32,9,2,'2021-12-25');
/*!40000 ALTER TABLE `workassign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `dichvuhot`
--

/*!50001 DROP VIEW IF EXISTS `dichvuhot`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `dichvuhot` AS select `services`.`Id` AS `Id`,`services`.`ServiceName` AS `ServiceName`,`services`.`Price` AS `Price`,`services`.`Status` AS `Status`,`services`.`Image` AS `Image`,`services`.`Note` AS `Note` from `services` where `services`.`Id` in (select `bookingdetails`.`ServiceId` from `bookingdetails` group by `bookingdetails`.`ServiceId` order by count(0) desc) limit 3 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `lienhetk`
--

/*!50001 DROP VIEW IF EXISTS `lienhetk`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `lienhetk` AS select substr(cast(`contacts`.`CreateDate` as char charset utf8mb4),1,7) AS `monthYear`,`contacts`.`Phone` AS `Phone` from `contacts` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `thongbaoucf`
--

/*!50001 DROP VIEW IF EXISTS `thongbaoucf`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `thongbaoucf` AS select `booking`.`Id` AS `Id`,`booking`.`CreateDate` AS `CreateDate`,`booking`.`TimeBooking` AS `TimeBooking`,`booking`.`StylistId` AS `StylistId`,`booking`.`CustormerId` AS `CustormerId` from `booking` where (`booking`.`StatusId` = 'UCF') order by `booking`.`Id` desc,`booking`.`CreateDate` limit 3 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `thongkedt`
--

/*!50001 DROP VIEW IF EXISTS `thongkedt`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `thongkedt` AS select substr(cast(`booking`.`CreateDate` as char charset utf8mb4),1,7) AS `monthYear`,`booking`.`TotalPrice` AS `doanhThu` from `booking` where (`booking`.`StatusId` = 'CPM') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `thongkehd`
--

/*!50001 DROP VIEW IF EXISTS `thongkehd`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `thongkehd` AS select substr(cast(`booking`.`CreateDate` as char charset utf8mb4),1,7) AS `monthYear`,`booking`.`StatusId` AS `StatusId`,`booking`.`CustormerId` AS `CustormerId` from `booking` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-21 10:50:02
