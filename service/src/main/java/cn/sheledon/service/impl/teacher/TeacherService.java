package cn.sheledon.service.impl.teacher;

import cn.sheledon.mapper.teacher.ITeacherDao;
import cn.sheledon.pojo.Teacher;
import cn.sheledon.pojo.TeacherArchive;
import cn.sheledon.service.inter.teacher.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sheledon
 */
@Service
public class TeacherService implements ITeacherService{

    private ITeacherDao teacherDao;

    @Autowired
    public TeacherService(ITeacherDao teacherDao) {
        assert teacherDao!=null;
        this.teacherDao = teacherDao;
    }

    @Override
    public Teacher getTeacherByUserId(String userId) {
        return teacherDao.getTeacherByUserId(userId);
    }

    @Override
    public Teacher getTeacherNameByUserId(String userId) {
        return teacherDao.getTeacherNameByUserId(userId);
    }

    @Override
    public Teacher getTeacherInfoByTeacherId(String teacherId) {
        return teacherDao.getTeacherInfoByTeacherId(teacherId);
    }

    @Override
    public TeacherArchive getTeacherArchive(String teacherId) {
        return teacherDao.getTeacherArchive(teacherId);
    }
}
