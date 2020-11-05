-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: student_manage_database
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `academy`
--

DROP TABLE IF EXISTS `academy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academy` (
  `academyId` varchar(10) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`academyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academy`
--

LOCK TABLES `academy` WRITE;
/*!40000 ALTER TABLE `academy` DISABLE KEYS */;
/*!40000 ALTER TABLE `academy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `addressId` varchar(10) NOT NULL,
  `provinces` varchar(10) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate`
--

DROP TABLE IF EXISTS `certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificate` (
  `certificateId` varchar(10) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`certificateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate`
--

LOCK TABLES `certificate` WRITE;
/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `classId` varchar(10) NOT NULL,
  `classNum` varchar(5) DEFAULT NULL,
  `className` varchar(10) DEFAULT NULL,
  `chargerTeacherId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`classId`),
  KEY `FK_class_to_teacher` (`chargerTeacherId`),
  CONSTRAINT `FK_class_to_teacher` FOREIGN KEY (`chargerTeacherId`) REFERENCES `teacher` (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom` (
  `classroomId` varchar(10) NOT NULL,
  `capacity` int DEFAULT NULL,
  `location` varchar(10) DEFAULT NULL,
  `classroomNum` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`classroomId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `courseId` varchar(10) NOT NULL,
  `courseName` varchar(10) DEFAULT NULL,
  `departmentId` varchar(10) DEFAULT NULL,
  `introduce` text,
  PRIMARY KEY (`courseId`),
  KEY `FK_course_department` (`departmentId`),
  CONSTRAINT `FK_course_department` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courseclass`
--

DROP TABLE IF EXISTS `courseclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courseclass` (
  `courseClassId` varchar(10) NOT NULL,
  `teachingStartDate` date DEFAULT NULL,
  `teachingEndDate` date DEFAULT NULL,
  `courseId` varchar(10) DEFAULT NULL,
  `qualifyNumber` int DEFAULT NULL,
  PRIMARY KEY (`courseClassId`),
  KEY `FK_courseClass_to_course` (`courseId`),
  CONSTRAINT `FK_courseClass_to_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courseclass`
--

LOCK TABLES `courseclass` WRITE;
/*!40000 ALTER TABLE `courseclass` DISABLE KEYS */;
/*!40000 ALTER TABLE `courseclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courseuseclassroom`
--

DROP TABLE IF EXISTS `courseuseclassroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courseuseclassroom` (
  `classroomId` varchar(10) NOT NULL,
  `courseClassId` varchar(10) NOT NULL,
  PRIMARY KEY (`classroomId`,`courseClassId`),
  KEY `FK_use_to_courseClass` (`courseClassId`),
  CONSTRAINT `FK_use_to_classroom` FOREIGN KEY (`classroomId`) REFERENCES `classroom` (`classroomId`),
  CONSTRAINT `FK_use_to_courseClass` FOREIGN KEY (`courseClassId`) REFERENCES `courseclass` (`courseClassId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courseuseclassroom`
--

LOCK TABLES `courseuseclassroom` WRITE;
/*!40000 ALTER TABLE `courseuseclassroom` DISABLE KEYS */;
/*!40000 ALTER TABLE `courseuseclassroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `departmentId` varchar(10) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `academyId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`departmentId`),
  KEY `FK_department_academy` (`academyId`),
  CONSTRAINT `FK_department_academy` FOREIGN KEY (`academyId`) REFERENCES `academy` (`academyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dormitory`
--

DROP TABLE IF EXISTS `dormitory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dormitory` (
  `dorId` varchar(10) NOT NULL,
  `buildingNum` int DEFAULT NULL,
  `dormitoryNum` int DEFAULT NULL,
  PRIMARY KEY (`dorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dormitory`
--

LOCK TABLES `dormitory` WRITE;
/*!40000 ALTER TABLE `dormitory` DISABLE KEYS */;
/*!40000 ALTER TABLE `dormitory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `major` (
  `majorId` varchar(10) NOT NULL,
  `majorName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`majorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `punishment`
--

DROP TABLE IF EXISTS `punishment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `punishment` (
  `punishmentId` varchar(10) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`punishmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `punishment`
--

LOCK TABLES `punishment` WRITE;
/*!40000 ALTER TABLE `punishment` DISABLE KEYS */;
/*!40000 ALTER TABLE `punishment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `studentId` varchar(20) NOT NULL,
  `name` varchar(10) NOT NULL,
  `gender` varchar(3) NOT NULL,
  `birthday` date DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `infoId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`studentId`),
  KEY `FK_student_to_info` (`infoId`),
  CONSTRAINT `FK_student_to_info` FOREIGN KEY (`infoId`) REFERENCES `studentinfo` (`infoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentarchive`
--

DROP TABLE IF EXISTS `studentarchive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentarchive` (
  `archiveId` varchar(10) NOT NULL,
  `origin` varchar(10) DEFAULT NULL,
  `startSchoolDate` date DEFAULT NULL,
  `punishmentId` varchar(10) DEFAULT NULL,
  `certificateId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`archiveId`),
  KEY `FK_studentArchive_to_punishment` (`punishmentId`),
  KEY `FK_studentArchive_to_certificate` (`certificateId`),
  CONSTRAINT `FK_studentArchive_to_certificate` FOREIGN KEY (`certificateId`) REFERENCES `certificate` (`certificateId`),
  CONSTRAINT `FK_studentArchive_to_punishment` FOREIGN KEY (`punishmentId`) REFERENCES `punishment` (`punishmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentarchive`
--

LOCK TABLES `studentarchive` WRITE;
/*!40000 ALTER TABLE `studentarchive` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentarchive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentinfo`
--

DROP TABLE IF EXISTS `studentinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentinfo` (
  `infoId` varchar(10) NOT NULL,
  `majorId` varchar(10) DEFAULT NULL,
  `studentTypeId` varchar(10) DEFAULT NULL,
  `archiveId` varchar(10) DEFAULT NULL,
  `classId` varchar(10) DEFAULT NULL,
  `dormitoryId` varchar(10) DEFAULT NULL,
  `addressId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`infoId`),
  KEY `FK_info_to_major` (`majorId`),
  KEY `FK_info_to_studentType` (`studentTypeId`),
  KEY `FK_info_to_archive` (`archiveId`),
  KEY `FK_info_to_class` (`classId`),
  KEY `FK_info_to_dormitory` (`dormitoryId`),
  KEY `FK_info_to_address` (`addressId`),
  CONSTRAINT `FK_info_to_address` FOREIGN KEY (`addressId`) REFERENCES `address` (`addressId`),
  CONSTRAINT `FK_info_to_archive` FOREIGN KEY (`archiveId`) REFERENCES `studentarchive` (`archiveId`),
  CONSTRAINT `FK_info_to_class` FOREIGN KEY (`classId`) REFERENCES `class` (`classId`),
  CONSTRAINT `FK_info_to_dormitory` FOREIGN KEY (`dormitoryId`) REFERENCES `dormitory` (`dorId`),
  CONSTRAINT `FK_info_to_major` FOREIGN KEY (`majorId`) REFERENCES `major` (`majorId`),
  CONSTRAINT `FK_info_to_studentType` FOREIGN KEY (`studentTypeId`) REFERENCES `studenttype` (`studentTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentinfo`
--

LOCK TABLES `studentinfo` WRITE;
/*!40000 ALTER TABLE `studentinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studenttype`
--

DROP TABLE IF EXISTS `studenttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studenttype` (
  `studentTypeId` varchar(10) NOT NULL,
  `typeName` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`studentTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studenttype`
--

LOCK TABLES `studenttype` WRITE;
/*!40000 ALTER TABLE `studenttype` DISABLE KEYS */;
/*!40000 ALTER TABLE `studenttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stuselectcourse`
--

DROP TABLE IF EXISTS `stuselectcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stuselectcourse` (
  `score` int DEFAULT NULL,
  `studentId` varchar(20) NOT NULL,
  `courseId` varchar(10) NOT NULL,
  PRIMARY KEY (`studentId`,`courseId`),
  KEY `FK_selectCourse_course` (`courseId`),
  CONSTRAINT `FK_selectCourse_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`),
  CONSTRAINT `FK_selectCourse_student` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stuselectcourse`
--

LOCK TABLES `stuselectcourse` WRITE;
/*!40000 ALTER TABLE `stuselectcourse` DISABLE KEYS */;
/*!40000 ALTER TABLE `stuselectcourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `teacherId` varchar(20) NOT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `archiveId` varchar(10) DEFAULT NULL,
  `departmentId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`teacherId`),
  KEY `FK_teacher_to_teacherArchive` (`archiveId`),
  KEY `FK_teacher_to_department` (`departmentId`),
  CONSTRAINT `FK_teacher_to_department` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  CONSTRAINT `FK_teacher_to_teacherArchive` FOREIGN KEY (`archiveId`) REFERENCES `teacherarchive` (`archiveId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacherarchive`
--

DROP TABLE IF EXISTS `teacherarchive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacherarchive` (
  `archiveId` varchar(10) NOT NULL,
  `graduateDate` date DEFAULT NULL,
  `professionalGrade` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`archiveId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacherarchive`
--

LOCK TABLES `teacherarchive` WRITE;
/*!40000 ALTER TABLE `teacherarchive` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacherarchive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachingcase`
--

DROP TABLE IF EXISTS `teachingcase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachingcase` (
  `caseId` int NOT NULL AUTO_INCREMENT,
  `assessmentScore` int DEFAULT NULL,
  `teachingSchedule` varchar(10) DEFAULT NULL,
  `teacherId` varchar(10) DEFAULT NULL,
  `courseClassId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`caseId`),
  KEY `FK_teachingCase_to_teacher` (`teacherId`),
  KEY `FK_teachingCase_to_courseClass` (`courseClassId`),
  CONSTRAINT `FK_teachingCase_to_courseClass` FOREIGN KEY (`courseClassId`) REFERENCES `courseclass` (`courseClassId`),
  CONSTRAINT `FK_teachingCase_to_teacher` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachingcase`
--

LOCK TABLES `teachingcase` WRITE;
/*!40000 ALTER TABLE `teachingcase` DISABLE KEYS */;
/*!40000 ALTER TABLE `teachingcase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachingdetails`
--

DROP TABLE IF EXISTS `teachingdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachingdetails` (
  `detailId` varchar(10) NOT NULL,
  `credit` int DEFAULT NULL,
  `semester` varchar(10) DEFAULT NULL,
  `teachingPlanId` varchar(10) DEFAULT NULL,
  `courseId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`detailId`),
  KEY `FK_details_course` (`courseId`),
  CONSTRAINT `FK_details_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachingdetails`
--

LOCK TABLES `teachingdetails` WRITE;
/*!40000 ALTER TABLE `teachingdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `teachingdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachingplan`
--

DROP TABLE IF EXISTS `teachingplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachingplan` (
  `planId` varchar(10) NOT NULL,
  `planName` varchar(15) DEFAULT NULL,
  `classHours` int DEFAULT NULL,
  `requiredCourseCredit` int DEFAULT NULL,
  `electiveCourseCredit` int DEFAULT NULL,
  `detailId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`planId`),
  KEY `FK_teachingPlan_to_details` (`detailId`),
  CONSTRAINT `FK_teachingPlan_to_details` FOREIGN KEY (`detailId`) REFERENCES `teachingdetails` (`detailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachingplan`
--

LOCK TABLES `teachingplan` WRITE;
/*!40000 ALTER TABLE `teachingplan` DISABLE KEYS */;
/*!40000 ALTER TABLE `teachingplan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-05  0:42:10
