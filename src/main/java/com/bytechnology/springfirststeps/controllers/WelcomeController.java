package com.bytechnology.springfirststeps.controllers;

import com.bytechnology.springfirststeps.security.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @Autowired
    LoginService loginService;

    @GetMapping(value = "/")
    public String showLogin(ModelMap model){
        model.put("name", loginService.getLoggedInUserName());
        return "welcome";
    }
}
