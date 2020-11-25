package cn.sheledon.service.impl.course;

import cn.sheledon.mapper.course.ICourseDao;
import cn.sheledon.pojo.CourseClass;
import cn.sheledon.exception.UpdateException;
import cn.sheledon.service.inter.course.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return courseDao.getCourseClass(page,num);
    }

    @Override
    public List<CourseClass> getStudentScoreById(String studentId) {
        return courseDao.getStudentScoreByStudentId(studentId);
    }

    @Override
    public CourseClass updateSelectCourse(String studentId, String courseClassId) {
        courseDao.updateSelectCourse(studentId,courseClassId);
        CourseClass courseClass=courseDao.getCourseClassByStudentIdAndCourseClassId(studentId,courseClassId);
        if (courseClass==null){
            String info=buildInfo("更新选课失败 ，学生id: ",studentId,"  课程id: ",courseClassId);
            log.info(info);
            throw new UpdateException(info);
        }
        return courseClass;
    }

    @Override
    public void deleteSelectCourse(String studentId, String courseClassId) {
        courseDao.deleteSelectCourse(studentId,courseClassId);
        CourseClass courseClass=courseDao.getCourseClassByStudentIdAndCourseClassId(studentId,courseClassId);
        if (courseClass!=null){
            String info=buildInfo("删除选课失败，学生id: ",studentId,"  课程id: ",courseClassId);
            log.info(info);
            throw new UpdateException(info);
        }
    }

    @Override
    public CourseClass updateStudentScore(int score, String studentId, String courseClassId) {
        courseDao.updateStudentScore(score,studentId,courseClassId);
        CourseClass courseClass=courseDao.getStudentScoreByStuIdAndCourseClassId(studentId,courseClassId);
        if (courseClass==null || courseClass.getScore()!=score){
            String info=buildInfo("更新分数失败，学生id: "+studentId,"  课程id  ",courseClassId);
            log.info(info);
            throw new UpdateException(info);
        }
        return courseClass;
    }

    private String buildInfo(Object... objects){
        StringBuilder builder=new StringBuilder();
        for (Object o:objects){
            builder.append(o);
        }
        return builder.toString();
    }
}
