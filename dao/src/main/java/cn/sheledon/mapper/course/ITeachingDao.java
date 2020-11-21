package cn.sheledon.mapper.course;

import cn.sheledon.pojo.TeachingPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 教学相关Dao
 * @author sheledon
 */
public interface ITeachingDao {
    /**
     * 根据学生I查询教学计划
     * @param studentId
     * @return
     */
    TeachingPlan getTeachingPlan(@Param("studentId") String studentId);

    /**
     * 根据学生类别（一本，二本）和学生专业获得教学计划
     * @param studentTypeId
     * @param majorId
     * @return
     */
    List<TeachingPlan> getTeachingPlan(@Param("studentTypeId") String studentTypeId,@Param("majorId") String majorId);


}
