package cn.sheledon.service.impl.user;

import cn.sheledon.mapper.user.IUserDao;
import cn.sheledon.pojo.User;
import cn.sheledon.service.inter.user.IUserService;
import cn.sheledon.systemGroup.Permission;
import cn.sheledon.utils.LoggerUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


/**
 * @author sheledon
 */
@Service
@PropertySource("classpath:permission.properties")
public class UserService implements IUserService {
    @Value("student")
    private  static String PERMISSION_STUDENT;
    @Value("teacher")
    private static String PERMISSION_TEACHER;
    @Value("manager")
    private static String PERMISSION_MANAGER;

    @Autowired
    private IUserDao userDao;
    private Logger logger= LoggerUtils.getLogger(UserService.class);

    @Override
    public User getUserOneByNameAndPwd(User user){
        user=userDao.getUserByNameAnsPassword(user);
        if (user==null || !setPermission(user)){
            logger.error("User为空");
            throw new NullPointerException();
        }
        return user;
    }
    private boolean setPermission(User user) {
        if (user.getStrPermission()==null){
            return false;
        }
        if (PERMISSION_MANAGER.equals(user.getStrPermission())){
            user.setPermission(Permission.MANAGER);
        }
        if (PERMISSION_STUDENT.equals(user.getStrPermission())){
            user.setPermission(Permission.STUDENT);
        }
        if (PERMISSION_TEACHER.equals(user.getStrPermission())){
            user.setPermission(Permission.TEACHER);
        }
        return true;
    }
}
