package cn.sheledon.test.teacherTest;


import cn.sheledon.config.DataBaseConfig;
import cn.sheledon.pojo.Teacher;
import cn.sheledon.pojo.TeacherArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataBaseConfig.class})
public class ITeacherDaoTest {

    @Autowired
    private cn.sheledon.mapper.teacher.ITeacherDao teacherDao;

    @Test
    public void getTeacherByUserIdTest(){
       Teacher teacher=teacherDao.getTeacherByUserId("2500002");
        System.out.println(teacher);
    }

    @Test
    public void getTeacherInfoByTeacherIdTest(){
        Teacher teacher=teacherDao.getTeacherInfoByTeacherId("1800001");
        System.out.println(teacher);
    }

    @Test
    public void getTeacherArchiveTest(){
        TeacherArchive archive=teacherDao.getTeacherArchive("1800001");
        System.out.println(archive);
    }


}
