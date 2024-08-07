package com.helloSpring.thirdServiceSecurity.controller;

import com.helloSpring.thirdServiceSecurity.apiDescriptor.LoginHello;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerLoginHello implements LoginHello {


    @Override
    public String getHelloLogin() {
        return "hello!";
    }
}
