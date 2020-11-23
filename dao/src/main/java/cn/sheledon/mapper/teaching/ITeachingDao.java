package cn.sheledon.mapper.teaching;

import cn.sheledon.pojo.TeachingPlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 教学相关Dao
 * @author sheledon
 */
@Repository
public interface ITeachingDao {
    /**
     * 根据学生id查询教学计划
     * @param studentId
     * @return
     */
    TeachingPlan getTeachingPlan(@Param("studentId") String studentId);


}
