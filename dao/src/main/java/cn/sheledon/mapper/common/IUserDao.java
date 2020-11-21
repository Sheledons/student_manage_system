package cn.sheledon.mapper.common;

import cn.sheledon.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author sheledon
 */
public interface IUserDao {
    /**
     * 根据用户名和密码检索用户
     * @param username
     * @param password
     * @return
     */
    User getUserByNameAnsPassword(@Param("username") String username,@Param("password") String password);


}
