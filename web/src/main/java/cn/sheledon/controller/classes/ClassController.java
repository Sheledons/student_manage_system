package cn.sheledon.controller.classes;

import cn.sheledon.pojo.StudentClass;
import cn.sheledon.pojo.Teacher;
import cn.sheledon.service.inter.classes.IClassService;
import cn.sheledon.systemGroup.ResponseResult;
import cn.sheledon.systemGroup.ResponseStatus;
import cn.sheledon.utils.ResponseUtils;
import cn.sheledon.utils.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sheledon
 */
@RestController
@RequestMapping("/class")
@Slf4j
@ResponseBody
public class ClassController {

    private IClassService classService;

    @Autowired
    public ClassController(IClassService classService) {
        this.classService = classService;
    }

@GetMapping("/teachers")
    public ResponseResult getTeacherChargeClass(HttpServletRequest request){
        Teacher teacher= (Teacher) SessionUtils.getObjectFromSession(request,"teacher");
        List<StudentClass> studentClasses=classService.getTeacherManageClass(teacher.getTeacherId());
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,studentClasses);
    }
}
