package cn.sheledon.service.impl.classes;

import cn.sheledon.mapper.classes.IClassDao;
import cn.sheledon.pojo.StudentClass;
import cn.sheledon.service.inter.classes.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author sheledon
 */
@Service
public class ClassService implements IClassService {

    private IClassDao classDao;

    @Autowired
    public ClassService(IClassDao classDao) {
        this.classDao = classDao;
    }

    @Override
    public List<StudentClass> getTeacherManageClass(String teacherId) {
        Objects.requireNonNull(teacherId);
        return classDao.getStudentClassByTeacherId(teacherId);
    }
}
