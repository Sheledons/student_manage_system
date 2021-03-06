package cn.sheledon.controller.teaching;

import cn.sheledon.pojo.Student;
import cn.sheledon.pojo.TeachingPlan;
import cn.sheledon.service.inter.teaching.ITeachingService;
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
@RestController
@Slf4j
@ResponseBody
@RequestMapping("/teachings")
public class TeachingController {
    private ITeachingService teachingService;

    @Autowired
    public TeachingController(ITeachingService teachingService) {
        this.teachingService = teachingService;
    }

    @GetMapping("/students/teachingPlans")
    public ResponseResult getTeachingPlan(HttpServletRequest request){
        Student student= (Student) SessionUtils.getObjectFromSession(request,"student");
        TeachingPlan plan=teachingService.getTeachingPlan(student.getStudentId());
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,plan);
    }
    @GetMapping("/teachingCase/{courseClassId}")
    public ResponseResult getTeachingCase(@PathVariable("courseClassId") String courseClassId){
        return ResponseUtils.buildResponseResult(ResponseStatus.RESPONSE_OK,teachingService.getTeachingCase(courseClassId));
    }
}
