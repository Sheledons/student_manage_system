package cn.sheledon.service.inter.course;

import cn.sheledon.pojo.CourseClass;
import cn.sheledon.pojo.StudentCourse;

import java.util.List;

/**
 * @author sheledon
 */
public interface ICourseService {

    /**
     * 获得学生可选的课程
     * @param studentId
     * @return
     */
    List<CourseClass> getStudentCanSelectCourse(String studentId);
    /**
     * 获得教师所任职的教学班信息
     * @param teacherId
     * @return
     */
    List<CourseClass> getCourseClassByTeacherId(String teacherId);

    /**
     * 根据学生id获得学生所选课程班信息
     * @param studentId
     * @return
     */
    List<CourseClass> getCourseClassByStudentId(String studentId);


    /**
     * 分页获得所有教学班的信息
     * @param page
     * @param num
     * @return
     */
    List<CourseClass> getCourseClass(int page,int num);

    /**
     * 根据学生的id获得学生所有课程的分数
     * @param studentId
     * @return
     */
    List<CourseClass> getStudentScoreById(String studentId);

    /**
     * 批量添加选课信息
     * @param studentId
     * @param courseList
     * @return
     */
    List<CourseClass> updateSelectCourse(String studentId,List<StudentCourse> courseList);
    /**
     * 根据学生的id和教学班id删除对应的选课
     * @param studentId
     * @param courseList
     * @return
     */
    boolean deleteSelectCourse(String studentId,List<StudentCourse> courseList);

    /**
     * 批量更新学生的分数
     * @param studentCourseList
     * @return
     */
    boolean updateStudentScore(List<StudentCourse> studentCourseList);
}
