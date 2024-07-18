package com.helloSpring.firstServiceHelloSpring.controller;

import com.helloSpring.firstServiceHelloSpring.dto.UserLogin;
import com.helloSpring.firstServiceHelloSpring.utility.BankOperations;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<UserLogin> dengluPoint(@RequestParam("username") String username) {
        UserLogin login = new UserLogin() ;
        List<UserLogin> listReturn = new ArrayList<>();
        Optional<String> optionalValue = Optional.ofNullable(username);
        if (optionalValue.isPresent()) {
            if(!optionalValue.get().isEmpty()){
                login.setUsername(optionalValue.get());
                listReturn.add(login);
            }
            else{
                throw  new NullPointerException();
            }
        }
        else{
            throw  new NullPointerException();
        }
        return listReturn;
    }
}












