package cn.sheledon.controller.course;
import cn.sheledon.pojo.CourseClass;
import cn.sheledon.pojo.StudentCourse;
import cn.sheledon.pojo.Teacher;
import cn.sheledon.service.inter.course.ICourseService;
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
@RestController
@RequestMapping("/courses")
@Slf4j
@ResponseBody
public class CourseClassController {

    ICourseService courseService;

    @Autowired
    public CourseClassController(ICourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/courseClass/{page}/{number}")
    public ResponseResult getCourseClass(HttpServletRequest request, @PathVariable("page") int page, @PathVariable("number") int number){
        if (page<0 || number<0){
            return ControllerUtils.buildResponseResult(cn.sheledon.systemGroup.ResponseStatus.PARAMETER_ERROR);
        }
        Teacher teacher=(Teacher)ControllerUtils.getObjectFromSession(request,"teacher");
        List<CourseClass> resList=courseService.getCourseClassByTeacherId(teacher.getTeacherId());
        return ControllerUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,request);
    }

    @PostMapping("/studentCourses")
    public ResponseResult addStudentCourse(HttpServletRequest request, @RequestBody List<StudentCourse> studentCourseList){
        Teacher teacher=(Teacher)ControllerUtils.getObjectFromSession(request,"teacher");
        boolean flag=courseService.updateStudentScore(studentCourseList);
        if (!flag){
            return ControllerUtils.buildResponseResult(ResponseStatus.SERVER_INTER_ERROR);
        }
        return ControllerUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,studentCourseList);
    }

}
