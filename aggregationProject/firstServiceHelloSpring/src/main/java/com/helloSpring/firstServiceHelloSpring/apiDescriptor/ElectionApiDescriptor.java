package com.helloSpring.firstServiceHelloSpring.apiDescriptor;

import com.helloSpring.firstServiceHelloSpring.dto.Election;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

public interface ElectionApiDescriptor {



    @GetMapping
    @ResponseBody
    public Election getTypeElection (@RequestParam("nameElection") String nameElection, @RequestParam ("dateElection")LocalDateTime dateElection);
}
