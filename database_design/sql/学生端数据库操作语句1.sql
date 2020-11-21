use student_manage_database;
SELECT name ,userId,permission FROM user where name="张三" and password="";

-- 学生基本信息查询  需要创建视图
SELECT name ,gender, birthday,phoneNumber,majorName,typeName
from student,studentinfo,major,address,dormitory,studenttype
where student.userId=2500001 
and student.infoId=studentinfo.infoId 
and studentinfo.majorId=major.majorId
and studentinfo.addressId=address.addressId
and studentInfo.dormitoryId=dormitory.dorId
and studentinfo.studentTypeId=studenttype.studentTypeId ;

-- 学生档案查询,同样创建视图使用

CREATE OR REPLACE VIEW stuArchive AS 
SELECT 
name,origin,startSchoolDate,
punishment.content as punishmentContent,
punishment.category as punishmentCategory,
certificate.content as certificateContent
FROM  student,studentInfo,studentarchive,punishment,certificate
WHERE student.infoId=studentinfo.infoIdand studentinfo.archiveId=studentArchive.archiveId
and studentArchive.punishmentId=punishment.punishmentId
and studentArchive.certificateId=certificate.certificateId;
-- and studnetId= .........

-- 学生教学计划查询
SELECT planName ,classHours,makeDate,requiredCourseCredit,selectiveCourseCredit
FROM teachingplan,student,studentInfo 
WHERE teachingplan.majorId=studentInfo.majorId
and student.userId=2500001
and teachingplan.studentTypeId=studentInfo.studentTypeId
and student.infoId=studentinfo.infoId;

-- 课程查询 创建视图，以后学生课程查询和可选课程查询均使用该视图

CREATE OR  REPLACE VIEW courseInfo AS 
SELECT course.courseId,courseName,credit,introduce,qualifyPeopleNum,teachingEndDate,teachingStartDate,location,classroomNum,courseclass.courseClassId
FROM student ,course,courseClass,classroom,courseuseclassroom,teachingdetails
WHERE  teachingdetails.courseId=course.courseId
and courseClass.courseId=course.courseId
and courseclass.courseClassId=courseuseclassroom.courseClassId
and courseuseclassroom.classroomId=classroom.classroomId




