/*
 Navicat Premium Data Transfer

 Source Server         : student_system
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : student_manage_database

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 29/11/2020 22:30:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for academy
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy`  (
  `academyId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`academyId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of academy
-- ----------------------------
INSERT INTO `academy` VALUES ('1000001', '计算机学院');
INSERT INTO `academy` VALUES ('1000002', '数据学院');

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `addressId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `provinces` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `city` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`addressId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('2000001', '内蒙古', 'Ⅷ');

-- ----------------------------
-- Table structure for certificate
-- ----------------------------
DROP TABLE IF EXISTS `certificate`;
CREATE TABLE `certificate`  (
  `certificateId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`certificateId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of certificate
-- ----------------------------
INSERT INTO `certificate` VALUES ('3000001', '中国大奖');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `classId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `className` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `chargerTeacherId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`classId`) USING BTREE,
  INDEX `FK_class_to_teacher`(`chargerTeacherId`) USING BTREE,
  CONSTRAINT `FK_class_to_teacher` FOREIGN KEY (`chargerTeacherId`) REFERENCES `teacher` (`teacherId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('4000001', '18软件工程', '1800001');

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom`  (
  `classroomId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `capacity` int(0) NULL DEFAULT NULL,
  `location` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `classroomNum` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`classroomId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES ('5000001', 33, '行纸篓', '201');
INSERT INTO `classroom` VALUES ('5000002', 100, '李工娄', '321');
INSERT INTO `classroom` VALUES ('5000003', 10, '网院', '111');
INSERT INTO `classroom` VALUES ('5000004', 11, '李工娄', '1208');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `courseId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `courseName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `departmentId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `introduce` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`courseId`) USING BTREE,
  INDEX `FK_course_department`(`departmentId`) USING BTREE,
  CONSTRAINT `FK_course_department` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('6000001', '分布式理论', '9000001', '分布式不真正到企业里实践，你能学会？');
INSERT INTO `course` VALUES ('6000002', '闪电五连鞭教学', '9000001', '我大意了啊！！！');
INSERT INTO `course` VALUES ('6000003', '内核', '9000002', '难的一批');
INSERT INTO `course` VALUES ('6000004', 'no pain no gain', '9000002', 'always remember');

-- ----------------------------
-- Table structure for courseclass
-- ----------------------------
DROP TABLE IF EXISTS `courseclass`;
CREATE TABLE `courseclass`  (
  `courseClassId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teachingStartDate` date NULL DEFAULT NULL,
  `teachingEndDate` date NULL DEFAULT NULL,
  `courseId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `qualifyPeopleNum` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`courseClassId`) USING BTREE,
  INDEX `FK_courseClass_to_course`(`courseId`) USING BTREE,
  CONSTRAINT `FK_courseClass_to_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseclass
-- ----------------------------
INSERT INTO `courseclass` VALUES ('7000001', '2020-09-01', '2021-01-01', '6000001', 100);
INSERT INTO `courseclass` VALUES ('7000002', '2020-09-02', '2921-01-10', '6000002', 1000);
INSERT INTO `courseclass` VALUES ('7000003', '2021-09-02', '2921-02-02', '6000003', 1);
INSERT INTO `courseclass` VALUES ('7000004', '2020-01-01', '2090-12-12', '6000004', 12);

-- ----------------------------
-- Table structure for courseuseclassroom
-- ----------------------------
DROP TABLE IF EXISTS `courseuseclassroom`;
CREATE TABLE `courseuseclassroom`  (
  `classroomId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `courseClassId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`classroomId`, `courseClassId`) USING BTREE,
  INDEX `FK_use_to_courseClass`(`courseClassId`) USING BTREE,
  INDEX `FK_use_to_classroomId`(`classroomId`) USING BTREE,
  CONSTRAINT `FK_use_to_classroom` FOREIGN KEY (`classroomId`) REFERENCES `classroom` (`classroomId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_use_to_courseClass` FOREIGN KEY (`courseClassId`) REFERENCES `courseclass` (`courseClassId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseuseclassroom
-- ----------------------------
INSERT INTO `courseuseclassroom` VALUES ('5000001', '7000001');
INSERT INTO `courseuseclassroom` VALUES ('5000002', '7000002');
INSERT INTO `courseuseclassroom` VALUES ('5000003', '7000003');
INSERT INTO `courseuseclassroom` VALUES ('5000004', '7000004');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `departmentId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `academyId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`departmentId`) USING BTREE,
  INDEX `FK_department_academy`(`academyId`) USING BTREE,
  CONSTRAINT `FK_department_academy` FOREIGN KEY (`academyId`) REFERENCES `academy` (`academyId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('9000001', '计算机系', '1000001');
INSERT INTO `department` VALUES ('9000002', '网络系', '1000002');

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory`  (
  `dorId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `buildingNum` int(0) NULL DEFAULT NULL,
  `dormitoryNum` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`dorId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES ('1100001', 8, 925);

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `majorId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `majorName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`majorId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1100001', '软件工程');
INSERT INTO `major` VALUES ('1100002', '大数据');

-- ----------------------------
-- Table structure for punishment
-- ----------------------------
DROP TABLE IF EXISTS `punishment`;
CREATE TABLE `punishment`  (
  `punishmentId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `category` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`punishmentId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of punishment
-- ----------------------------
INSERT INTO `punishment` VALUES ('1200001', '垃圾没扔', '校级');
INSERT INTO `punishment` VALUES ('1200002', '被子没叠', '校级');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `studentId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birthday` date NULL DEFAULT NULL,
  `phoneNumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `infoId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `registerTime` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`studentId`) USING BTREE,
  INDEX `FK_student_to_info`(`infoId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `FK_student_to_info` FOREIGN KEY (`infoId`) REFERENCES `studentinfo` (`infoId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('20181102928', '落拓', '男', '2000-01-01', '1983449241', '1600001', '2020-11-17', '2500001');

-- ----------------------------
-- Table structure for studentarchive
-- ----------------------------
DROP TABLE IF EXISTS `studentarchive`;
CREATE TABLE `studentarchive`  (
  `archiveId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `origin` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `startSchoolDate` date NULL DEFAULT NULL,
  `punishmentId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `certificateId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`archiveId`) USING BTREE,
  INDEX `FK_CER`(`certificateId`) USING BTREE,
  INDEX `FK_PUN`(`punishmentId`) USING BTREE,
  CONSTRAINT `FK_CER` FOREIGN KEY (`certificateId`) REFERENCES `certificate` (`certificateId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_PUN` FOREIGN KEY (`punishmentId`) REFERENCES `punishment` (`punishmentId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentarchive
-- ----------------------------
INSERT INTO `studentarchive` VALUES ('1400001', '上海', '2020-11-29', '1200001', '3000001');

-- ----------------------------
-- Table structure for studentinfo
-- ----------------------------
DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE `studentinfo`  (
  `infoId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `majorId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `studentTypeId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `archiveId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `classId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dormitoryId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `addressId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`infoId`) USING BTREE,
  INDEX `FK_info_to_major`(`majorId`) USING BTREE,
  INDEX `FK_info_to_studentType`(`studentTypeId`) USING BTREE,
  INDEX `FK_info_to_archive`(`archiveId`) USING BTREE,
  INDEX `FK_info_to_class`(`classId`) USING BTREE,
  INDEX `FK_info_to_dormitory`(`dormitoryId`) USING BTREE,
  INDEX `FK_info_to_address`(`addressId`) USING BTREE,
  CONSTRAINT `FK_info_to_address` FOREIGN KEY (`addressId`) REFERENCES `address` (`addressId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_info_to_class` FOREIGN KEY (`classId`) REFERENCES `class` (`classId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_info_to_dormitory` FOREIGN KEY (`dormitoryId`) REFERENCES `dormitory` (`dorId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_info_to_major` FOREIGN KEY (`majorId`) REFERENCES `major` (`majorId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_info_to_studentType` FOREIGN KEY (`studentTypeId`) REFERENCES `studenttype` (`studentTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentinfo
-- ----------------------------
INSERT INTO `studentinfo` VALUES ('1600001', '1100001', '1700001', '1400001', '4000001', '1100001', '2000001');

-- ----------------------------
-- Table structure for studenttype
-- ----------------------------
DROP TABLE IF EXISTS `studenttype`;
CREATE TABLE `studenttype`  (
  `studentTypeId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `typeName` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`studentTypeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studenttype
-- ----------------------------
INSERT INTO `studenttype` VALUES ('1700001', '一本');
INSERT INTO `studenttype` VALUES ('1700002', '二本');
INSERT INTO `studenttype` VALUES ('1700003', '专科');

-- ----------------------------
-- Table structure for stuselectcourse
-- ----------------------------
DROP TABLE IF EXISTS `stuselectcourse`;
CREATE TABLE `stuselectcourse`  (
  `score` int(0) NULL DEFAULT NULL,
  `studentId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `courseClassId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`studentId`, `courseClassId`) USING BTREE,
  INDEX `FK_selectCourse_CourseClass`(`courseClassId`) USING BTREE,
  INDEX `Fk_index_studentId`(`studentId`) USING BTREE,
  CONSTRAINT `FK_selectCourse_CourseClass` FOREIGN KEY (`courseClassId`) REFERENCES `courseclass` (`courseClassId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_selectCourse_student` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stuselectcourse
-- ----------------------------
INSERT INTO `stuselectcourse` VALUES (NULL, '20181102928', '7000002');
INSERT INTO `stuselectcourse` VALUES (NULL, '20181102928', '7000003');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacherId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phoneNumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `archiveId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `departmentId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacherId`) USING BTREE,
  INDEX `FK_teacher_to_teacherArchive`(`archiveId`) USING BTREE,
  INDEX `FK_teacher_to_department`(`departmentId`) USING BTREE,
  INDEX `teacher`(`teacherId`) USING BTREE,
  CONSTRAINT `FK_teacher_to_department` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_teacher_to_teacherArchive` FOREIGN KEY (`archiveId`) REFERENCES `teacherarchive` (`archiveId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1800001', '男', '张力', '1234567', '1900001', '9000001', '2500002');

-- ----------------------------
-- Table structure for teacherarchive
-- ----------------------------
DROP TABLE IF EXISTS `teacherarchive`;
CREATE TABLE `teacherarchive`  (
  `archiveId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `inductionDate` date NULL DEFAULT NULL,
  `professionalGrade` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`archiveId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacherarchive
-- ----------------------------
INSERT INTO `teacherarchive` VALUES ('1900001', '2010-10-10', '教授');

-- ----------------------------
-- Table structure for teachingcase
-- ----------------------------
DROP TABLE IF EXISTS `teachingcase`;
CREATE TABLE `teachingcase`  (
  `caseId` int(0) NOT NULL AUTO_INCREMENT,
  `assessmentScore` int(0) NULL DEFAULT NULL,
  `teachingSchedule` int(0) NULL DEFAULT NULL,
  `teacherId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `courseClassId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`caseId`) USING BTREE,
  INDEX `FK_teachingCase_to_teacher`(`teacherId`) USING BTREE,
  INDEX `FK_teachingCase_to_courseClass`(`courseClassId`) USING BTREE,
  CONSTRAINT `FK_teachingCase_to_courseClass` FOREIGN KEY (`courseClassId`) REFERENCES `courseclass` (`courseClassId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_teachingCase_to_teacher` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2300003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachingcase
-- ----------------------------
INSERT INTO `teachingcase` VALUES (2300001, 100, 50, '1800001', '7000001');
INSERT INTO `teachingcase` VALUES (2300002, 10, 1111, '1800001', '7000002');

-- ----------------------------
-- Table structure for teachingdetails
-- ----------------------------
DROP TABLE IF EXISTS `teachingdetails`;
CREATE TABLE `teachingdetails`  (
  `detailId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `credit` int(0) NULL DEFAULT NULL,
  `semester` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `teachingPlanId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `courseId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`detailId`) USING BTREE,
  INDEX `FK_details_course`(`courseId`) USING BTREE,
  INDEX `FK_DETAILS_PLAN`(`teachingPlanId`) USING BTREE,
  CONSTRAINT `FK_details_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_DETAILS_PLAN` FOREIGN KEY (`teachingPlanId`) REFERENCES `teachingplan` (`planId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachingdetails
-- ----------------------------
INSERT INTO `teachingdetails` VALUES ('2100001', 1, '大三上', '2200001', '6000001');
INSERT INTO `teachingdetails` VALUES ('2100002', 2, '大三上', '2200001', '6000002');
INSERT INTO `teachingdetails` VALUES ('2100003', 10, '大三上', '2200001', '6000003');
INSERT INTO `teachingdetails` VALUES ('2100004', 3, '大三下', '2200001', '6000004');

-- ----------------------------
-- Table structure for teachingplan
-- ----------------------------
DROP TABLE IF EXISTS `teachingplan`;
CREATE TABLE `teachingplan`  (
  `planId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `planName` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `classHours` int(0) NULL DEFAULT NULL,
  `requiredCourseCredit` int(0) NULL DEFAULT NULL,
  `selectiveCourseCredit` int(0) NULL DEFAULT NULL,
  `makeDate` date NULL DEFAULT NULL,
  `majorId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `studentTypeId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`planId`) USING BTREE,
  INDEX `FK_teachplan_major`(`majorId`) USING BTREE,
  INDEX `FK_teachplan_type`(`studentTypeId`) USING BTREE,
  CONSTRAINT `FK_teachplan_major` FOREIGN KEY (`majorId`) REFERENCES `major` (`majorId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_teachplan_type` FOREIGN KEY (`studentTypeId`) REFERENCES `studenttype` (`studentTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachingplan
-- ----------------------------
INSERT INTO `teachingplan` VALUES ('2200001', '2020软件工程教学计划', 100, 20, 20, '2019-11-01', '1100001', '1700001');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `permission` int(0) NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE,
  INDEX `id`(`userId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2500001', '张三', '1983449241', 15946);
INSERT INTO `user` VALUES ('2500002', '李四', '123456', 18934);

-- ----------------------------
-- View structure for courseinfo
-- ----------------------------
DROP VIEW IF EXISTS `courseinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `courseinfo` AS select `course`.`courseId` AS `courseId`,`course`.`courseName` AS `courseName`,`teachingdetails`.`credit` AS `credit`,`course`.`introduce` AS `introduce`,`courseclass`.`qualifyPeopleNum` AS `qualifyPeopleNum`,`courseclass`.`teachingEndDate` AS `teachingEndDate`,`courseclass`.`teachingStartDate` AS `teachingStartDate`,`classroom`.`location` AS `location`,`classroom`.`classroomNum` AS `classroomNum`,`courseclass`.`courseClassId` AS `courseClassId` from (((((`student` join `course`) join `courseclass`) join `classroom`) join `courseuseclassroom`) join `teachingdetails`) where ((`teachingdetails`.`courseId` = `course`.`courseId`) and (`courseclass`.`courseId` = `course`.`courseId`) and (`courseclass`.`courseClassId` = `courseuseclassroom`.`courseClassId`) and (`courseuseclassroom`.`classroomId` = `classroom`.`classroomId`));

-- ----------------------------
-- View structure for stuarchiveview
-- ----------------------------
DROP VIEW IF EXISTS `stuarchiveview`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `stuarchiveview` AS select `student`.`name` AS `name`,`studentarchive`.`origin` AS `origin`,`studentarchive`.`startSchoolDate` AS `startSchoolDate`,`student`.`studentId` AS `studentId`,`punishment`.`content` AS `punishmentContent`,`punishment`.`category` AS `punishmentCategory`,`certificate`.`content` AS `certificateContent` from ((((`student` join `studentinfo`) join `studentarchive`) join `punishment`) join `certificate`) where ((`student`.`infoId` = `studentinfo`.`infoId`) and (`studentinfo`.`archiveId` = `studentarchive`.`archiveId`) and (`studentarchive`.`punishmentId` = `punishment`.`punishmentId`) and (`studentarchive`.`certificateId` = `certificate`.`certificateId`));

-- ----------------------------
-- View structure for studentinfoview
-- ----------------------------
DROP VIEW IF EXISTS `studentinfoview`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `studentinfoview` AS select `student`.`studentId` AS `studentId`,`student`.`name` AS `name`,`student`.`gender` AS `gender`,`student`.`birthday` AS `birthday`,`student`.`phoneNumber` AS `phoneNumber`,`major`.`majorName` AS `majorName`,`studenttype`.`typeName` AS `typeName`,`address`.`city` AS `city`,`address`.`provinces` AS `provinces`,`dormitory`.`buildingNum` AS `buildingNum`,`dormitory`.`dormitoryNum` AS `dormitoryNum`,`class`.`className` AS `className` from ((((((`student` join `studentinfo`) join `major`) join `address`) join `dormitory`) join `studenttype`) join `class`) where ((`student`.`infoId` = `studentinfo`.`infoId`) and (`studentinfo`.`majorId` = `major`.`majorId`) and (`studentinfo`.`addressId` = `address`.`addressId`) and (`studentinfo`.`dormitoryId` = `dormitory`.`dorId`) and (`studentinfo`.`studentTypeId` = `studenttype`.`studentTypeId`) and (`studentinfo`.`classId` = `class`.`classId`));

SET FOREIGN_KEY_CHECKS = 1;
