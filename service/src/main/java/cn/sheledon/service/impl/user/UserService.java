package cn.sheledon.service.impl.user;

import cn.sheledon.mapper.user.IUserDao;
import cn.sheledon.pojo.User;
import cn.sheledon.exception.UserNotFoundException;
import cn.sheledon.exception.PermissionException;
import cn.sheledon.service.inter.user.IUserService;
import cn.sheledon.systemGroup.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author sheledon
 */
@Service
public class UserService implements IUserService {
    private  static String PERMISSION_STUDENT;
    private  static String PERMISSION_TEACHER;
    private  static String PERMISSION_MANAGER;

    static {
        Properties properties=new Properties();
        try(InputStream in=UserService.class.getClassLoader().getResourceAsStream("permission.properties");
        ) {
            properties.load(in);
            PERMISSION_TEACHER=properties.getProperty("teacher");
            PERMISSION_STUDENT=properties.getProperty("student");
            PERMISSION_MANAGER=properties.getProperty("manager");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private IUserDao userDao;

    @Autowired
    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserOneByNameAndPwd(User user){
        User resUser=userDao.getUserByNameAnsPassword(user);
        if (user==null){
            throw new UserNotFoundException();
        }
        if (!setPermission(resUser)){
            throw new PermissionException();
        }
        return resUser;
    }
    private boolean setPermission(User user) {
        if (user.getStrPermission()==null){
            return false;
        }
        boolean flag=false;
        if (PERMISSION_MANAGER.equals(user.getStrPermission())){
            flag=true;
            user.setPermission(Permission.MANAGER);
        }
        if (PERMISSION_STUDENT.equals(user.getStrPermission())){
            flag=true;
            user.setPermission(Permission.STUDENT);
        }
        if (PERMISSION_TEACHER.equals(user.getStrPermission())){
            flag=true;
            user.setPermission(Permission.TEACHER);
        }
        return flag;
    }
}
