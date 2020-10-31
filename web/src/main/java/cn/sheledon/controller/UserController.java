package cn.sheledon.controller;

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

    @RequestMapping("/test")
    public String test(){
        return "Hello World";
    }
}
