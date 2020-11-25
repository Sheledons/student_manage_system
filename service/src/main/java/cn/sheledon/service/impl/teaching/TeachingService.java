package cn.sheledon.service.impl.teaching;

import cn.sheledon.mapper.teaching.ITeachingDao;
import cn.sheledon.pojo.TeachingPlan;
import cn.sheledon.service.inter.teaching.ITeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sheledon
 */
@Service
public class TeachingService implements ITeachingService {
    private ITeachingDao teachingDao;

    @Autowired
    public TeachingService(ITeachingDao teachingDao) {
        this.teachingDao = teachingDao;
    }
    @Override
    public TeachingPlan getTeachingPlan(String studentId) {
        return teachingDao.getTeachingPlan(studentId);
    }
}
