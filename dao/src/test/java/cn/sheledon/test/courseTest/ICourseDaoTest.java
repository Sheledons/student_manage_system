package cn.sheledon.test.courseTest;

import cn.sheledon.config.DataBaseConfig;
import cn.sheledon.mapper.course.ICourseDao;
import cn.sheledon.pojo.CourseClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataBaseConfig.class})
public class ICourseDaoTest {

    @Autowired
    private ICourseDao courseDao;

    @Test
    public void getCourseClassByTeacherIdTest(){
        List<CourseClass> list=courseDao.getCourseClassByTeacherId("1800001");
        System.out.println(list);
    }

    @Test
    public void getCourseClassByStudentIdTest(){
        List<CourseClass> list=courseDao.getCourseClassByStudentId("20181102928");
        System.out.println(list);
    }
    @Test
    public void getCourseClassTest(){
        List<CourseClass> list=courseDao.getCourseClass(0,10);
        System.out.println(list);
    }
    @Test
    public void createSelectCourseTest(){
        courseDao.createSelectCourse("20181102928","7000002");
        getCourseClassByStudentIdTest();
    }
    @Test
    public void deleteSelectCourseTest(){
        courseDao.deleteSelectCourse("20181102928","7000002");
        getCourseClassByStudentIdTest();
    }
    @Test
    public void updateStudentScoreTest(){
        courseDao.updateStudentScore(200,"20181102928","7000002");
    }

    @Test
    public void getCourseClassScoreByStudentIdTest(){
        List<CourseClass> list=courseDao.getCourseClassScoreByStudentId("20181102928");
        for (CourseClass courseClass:list){
            System.out.println(courseClass);
        }
    }
}
