package cn.sheledon.test.classTest;

import cn.sheledon.config.SpringConfig;
import cn.sheledon.mapper.classes.IClassDao;
import cn.sheledon.pojo.StudentClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class IClassDaoTest {


    @Autowired
    private IClassDao classDao;

    @Test
    public void getStudentClassTest(){
        List<StudentClass> list=classDao.getStudentClassByTeacherId("1800001");
        list.stream().forEach(t->{
            System.out.println(t);
        });
    }
}
