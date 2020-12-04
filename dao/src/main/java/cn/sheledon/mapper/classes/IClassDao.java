package cn.sheledon.mapper.classes;

import cn.sheledon.pojo.StudentClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sheledon
 */
@Repository
public interface IClassDao {
    /**
     * 根据教师ID获得教师管理班级
     * @param teacherId
     * @return
     */
    List<StudentClass> getStudentClassByTeacherId(@Param("teacherId") String teacherId);
}
