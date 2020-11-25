package cn.sheledon.service.inter.teaching;

import cn.sheledon.pojo.TeachingPlan;
import org.apache.ibatis.annotations.Param;

/**
 * @author sheledon
 */
public interface ITeachingService {

    /**
     * 根据学生id获得其教学计划
     * @param studentId
     * @return
     */
    TeachingPlan getTeachingPlan(@Param("studnetId") String studentId);
}
