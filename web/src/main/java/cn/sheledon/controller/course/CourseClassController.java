package cn.sheledon.controller.course;
import cn.sheledon.pojo.CourseClass;
import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.StudentCourse;
import cn.sheledon.pojo.Teacher;
import cn.sheledon.service.inter.course.ICourseService;
import cn.sheledon.systemGroup.ResponseResult;
import cn.sheledon.systemGroup.ResponseStatus;
import cn.sheledon.utils.ResponseUtils;
import cn.sheledon.utils.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @GetMapping("/teacher/courseClass/{page}/{number}")
    public ResponseResult getCourseClass(HttpServletRequest request, @PathVariable("page") int page, @PathVariable("number") int number){
        if (page<0 || number<0){
            return ResponseUtils.buildResponseResult(cn.sheledon.systemGroup.ResponseStatus.PARAMETER_ERROR);
        }
        Teacher teacher=(Teacher) SessionUtils.getObjectFromSession(request,"teacher");
        List<CourseClass> resList=courseService.getCourseClassByTeacherId(teacher.getTeacherId());
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,resList);
    }
    @GetMapping("/studentCourse")
    public ResponseResult getStudentCourse(HttpServletRequest request){
        Student student= (Student) SessionUtils.getObjectFromSession(request,"student");
        List<CourseClass> ccs=courseService.getCourseClassByStudentId(student.getStudentId());
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,ccs);
    }
    @PutMapping("/studentCourses/scores")
    public ResponseResult updateStudentCourseScores(HttpServletRequest request, @RequestBody List<StudentCourse> studentCourseList){
        Teacher teacher=(Teacher) SessionUtils.getObjectFromSession(request,"teacher");
        boolean flag=courseService.updateStudentScore(studentCourseList);
        if (!flag){
            return ResponseUtils.buildResponseResult(ResponseStatus.SERVER_INTER_ERROR);
        }
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,studentCourseList);
    }
    @GetMapping("/courseClass/{page}/{num}")
    public ResponseResult getCourseClass(@PathVariable("page") int page,@PathVariable("num") int num){
        if (page<0 || num<0){
            return ResponseUtils.buildResponseResult(ResponseStatus.PARAMETER_ERROR);
        }
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,courseService.getCourseClass(page,num));
    }
    @GetMapping("/courseClass/options")
    public ResponseResult getCourseClassOptions(HttpServletRequest request){
        Student student= (Student) SessionUtils.getObjectFromSession(request,"student");
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,courseService.getStudentCanSelectCourse(student.getStudentId()));
    }

    @GetMapping("/student/studentCourse/scores")
    public ResponseResult getStudentCourseScores(HttpServletRequest request){
        Student student= (Student) SessionUtils.getObjectFromSession(request,"student");
        List<CourseClass> list=courseService.getStudentScoreById(student.getStudentId());
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,list);
    }
    @PostMapping("/studentCourses")
    public ResponseResult addStudentCourses(HttpServletRequest request,@RequestBody List<StudentCourse> studentCourseList){
        studentCourseList.stream().forEach((c)->{
            System.out.println(c);
            c.setScore(null);
        });
        Student student= (Student) SessionUtils.getObjectFromSession(request,"student");
        List<CourseClass> courseClasses=courseService.updateSelectCourse(student.getStudentId(),studentCourseList);
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,courseClasses);
    }
    @DeleteMapping("/studentCourses")
    public ResponseResult deleteStudentCourses(HttpServletRequest request,@RequestBody List<StudentCourse> courseList){
        Student student= (Student) SessionUtils.getObjectFromSession(request,"student");
        if (courseService.deleteSelectCourse(student.getStudentId(),courseList)){
            return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,new ArrayList<>());
        }
        return ResponseUtils.buildResponseResult(ResponseStatus.SERVER_INTER_ERROR);
    }
}
