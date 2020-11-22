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
     * 根据教师IdId获得学生信息
     * @param teacherId
     * @param id
     * @param isClass 为true时id为班级id，为false时id为教学班id
     * @param page
     * @param num
     * @return
     */
    List<StudentInfo> getStuInfoByTeacherIdAndId(@Param("teacherId") String teacherId,@Param("id") String id,@Param("isClass") boolean isClass,@Param("page") int page,@Param("num") int num);


    /**
     * 根据学生id和教学班id更新学生分数
     * @param studentId
     * @param courseClassID
     */
    void updateStudentScore(@Param("studentId") String studentId,@Param("courseClassId") String courseClassID);
}
