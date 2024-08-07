package com.helloSpring.thirdServiceSecurity.apiDescriptor;



import org.springframework.web.bind.annotation.*;


@RequestMapping("/login")
public interface LoginHello {

    @GetMapping("/hello")
    @ResponseBody
    String getHelloLogin ();
}
