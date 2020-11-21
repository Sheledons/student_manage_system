package cn.sheledon.mapper.student;

import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.StudentArchive;
import cn.sheledon.pojo.StudentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 与学生相关操作的Dao
 * @author sheledon
 */
public interface IStudentDao {
    /**
     * 根据用户Id获得学生基本信息
     * 例如学生姓名，性别，联系方式
     * @param userId
     * @return
     */
    Student getStudentByUserId(@Param("userId") String userId);
    /**
     * 根据学生Id获得学生的信息
     * 例如宿舍，专业，类型等
     * @param studentId
     * @return
     */
    StudentInfo getStudentInfo(@Param("studentId") String studentId);

    /**
     * 根据学生的Id获得学生档案信息
     * @param studentId
     * @return
     */
    StudentArchive getStudentArchive(@Param("studentId") String studentId);

    /**
     * 根据教师Id和班级Id获得班级内学生
     * @param teacherId
     * @param classId
     * @param page
     * @param num
     * @return
     */
    List<StudentInfo> getStudentInfoByTeacherIdAndClassId(@Param("teacherId") String teacherId,@Param("classId") String classId,@Param("page") int page,@Param("num") int num);

    /**
     * 根据教师Id和教学班Id获得学生的信息
     * @param teacherId
     * @param courseClassId
     * @return
     */
    List<StudentInfo> getStudentInfoByTeacherIdAndCourseClassId(@Param("teacherId") String teacherId,@Param("courseClassId") String courseClassId);

    /**
     * 根据学生id和教学班Id更新学生的Id
     * @param studentId
     * @param courseClassID
     */
    void updateStudentScore(@Param("studentId") String studentId,@Param("courseClassId") String courseClassID);
}
