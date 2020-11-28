package cn.sheledon.service.inter.student;


import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.StudentArchive;
import cn.sheledon.pojo.StudentInfo;
import cn.sheledon.service.inter.IBaseService;

import java.util.List;

/**
 * @author sheledon
 */
public interface IStudentService extends IBaseService {
    /**
     * 根据userId 获得学生信息
     * @param userId
     * @return
     */
    Student getStudentByUserId(String userId);
    /**
     * 根据userId获得学生姓名
     * @param userId
     * @return
     */
    Student getStudentName(String userId);

    /**
     * 根据学生Id获得学生的信息
     * @param studentId
     * @return
     */
    Student getStudentInfoByStudentId(String studentId);

    /**
     * 根据学生id获得学生的档案
     * @param studentId
     * @return
     */
    StudentArchive getStudentArchive(String studentId);
    /**
     * 根据教师id和班级id获得学生信息
     * @param teacherId
     * @param classId
     * @param page
     * @param num
     * @return
     */
    List<Student> getClassStudentsByTeacherId(String teacherId,String classId,int page,int num);
    
    /**
     * 根据教师id和教学班id获得学生信息
     * @param teacherId
     * @param courseClassId
     * @param page
     * @param num
     * @return
     */
    List<Student> getCourseClassStudentByTeacherId(String teacherId,String courseClassId,int page,int num);
}
