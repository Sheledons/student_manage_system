package cn.sheledon.controller.user;
import cn.sheledon.exception.PermissionException;
import cn.sheledon.exception.UserNotFoundException;
import cn.sheledon.pojo.User;
import cn.sheledon.service.inter.IBaseService;
import cn.sheledon.service.inter.student.IStudentService;
import cn.sheledon.service.inter.teacher.ITeacherService;
import cn.sheledon.service.inter.user.IUserService;
import cn.sheledon.systemGroup.Permission;
import cn.sheledon.systemGroup.ResponseResult;
import cn.sheledon.systemGroup.ResponseStatus;
import cn.sheledon.utils.ResponseUtils;
import cn.sheledon.utils.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    public ResponseResult toLogin(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        User resUser=userService.getUserOneByNameAndPwd(user);
        Permission permission=checkIdentify(resUser,request);
        String redirectURL;
        switch (permission){
            case STUDENT:{
                redirectURL="/studentIndex.html";
                break;
            }
            case TEACHER:{
                redirectURL="/teacherIndex.html";
                break;
            } default:{
                return ResponseUtils.buildResponseResult(ResponseStatus.USERINFO_ERROR);
            }
        }
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,redirectURL);
    }

    @GetMapping("/exit")
    public void toExit(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
    }
    private Permission checkIdentify(User user,HttpServletRequest request){
        for (Permission p:Permission.values()){
            if (p.compareTo(user.getPermission())==0){
                IBaseService baseService=roleMap.get(p);
                Object object=baseService.getRoleByUserId(user.getUserId());
                if (object==null){
                    return null;
                }
                SessionUtils.setAttributeToSession(request,p.getName(),object);
                SessionUtils.setAttributeToSession(request,"user",user);
                return p;
            }
        }
        return null;
    }
    @ExceptionHandler({PermissionException.class,UserNotFoundException.class,NullPointerException.class})
    public ResponseResult dealLoginException(){
        return ResponseUtils.buildResponseResult(ResponseStatus.USERINFO_ERROR);
    }
}
