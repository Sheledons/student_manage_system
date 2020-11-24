package cn.sheledon.service.inter.student;


import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.Teacher;
import cn.sheledon.pojo.User;

import java.util.List;

/**
 * @author sheledon
 */
public interface IStudentService {
    /**
     * 根据userId 获得学生信息
     * @param user
     * @return
     */
    Student getStudentByUserId(User user);

    /**
     * 根据userId获得学生姓名
     * @param user
     * @return
     */
    Student getStudentName(User user);

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
    Student getStudentArchive(String studentId);

    /**
     * 根据教师id和班级id获得学生信息
     * @param teacherId
     * @param classId
     * @return
     */
    List<Student> getClassStudentsByTeacherId(String teacherId,String classId);

    /**
     * 根据教师id和教学班id获得学生信息
     * @param teacherId
     * @param courseClassId
     * @return
     */
    List<Student> getCourseClassStudentByTeacherId(String teacherId,String courseClassId);
}
