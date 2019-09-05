package com.bytechnology.springfirststeps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping(value = "/")
    public String showLogin(ModelMap model){
        model.put("name", "Dorin");
        return "welcome";
    }
}
