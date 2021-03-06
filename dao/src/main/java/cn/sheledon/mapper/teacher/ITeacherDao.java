package cn.sheledon.mapper.teacher;

import cn.sheledon.pojo.Teacher;
import cn.sheledon.pojo.TeacherArchive;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author sheledon
 */
@Repository
public interface ITeacherDao{

    /**
     * 根据userId获得教师基本信息
     * @param userId
     * @return
     */
    Teacher getTeacherByUserId(@Param("userId") String userId);

    /**
     * 根据用户id获得教师的名字
     * @param userId
     * @return
     */
    Teacher getTeacherNameByUserId(@Param("userId") String userId);

    /**
     * 根据教师id获得教师基本信息
     * @param teacherId
     * @return
     */
    Teacher getTeacherInfoByTeacherId(@Param("teacherId") String teacherId);
    /**
     * 根据教师的Id获得教师档案信息
     * @param teacherId
     * @return
     */
    TeacherArchive getTeacherArchive(@Param("teacherId") String teacherId);


}
