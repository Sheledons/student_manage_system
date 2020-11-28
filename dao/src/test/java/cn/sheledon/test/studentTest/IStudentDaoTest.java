package cn.sheledon.test.studentTest;

import cn.sheledon.config.DataBaseConfig;
import cn.sheledon.config.SpringConfig;
import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.StudentArchive;
import cn.sheledon.pojo.StudentInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Objects;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class IStudentDaoTest {

    @Autowired
    cn.sheledon.mapper.student.IStudentDao studentDao;
    private  String testStudentId="20181102928";
    @Test
    public void  getStudentByUserIdTest(){
        Student student=studentDao.getStudentByUserId("2500001");
        System.out.println(student);
    }

    @Test
    public void getStudentInfoTest(){
        Student info=studentDao.getStudentInfo(testStudentId);
        System.out.println(info);
    }

    @Test
    public void getStudentArchiveTest(){
        StudentArchive archive=studentDao.getStudentArchive(testStudentId);
        System.out.println(archive);
    }

    @Test
    public void getStuInfoByTeacherIdAndIdTestFalse(){
        List<Student> list=studentDao
                .getStuInfoByTeacherIdAndId("1800001","7000001",false,0,1);
        System.out.println(list);
    }

    @Test
    public void getStuInfoByTeacherIdAndIdTestTrue(){
        List<Student> list=studentDao
                .getStuInfoByTeacherIdAndId("1800001","4000001",true,0,1);
        System.out.println(list);
    }
    @Test
    public void getNameTest(){
        Student student=studentDao.getStudentNameByUserId("2500001");
        Objects.requireNonNull(student);
        System.out.println(student.getName());
    }

}
