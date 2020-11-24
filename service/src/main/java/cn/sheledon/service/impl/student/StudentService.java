package cn.sheledon.service.impl.student;
import cn.sheledon.mapper.student.IStudentDao;
import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.User;
import cn.sheledon.service.inter.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author sheledon
 */
@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentDao studentDao;
    @Override
    public Student getStudentByUserId(User user) {
        
        return null;
    }

    @Override
    public Student getStudentName(User user) {
        return null;
    }

    @Override
    public Student getStudentInfoByStudentId(String studentId) {
        return null;
    }

    @Override
    public Student getStudentArchive(String studentId) {
        return null;
    }

    @Override
    public List<Student> getClassStudentsByTeacherId(String teacherId, String classId) {
        return null;
    }

    @Override
    public List<Student> getCourseClassStudentByTeacherId(String teacherId, String courseClassId) {
        return null;
    }
}
