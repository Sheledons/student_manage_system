package cn.sheledon.mapper.student;

import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.StudentArchive;
import cn.sheledon.pojo.StudentInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 与学生相关操作的Dao
 * @author sheledon
 */
@Repository
public interface IStudentDao {
    /**
     * 根据用户Id获得学生基本信息
     * 例如学生姓名，性别，联系方式
     * @param userId
     * @return
     */
    Student getStudentByUserId(@Param("userId") String userId);

    /**
     * 根据studentId获得学生的姓名
     * @param userId
     * @return
     */
    Student getStudentNameByUserId(@Param("userId") String userId);
    /**
     * 根据学生Id获得学生的信息
     * 例如宿舍，专业，类型等
     * @param studentId
     * @return
     */
    Student getStudentInfo(@Param("studentId") String studentId);

    /**
     * 根据学生的Id获得学生档案信息
     * @param studentId
     * @return
     */
    StudentArchive getStudentArchive(@Param("studentId") String studentId);

    /**
     * 根据教师id和班级id获得学生信息
     * @param teacherId
     * @param classId
     * @param page
     * @param num
     * @return
     */
    default List<Student> getClassStudentInfoById(String teacherId,String classId,int page,int num){
        return this.getStuInfoByTeacherIdAndId(teacherId,classId,true,page,num);
    }

    /**
     * 根据教师id和教学班id获得学生的信息
     * @param teacherId
     * @param courseClassId
     * @param page
     * @param num
     * @return
     */
    default List<Student> getCourseClassStudentInfoById(String teacherId,String courseClassId,int page,int num){
        return this.getStuInfoByTeacherIdAndId(teacherId,courseClassId, false,page,num);
    }
    /**
     * 根据教师Id ,Id获得学生信息
     * @param teacherId
     * @param id
     * @param isClass 为true时id为班级id，为false时id为教学班id
     * @param page
     * @param num
     * @return
     */
    List<Student> getStuInfoByTeacherIdAndId(@Param("teacherId") String teacherId,@Param("id") String id,@Param("isClass") boolean isClass,@Param("page") int page,@Param("num") int num);


}
