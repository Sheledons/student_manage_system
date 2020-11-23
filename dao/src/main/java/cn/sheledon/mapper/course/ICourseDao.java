package cn.sheledon.mapper.course;

import cn.sheledon.pojo.CourseClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 课程相关Dao
 * @author sheledon
 */
@Repository
public interface ICourseDao{

    /**
     * 根据教师或者是学生ID获得相应的课程班信息
     * @param id
     * @param isTeacher
     * @return
     */
    List<CourseClass> getCourseClassById(@Param("id") String id,@Param("isTeacher") boolean isTeacher);

    /**
     * 当前开设的所有教学班查询查询
     * @param page
     * @param num
     * @return
     */
    List<CourseClass> getCourseClass(@Param("page") int page,@Param("num") int num);

    /**
     * 这里注意选课操作是应该是一个事务
     */
    /**
     * 在学生选课关联表中插入数据，即选课
     * @param studentId
     * @param courseClassId
     */
    void createSelectCourse(@Param("studentId") String studentId,@Param("courseClassId") String courseClassId);

    /**
     * 从选课表中删除记录，即退课操作
     * @param studentId
     * @param courseClassId
     */
    void deleteSelectCourse(@Param("studentId") String studentId,@Param("courseClassId") String courseClassId);

    /**
     * 教师对学生分数的录入
     * @param score
     * @param studentId
     * @param courseClassId
     */
    void updateStudentScore(@Param("score") int score,@Param("studentId") String studentId,@Param("courseClassId") String courseClassId);
}
