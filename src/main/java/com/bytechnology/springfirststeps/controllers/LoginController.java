package com.bytechnology.springfirststeps.controllers;

import com.bytechnology.springfirststeps.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loadLogin(ModelMap modelMap){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String showWelcome(String name,String password, ModelMap modelMap){
        modelMap.put("name",name);
        modelMap.put("password",password);
        if(!loginService.isValid(name,password)){
            modelMap.put("errorMessage","Invalid credentials!");
            return "login";
        }
        return "welcome";
    }


}
