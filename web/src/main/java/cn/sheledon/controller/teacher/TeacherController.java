package cn.sheledon.controller.teacher;

import cn.sheledon.pojo.*;
import cn.sheledon.service.inter.course.ICourseService;
import cn.sheledon.service.inter.student.IStudentService;
import cn.sheledon.service.inter.teacher.ITeacherService;
import cn.sheledon.systemGroup.ResponseResult;
import cn.sheledon.systemGroup.ResponseStatus;
import cn.sheledon.utils.ControllerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sheledon
 */
@RequestMapping("/teachers")
@Slf4j
@ResponseBody
@RestController
public class TeacherController {

    private ITeacherService teacherService;

    @Autowired
    public void setTeacherService(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacherInfos")
    public ResponseResult getTeacherInfo(HttpServletRequest request) {
        Teacher teacher = (Teacher) ControllerUtils.getObjectFromSession(request, "teacher");
        Teacher resTeacher = teacherService.getTeacherInfoByTeacherId(teacher.getTeacherId());
        return ControllerUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,resTeacher);
    }

    @GetMapping("/teacherArchives")
    public ResponseResult getTeacherArchives(HttpServletRequest request) {
        Teacher teacher = (Teacher) ControllerUtils.getObjectFromSession(request, "teacher");
        TeacherArchive archive=teacherService.getTeacherArchive(teacher.getTeacherId());
        return ControllerUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,archive);
    }

}