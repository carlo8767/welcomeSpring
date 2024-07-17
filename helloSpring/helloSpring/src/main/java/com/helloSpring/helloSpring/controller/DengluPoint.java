package com.helloSpring.helloSpring.controller;

import com.helloSpring.helloSpring.utility.BankOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/denglu")
public class DengluPoint {


    private BankOperations bankOperations;


    public DengluPoint(BankOperations bankOperations) {
        this.bankOperations = bankOperations;
    }


    @GetMapping("/point")
    // @ResponseBody annotation tells a controller
    // that the object returned is automatically
    // serialized into JSON and passed back into the HttpResponse object.
    @ResponseBody
    public String[] dengluPoint(){
        bankOperations.registration();
        return new String[]{"test","ok"};
    }
}
