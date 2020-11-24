package cn.sheledon.controller;

import cn.sheledon.utils.LoggerUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sheledon
 */
@RequestMapping("/user")
@Controller
@ResponseBody
public class UserController {

    private static Logger logger= LoggerUtils.getLogger(UserController.class);
    @RequestMapping("/test")
    public String test(){
        logger.info("log test");
        return "Hello World";
    }

}
