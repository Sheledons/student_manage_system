package cn.sheledon.controller.student;
import cn.sheledon.exception.PermissionException;
import cn.sheledon.exception.UserNotFoundException;
import cn.sheledon.pojo.*;
import cn.sheledon.service.inter.student.IStudentService;
import cn.sheledon.systemGroup.Permission;
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

    @GetMapping("/infos")
    public StudentInfo getInfos(HttpServletRequest request){
        //后期要使用SpringSecurity对用户是否存在进行校验
        Student student=getAndCheckStudent(request);
        return studentService.getStudentInfoByStudentId(student.getStudentId());
    }

    @GetMapping("/archives")
    public StudentArchive getArchive(HttpServletRequest request) {
        Student student = getAndCheckStudent(request);
        return studentService.getStudentArchive(student.getStudentId());
    }

    @GetMapping("/{classId}/students/{page}/{number}")
    public ResponseResult getClassStudents(HttpServletRequest request,
                                           @PathVariable("classId") String classId,
                                           @PathVariable("page") int page,
                                           @PathVariable("number") int number) {
        if (page<0){
            return ControllerUtils.buildResponseResult(cn.sheledon.systemGroup.ResponseStatus.PARAMETER_ERROR);
        }
        Teacher teacher = (Teacher) ControllerUtils.getObjectFromSession(request, "teacher");
        List<Student> resList= studentService.getClassStudentsByTeacherId(teacher.getTeacherId(), classId, page, number);
        return ControllerUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,resList);
    }

    /**
     * 查询教学版的学生的信息
     * @param request
     * @param courseClassId
     * @param page
     * @param number
     * @return
     */
    @GetMapping("/{courseClassId}/{page}/{number}")
    public ResponseResult getCourseClassStudent(HttpServletRequest request,
                                                @PathVariable("courseClassId") String courseClassId,
                                                @PathVariable("page") int page,
                                                @PathVariable("number") int number){
        if (page<0 || number<0){
            return ControllerUtils.buildResponseResult(ResponseStatus.PARAMETER_ERROR);
        }
        Teacher teacher= (Teacher) ControllerUtils.getObjectFromSession(request,"teacher");
        List<Student> resList=studentService.getCourseClassStudentByTeacherId(teacher.getTeacherId(),courseClassId,page,number);
        return ControllerUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,resList);
    }


    private Student getAndCheckStudent(HttpServletRequest request){
        Student student= (Student) ControllerUtils.getObjectFromSession(request,"student");
        User user=(User) ControllerUtils.getObjectFromSession(request,"user");
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
