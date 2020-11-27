package cn.sheledon.controller.user;
import cn.sheledon.exception.PermissionException;
import cn.sheledon.exception.UserNotFoundException;
import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.Teacher;
import cn.sheledon.pojo.User;
import cn.sheledon.service.inter.IBaseService;
import cn.sheledon.service.inter.student.IStudentService;
import cn.sheledon.service.inter.teacher.ITeacherService;
import cn.sheledon.service.inter.user.IUserService;
import cn.sheledon.systemGroup.Permission;
import cn.sheledon.systemGroup.ResponseResult;
import cn.sheledon.systemGroup.ResponseStatus;
import cn.sheledon.utils.ControllerUtils;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;


/**
 * @author sheledon
 */
@RequestMapping("/user")
@ResponseBody
@RestController
@Slf4j
public class UserController {

    private IUserService userService;
    private IStudentService studentService;
    private ITeacherService teacherService;
    private HashMap<Permission, IBaseService> roleMap;

    {
        roleMap=new HashMap<>();
    }
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
        roleMap.put(Permission.STUDENT,studentService);
    }
    @Autowired
    public void setTeacherService(ITeacherService teacherService) {
        this.teacherService = teacherService;
        roleMap.put(Permission.TEACHER,teacherService);
    }

    @PostMapping("/login")
    public ResponseResult toLogin(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User resUser=userService.getUserOneByNameAndPwd(user);
        Permission permission=checkIdentify(resUser,request);
        if (permission==null){
            throw new PermissionException();
        }
        switch (permission){
            case STUDENT:{
                response.sendRedirect("/studentIndex.html");
                break;
            }
            case TEACHER:{
                response.sendRedirect("/teacherIndex.html");
                break;
            }
        }
        return ResponseResult.builder()
                .status(ResponseStatus.USERINFO_ERROR)
                .build();
    }
    private Permission checkIdentify(User user,HttpServletRequest request){
        for (Permission p:Permission.values()){
            if (p.compareTo(user.getPermission())==0){
                IBaseService baseService=roleMap.get(p);
                Object object=baseService.getRoleByUserId(user.getUserId());
                if (object==null){
                    throw new UserNotFoundException();
                }
                ControllerUtils.setAttributeToSession(request,p.name(),object);
                return p;
            }
        }
        return null;
    }
}
