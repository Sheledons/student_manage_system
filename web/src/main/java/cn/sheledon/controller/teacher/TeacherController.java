package cn.sheledon.controller.teacher;

import cn.sheledon.pojo.*;
import cn.sheledon.service.inter.teacher.ITeacherService;
import cn.sheledon.systemGroup.ResponseResult;
import cn.sheledon.systemGroup.ResponseStatus;
import cn.sheledon.utils.ResponseUtils;
import cn.sheledon.utils.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/name")
    public ResponseResult getName(HttpServletRequest request){
        try {
            Teacher teacher= (Teacher) SessionUtils.getObjectFromSession(request,"teacher");
            return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,teacher.getName());
        }catch (Exception e){
            return ResponseUtils.buildResponseResult(ResponseStatus.USERINFO_ERROR);
        }
    }

    @GetMapping("/teacherInfos")
    public ResponseResult getTeacherInfo(HttpServletRequest request) {
        Teacher teacher = (Teacher) SessionUtils.getObjectFromSession(request, "teacher");
        Teacher resTeacher = teacherService.getTeacherInfoByTeacherId(teacher.getTeacherId());
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,resTeacher);
    }

    @GetMapping("/teacherArchives")
    public ResponseResult getTeacherArchives(HttpServletRequest request) {
        Teacher teacher = (Teacher) SessionUtils.getObjectFromSession(request, "teacher");
        TeacherArchive archive=teacherService.getTeacherArchive(teacher.getTeacherId());
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,archive);
    }

}