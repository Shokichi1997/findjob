-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: jobmanager
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `com_id` int(11) NOT NULL AUTO_INCREMENT,
  `comname` varchar(100) NOT NULL,
  `comlogo` varchar(100) DEFAULT NULL,
  `comdecribe` text,
  `comtype` int(11) DEFAULT NULL,
  `comlocation` varchar(50) NOT NULL,
  `combegintime` tinyint(4) NOT NULL,
  `comendtime` tinyint(4) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `minemployee` int(11) DEFAULT NULL,
  `maxemmployee` int(11) DEFAULT NULL,
  PRIMARY KEY (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Emotiv Technology Vietnam','emotv.jpg','A bioinformatics company offering a unique platform for crowd-sourced brain research',1,'Hà Nội',1,5,'1 Hapulico Complex, Nguyễn Huy Tưởng, Thanh Xuan, Ha Noi',51,150),(2,'Emotiv Technology Vietnam','emotv.jpg','A bioinformatics company offering a unique platform for crowd-sourced brain research',1,'Hà Nội',1,5,'1 Hapulico Complex, Nguyễn Huy Tưởng, Thanh Xuan, Ha Noi',51,150),(3,'TP&P Technology','tpptechnologypng.png','Tech Startup Incubator, Software Development Services, and Salesforce Consulting & Customization',2,'Hồ Chí Minh',1,5,'302 Le Van Sy, Tan Binh, Ho Chi Minh',100,200);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_image`
--

DROP TABLE IF EXISTS `company_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_image` (
  `hinh_id` int(11) NOT NULL AUTO_INCREMENT,
  `com_id` int(11) DEFAULT NULL,
  `hinhname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hinh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_image`
--

LOCK TABLES `company_image` WRITE;
/*!40000 ALTER TABLE `company_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hinh`
--

DROP TABLE IF EXISTS `hinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hinh` (
  `hinh_id` int(11) NOT NULL,
  `com_id` int(11) DEFAULT NULL,
  `hinhname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`hinh_id`),
  KEY `com_id_hinh_fk_idx` (`com_id`),
  CONSTRAINT `com_id_hinh_fk` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hinh`
--

LOCK TABLES `hinh` WRITE;
/*!40000 ALTER TABLE `hinh` DISABLE KEYS */;
/*!40000 ALTER TABLE `hinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `jobname` varchar(300) NOT NULL,
  `reason` text,
  `decribe` text,
  `skill` text,
  `benefit` text,
  `minsalary` int(11) DEFAULT NULL,
  `maxsalary` int(11) DEFAULT NULL,
  `com_id` int(11) NOT NULL,
  PRIMARY KEY (`job_id`),
  KEY `com_job_fk_idx` (`com_id`),
  CONSTRAINT `FKexhlpi1dtnhxnftqe4udd1ucg` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`),
  CONSTRAINT `com_job_fk` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'Front End Web Dev (JavaScript, ReactJS)','- Attractive salary\n- Health Care Insurance\n- Flexible working time','EMOTIV is seeking a full time Senior Front End Web Developer to help build responsive single page apps and hybrid cross-platform mobile apps and data visualization dashboards for use with Emotiv EEG headsets.\n\nThe successful candidate will be based in or willing to relocate to Hanoi, Vietnam.\n\nResponsibilities\n\n● Develop the user face for Emotiv applications using React JS;\n\n● Optimize applications for speed and scalability;\n\n● Ensure the technical feasibility of UI/UX designs across multiple device types (desktop, tablet, mobile);\n\n● Collaborate with other team members and stakeholders;','● Bachelor’s Degree in Computer Science, Engineering or a related field\n● FrontEnd: Javascript (vanillaJS) JQuery, ReactJS, VueJS are mandatory\n● 3+ years’ experience with JavaScript and HTML for browser based\n● 2+ years’ experience with one or more front end web frameworks including React, Redux or Vue\n● 2+ years’ experience with Agile development processes for Continuous Integration, Testing and Deployment\n<b>Preferred Skills<b>\n\n● Experience building dashboards and charts for historical and real-time data visualization\n● Experience with Oauth and related http technologies for the consumption with cloud based web services\n● Experience building responsive mobile first web apps to accommodate multiple phone, tablet and desktop form factors\n● Good English verbal and written communication skills\n','- 13th Month Salary\n- Flexible working time\n- Health Insurance\n- Attractive Salary\n- Company activities (team building, company trip on working days)\n- Passionate colleagues\n- Creative & young working space\n- 2 leaving days for training\n- Energetic, open and transparent working environment\n- Snacks, tea and coffee all the time',600,1000,1),(2,'Javascript/ NodeJS/ ExpressJS Developers','- Well compensation package based on value creation\n- Opportunities to work with talent and onsite in US\n- Learn new technology and features of health system','We are looking for 2 x Javascript / Node JS/ Express JS Developers implementing modular Javascript Microservices for well-defined and focused data processing and data transformation to processing flat file Digital Threads into our core AI and Blockchain platform. \n\nAre you ready to be apart of the project team who are incubating the world changing AI product in Industrial and Construction industries? Or are you looking for professional and fast growing software development services company who working on cool projects for global leading technologies companies?\n\nIf you are, let\'s contact us to explore.','Skills required:\n\n- 2-3 years experiences with Javacript Microservice/ Express JS /Node JS\n- Strong experiences working with PostgresSQL, Microservices Architect\n- Good experience/knowledge working with Digital Thread or https://decisions.com/ framework are big plus\n- Good experience working on big data processing, data transformation, AI platform, and Hyper-ledger Fabric are big plus','We are a human orientation organization where we aim to create the best environment for every members developing competent skills and growing career. Our mission is to deliver the highest quality of services to our customers, employees and partners. To pursue our mission, our resource strategy is to get the right team where each of the individual will be complemented to each other and learned from each other. When you join us, you will find:\n \n\nHave an opportunity to work at professional, but with startup spirit and environment.\nHave opportunities to work onsite in Hawaii/Bali and Japan\nHave opportunities to work with talent people and deliver the world AI/Block-chain product in Industrial and Construction industry.\nWell compensation package based on performance and value creation\n           + Bonus for excellent project performance\n\n           + Annually company trip & project team building outing\n\n           + Additional health care policy for employees and family (based on level)\n\n           + Startup or companies stocked offer\n\nLet join us to share experiences and celebrating the moment of achieving the mission together!',500,1000,3);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-20 14:45:00
