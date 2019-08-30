package com.bytechnology.springfirststeps.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean isValid(String username,String password){
        return username.equalsIgnoreCase("dorin") && password.equals("password");
    }
}
