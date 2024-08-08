package com.niteshdalmia.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public String LoginPage(){
        return "LoginPage...";
    }

}
