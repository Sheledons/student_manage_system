package cn.sheledon.service.inter.classes;

import cn.sheledon.pojo.StudentClass;

import java.util.List;

/**
 * @author sheledon
 */
public interface IClassService {
    /**
     * 根据教师Id获得教师管理班
     * @param teacherId
     * @return
     */
    List<StudentClass> getTeacherManageClass(String teacherId);
}
