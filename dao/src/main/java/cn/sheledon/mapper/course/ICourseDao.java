package cn.sheledon.mapper.course;

import cn.sheledon.pojo.CourseClass;
import cn.sheledon.pojo.StudentCourse;
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
     * 根据教师id获得教师所任职的教学班信息
     * @param teacherId
     * @return
     */
    default List<CourseClass> getCourseClassByTeacherId(String teacherId){
        return this.getCourseClassById(teacherId,true);
    }


    /**
     * 根据学生id和课程id获得课程信息
     * @param studentId
     * @param courseClassIdList
     * @return
     */
    List<CourseClass> getCourseClassByStudentIdAndCourseClassId(@Param("studentId") String studentId,@Param("courseClassIdList") List<String> courseClassIdList);
    /**
     * 根据学生id获得它所在的教学班的信息
     * @param studentId
     * @return
     */
    default List<CourseClass> getCourseClassByStudentId(String studentId){
        return this.getCourseClassById(studentId,false);
    }

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
     * 根据学生id获得其分数
     * @param studentId
     * @return
     */
    List<CourseClass> getStudentScoreByStudentId(@Param("studentId") String studentId);


    /**
     * 根据学生id和课程班id获得学生分数*******
     * @param studentId
     * @param courseClassId
     * @return
     */
    CourseClass getStudentScoreByStuIdAndCourseClassId(@Param("studentId") String studentId,@Param("courseClassId") String courseClassId);

    /**
     * 在学生选课关联表中插入数据，即选课
     * @param studentCourse
     */
    void addSelectCourse(@Param("studentCourse")StudentCourse studentCourse);

    /**
     * 从选课表中删除记录，即退课操作
     * @param studentCourse
     */
    void deleteSelectCourse(@Param("studentCourse")StudentCourse studentCourse);

    /**
     * 教师对学生分数的录入
     * @param score
     * @param studentCourse
     */
    void updateStudentScore(@Param("score") int score,@Param("studentCourse") StudentCourse studentCourse);


}
