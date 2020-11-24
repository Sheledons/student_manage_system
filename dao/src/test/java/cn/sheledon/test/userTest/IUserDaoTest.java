package cn.sheledon.test.userTest;

import cn.sheledon.config.DataBaseConfig;
import cn.sheledon.mapper.user.IUserDao;
import cn.sheledon.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataBaseConfig.class})
public class IUserDaoTest {
    @Autowired
    private IUserDao userDao;

    @Test
    public void getUserByNameAnsPasswordTest(){
        User user=User.builder()
                .name("张三")
                .pwd("1983449241")
                .build();
        System.out.println(userDao.getUserByNameAnsPassword(user));
    }

}
