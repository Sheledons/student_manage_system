package cn.sheledon.test;

import cn.sheledon.config.DataBaseConfig;
import cn.sheledon.mapper.student.IStudentDao;
import cn.sheledon.mapper.user.IUserDao;
import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataBaseConfig.class})
public class Main {
    @Autowired
    IStudentDao studentDao;
    @Autowired
    IUserDao userDao;

    @Test
    public void IStudentDaoTest(){
        Student student=studentDao.getStudentByUserId("2500001");
        System.out.println(student);
    }
    @Test
    public void IUserDaoTest() throws Exception {
        User user=userDao.getUserByNameAnsPassword("1","2");
        System.out.println(user);
    }
}
