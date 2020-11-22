package cn.sheledon.mapper.user;

import cn.sheledon.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author sheledon
 */
@Repository
public interface IUserDao {
    /**
     * 根据用户名和密码检索用户
     * @param username
     * @param password
     * @return
     */
    User getUserByNameAnsPassword(@Param("username") String username,@Param("password") String password);

}
