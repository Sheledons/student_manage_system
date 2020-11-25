package cn.sheledon.service.impl.student;
import cn.sheledon.mapper.student.IStudentDao;
import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.StudentArchive;
import cn.sheledon.pojo.StudentInfo;
import cn.sheledon.service.inter.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author sheledon
 */
@Service
public class StudentService implements IStudentService {
    private IStudentDao studentDao;

    @Autowired
    public StudentService(IStudentDao studentDao) {
        assert studentDao!=null;
        this.studentDao = studentDao;
    }

    @Override
    public Student getStudentByUserId(String userId) {
        return studentDao.getStudentByUserId(userId);
    }

    @Override
    public Student getStudentName(String userId) {
        return studentDao.getStudentNameByUserId(userId);
    }

    @Override
    public StudentInfo getStudentInfoByStudentId(String studentId) {
        return studentDao.getStudentInfo(studentId);
    }

    @Override
    public StudentArchive getStudentArchive(String studentId) {
        return studentDao.getStudentArchive(studentId);
    }

    @Override
    public List<Student> getClassStudentsByTeacherId(String teacherId, String classId,int page,int num) {
        return studentDao.getClassStudentInfoById(teacherId,classId,(page-1)*num,num);
    }

    @Override
    public List<Student> getCourseClassStudentByTeacherId(String teacherId, String courseClassId,int page,int num) {
        return studentDao.getCourseClassStudentInfoById(teacherId,courseClassId,(page-1)*num,num);
    }
}
