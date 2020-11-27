package cn.sheledon.service.inter.teacher;

import cn.sheledon.pojo.Teacher;
import cn.sheledon.pojo.TeacherArchive;
import cn.sheledon.service.inter.IBaseService;

/**
 * @author sheledon
 */
public interface ITeacherService extends IBaseService {
    /**
     * 根据用户id获得教师信息
     * @param userId
     * @return
     */
    Teacher getTeacherByUserId(String userId);

    /**
     * 根据教师id获得其姓名
     * @param userId
     * @return
     */
    Teacher getTeacherNameByUserId(String userId);

    /**
     * 根据教师id获得教师的信息
     * @param teacherId
     * @return
     */
    Teacher getTeacherInfoByTeacherId(String teacherId);

    /**
     * 根据教师id获得教师的档案信息
     * @param teacherId
     * @return
     */
    TeacherArchive getTeacherArchive(String teacherId);
}
