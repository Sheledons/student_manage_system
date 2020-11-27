package cn.sheledon.service.inter.user;


import cn.sheledon.pojo.User;
import cn.sheledon.service.inter.IBaseService;

/**
 * @author sheledon
 */
public interface IUserService  {
    /**
     * 根据用户名和密码校验用户
     * @param user
     * @return
     */
    User getUserOneByNameAndPwd(User user);
}
