select * from courseInfo;
select * from stuselectcourse;

-- 学生课程查询

SELECT courseInfo.* from courseInfo ,student,stuselectcourse
WHERE student.studentId=20181102928
and student.studentId=stuselectcourse.studentId
and stuselectCourse.courseClassId=courseInfo.courseClassId;

-- 可选课程查询

SELECT courseInfo.* ,teacher.name,teacher.gender 
from courseInfo,teacher,teachingcase 
WHERE teachingcase.teacherId=teacher.teacherid
and teachingcase.courseClassId=courseInfo.courseClassId;

-- 选课操作，提供课程Id，学生Id，课程班Id
-- 后端先根据courseId和courseClassId检查课程班是否存在

insert into stuselectcourse (studentId,courseclassId) values('20181102928','7000002')

-- 退课操作

DELETE FROM stuselectcourse where studentId="20181102928" and courseClassId="7000002";
