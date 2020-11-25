package cn.sheledon.controller;
import cn.sheledon.pojo.User;
import cn.sheledon.service.inter.user.IUserService;
import cn.sheledon.systemGroup.Permission;
import cn.sheledon.systemGroup.ResponseResult;
import cn.sheledon.systemGroup.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author sheledon
 */
@RequestMapping("/user")
@ResponseBody
@RestController
@Slf4j
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseResult toLogin(@RequestBody User user, HttpServletResponse response) throws IOException {
        User resUser=userService.getUserOneByNameAndPwd(user);
        Permission userPermission=resUser.getPermission();
        if (Permission.STUDENT.compareTo(userPermission)==0){
            response.sendRedirect("/studentIndex.html");
        }
        if (Permission.TEACHER.compareTo(userPermission)==0){
            response.sendRedirect("/teacherIndex.html");
        }
        return ResponseResult.builder()
                .status(ResponseStatus.USERINFO_ERROR)
                .data(user)
                .build();
    }
    private String buildLogInfo(Object... objects){
        StringBuilder builder=new StringBuilder();
        for (Object o: objects){
            builder.append(o);
        }
        return builder.toString();
    }
}
