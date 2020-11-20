package cn.sheledon.mapper.user;

import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.StudentArchive;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author sheledon
 */
@Repository
public interface IUserBaseDao {

    /**
     * 根据用户名和密码验证
     * @param username
     * @param pwd
     * @return
     */
    Student getStudent(@Param("username") String username, @Param("pwd") String pwd);

    /**
     * 根据id获得用户基本信息
     * @param studentId
     * @return
     */
    Student getStudentInfo(@Param("studentId") String studentId);

    /**
     * 根据id获得用户档案信息
     * @param studentId
     * @return
     */
    StudentArchive getStudentArchive(@Param("studentId") String studentId);



}
