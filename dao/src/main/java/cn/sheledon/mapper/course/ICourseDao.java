package cn.sheledon.mapper.course;

import cn.sheledon.pojo.CourseClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程相关Dao
 * @author sheledon
 */
public interface ICourseDao{

    /**
     * 根据教师或者是学生ID获得相应的课程班信息
     * @param idm
     * @param isTeacher
     * @return
     */
    List<CourseClass> getCourseClass(@Param("id") String idm,@Param("isTeacher") boolean isTeacher);

    /**
     * 当前开设的所有教学班查询查询
     * @return
     */
    List<CourseClass> getCourseClass();

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



}
