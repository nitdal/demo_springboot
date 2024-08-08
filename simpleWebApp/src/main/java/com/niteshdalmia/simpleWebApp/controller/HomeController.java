package com.niteshdalmia.simpleWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

//@RestController //combines controller and responsebody
@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String greet(){
        return "HELLO";
    }

    @RequestMapping("/about")
    @ResponseBody
    public String info(){
        return "I am Nitesh";
    }

}
