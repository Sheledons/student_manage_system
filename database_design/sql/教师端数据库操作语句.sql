-- 账号密码查询
-- SELECT name ,userId,permission FROM user where name="张三" and password="";

-- 教师基本信息查询
SELECT teacherId,gender,teacher.name,phoneNumber,department.name as departmentName,academy.name as academyName
FROM teacher,department,academy
WHERE teacher.departmentId=department.departmentId
AND department.academyId=academy.acadeMyId
AND teacher.userid=2500002;

-- 教师档案查询

SELECT inductionDate,professionalGrade FROM teacher,teacherarchive
WHERE teacher.archiveId=teacherarchive.archiveId
AND teacher.userId=2500002;

-- 教师所带班级的学生信息查询
SELECT student.name ,student.gender,student.phoneNumber,class.classId ,class.className
FROM student,class,teacher,studentinfo
WHERE studentinfo.classId=class.classId
AND studentInfo.infoId=student.infoId;
-- AND teacherID="  "
-- LIMIT 0,0

-- 教师所任职教学班查询

SELECT  courseClass.courseClassId,teachingStartDate,teachingEndDate,qualifyPeopleNum,coursename,course.courseId,location,classroomNum
FROM courseClass,classroom,course,courseuseclassroom,teacher,teachingcase
WHERE  
		courseClass.courseClassId=teachingcase.courseClassId
AND courseClass.courseClassId=courseuseclassroom.courseClassId
AND courseuseclassroom.classroomId=classroom.classroomId
AND course.courseId=courseclass.courseid
AND teachingCase.teacherId=teacher.teacherId
AND teacher.userId=2500002;

-- 教师所任职教学班的学生查询,提供教学班的id和老师id

SELECT student.`name`,student.gender,student.phoneNumber,class.classId,class.className
FROM student,teacher,stuselectcourse,courseClass,teachingCase,class
WHERE 
teacher.teacherId=teachingCase.teacherId
AND courseClass.courseClassId=teachingCase.courseClassId
AND stuselectCourse.studentId=student.studentId
AND teacher.teacherId=1800001
AND stuselectcourse.courseClassId=7000001;

-- 教师对学生分数进行录入
-- 后台在插入的时候该对教师是否任职该课进行校验

update stuselectcourse set score=100 
where studentId="20181102928"
AND courseClassId="7000001";


