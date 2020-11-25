package cn.sheledon.test.teachingTest;


import cn.sheledon.config.DataBaseConfig;
import cn.sheledon.config.SpringConfig;
import cn.sheledon.mapper.teaching.ITeachingDao;
import cn.sheledon.pojo.TeachingPlan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class ITeachingDaoTest {
    @Autowired
    ITeachingDao teachingDao;

    @Test
    public void getTeachingPlanTest(){
        TeachingPlan plan=teachingDao.getTeachingPlan("20181102928");
        System.out.println(plan);
    }
}
