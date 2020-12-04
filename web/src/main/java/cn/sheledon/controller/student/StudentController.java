package cn.sheledon.controller.student;
import cn.sheledon.exception.PermissionException;
import cn.sheledon.exception.UserNotFoundException;
import cn.sheledon.pojo.*;
import cn.sheledon.service.inter.student.IStudentService;
import cn.sheledon.systemGroup.Permission;
import cn.sheledon.systemGroup.ResponseResult;
import cn.sheledon.systemGroup.ResponseStatus;
import cn.sheledon.utils.ResponseUtils;
import cn.sheledon.utils.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sheledon
 */
@RequestMapping("/student")
@ResponseBody
@RestController
@Slf4j
public class StudentController {
    /**
     *  学生的权限式最低的，只能是对基本信息的查询，选课，退课操作
     *  而对于学生信息的录入更改后面添加到管理员模块，管理员模块会涉及到很多对表数据的更新操作
     */
    private IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/name")
    public ResponseResult getName(HttpServletRequest request){
        try {
            Student student= (Student) SessionUtils.getObjectFromSession(request,"student");
            return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,student.getName());
        }catch (Exception e){
            return ResponseUtils.buildResponseResult(ResponseStatus.USERINFO_ERROR);
        }
    }


    @GetMapping("/infos")
    public ResponseResult getInfos(HttpServletRequest request){
        //后期要使用SpringSecurity对用户是否存在进行校验
        Student student=getAndCheckStudent(request);
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,studentService.getStudentInfoByStudentId(student.getStudentId()));
    }

    @GetMapping("/archives")
    public ResponseResult getArchive(HttpServletRequest request) {
        Student student = getAndCheckStudent(request);
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,studentService.getStudentArchive(student.getStudentId()));
    }

    /**
     * 根据班级Id获得学生信息
     * @param request
     * @param classId
     * @param page
     * @param number
     * @return
     */
    @GetMapping("/class/{classId}/{page}/{number}")
    public ResponseResult getClassStudents(HttpServletRequest request,
                                           @PathVariable("classId") String classId,
                                           @PathVariable("page") int page,
                                           @PathVariable("number") int number) {
        if (page<0){
            return ResponseUtils.buildResponseResult(cn.sheledon.systemGroup.ResponseStatus.PARAMETER_ERROR);
        }
        Teacher teacher = (Teacher) SessionUtils.getObjectFromSession(request, "teacher");
        List<Student> resList= studentService.getClassStudentsByTeacherId(teacher.getTeacherId(), classId, page, number);
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,resList);
    }

    /**
     * 查询教学版的学生的信息
     * @param request
     * @param courseClassId
     * @param page
     * @param number
     * @return
     */
    @GetMapping("/courseClass/{courseClassId}/{page}/{number}")
    public ResponseResult getCourseClassStudent(HttpServletRequest request,
                                                @PathVariable("courseClassId") String courseClassId,
                                                @PathVariable("page") int page,
                                                @PathVariable("number") int number){
        if (page<0 || number<0){
            return ResponseUtils.buildResponseResult(ResponseStatus.PARAMETER_ERROR);
        }
        Teacher teacher= (Teacher) SessionUtils.getObjectFromSession(request,"teacher");
        List<Student> resList=studentService.getCourseClassStudentByTeacherId(teacher.getTeacherId(),courseClassId,page,number);
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,resList);
    }


    private Student getAndCheckStudent(HttpServletRequest request){
        Student student= (Student) SessionUtils.getObjectFromSession(request,"student");
        User user=(User) SessionUtils.getObjectFromSession(request,"user");
        checkStudentIsValid(student,user);
        return student;
    }

    private void checkStudentIsValid(Student student,User user){
        if (student==null || user==null){
            throw new UserNotFoundException();
        }
        if (Permission.STUDENT.compareTo(user.getPermission())!=0){
            throw new PermissionException();
        }
    }
}
