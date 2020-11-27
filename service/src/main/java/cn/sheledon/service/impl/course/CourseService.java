package cn.sheledon.service.impl.course;

import cn.sheledon.mapper.course.ICourseDao;
import cn.sheledon.pojo.CourseClass;
import cn.sheledon.pojo.StudentCourse;
import cn.sheledon.service.inter.course.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheledon
 */
@Service
@Slf4j
public class CourseService implements ICourseService {

    private ICourseDao courseDao;

    @Autowired
    public CourseService(ICourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<CourseClass> getCourseClassByTeacherId(String teacherId) {
        return courseDao.getCourseClassByTeacherId(teacherId);
    }

    @Override
    public List<CourseClass> getCourseClassByStudentId(String studentId) {
        return courseDao.getCourseClassByStudentId(studentId);
    }


    @Override
    public List<CourseClass> getCourseClass(int page, int num) {
        return courseDao.getCourseClass((page-1)*num,num);
    }

    @Override
    public List<CourseClass> getStudentScoreById(String studentId) {
        return courseDao.getStudentScoreByStudentId(studentId);
    }

    @Override
    public List<CourseClass> updateSelectCourse(String studentId,List<StudentCourse> studentCourseList) {
        List<String> courseClassIdList=new ArrayList<>(studentCourseList.size());
        studentCourseList.stream().forEach((sc)->{
            courseClassIdList.add(sc.getCourseClassId());
            sc.setStudentId(studentId);
            courseDao.updateSelectCourse(sc);
        });
        return courseDao.getCourseClassByStudentIdAndCourseClassId(studentId,courseClassIdList);
    }


    @Override
    public boolean deleteSelectCourse(String studentId,List<StudentCourse> courseList) {
        courseList.stream().forEach((sc)->{
            sc.setStudentId(studentId);
            courseDao.deleteSelectCourse(sc);
        });
        return true;
    }

    @Override
    public boolean updateStudentScore(List<StudentCourse> studentCourseList) {
        try {
            studentCourseList.stream().forEach((sc)->{
                courseDao.updateStudentScore(sc.getScore(),sc);
            });
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String buildInfo(Object... objects){
        StringBuilder builder=new StringBuilder();
        for (Object o:objects){
            builder.append(o);
        }
        return builder.toString();
    }
}
