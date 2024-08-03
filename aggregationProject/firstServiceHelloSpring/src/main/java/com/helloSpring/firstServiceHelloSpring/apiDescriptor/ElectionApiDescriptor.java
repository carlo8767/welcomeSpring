package com.helloSpring.firstServiceHelloSpring.apiDescriptor;

import com.helloSpring.firstServiceHelloSpring.dto.Election;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/election")
public interface ElectionApiDescriptor {

    @GetMapping("/typeElection")
    @ResponseBody
    public Election getTypeElection (@RequestParam("nameElection") String nameElection, @RequestParam ("dateElection")String dateElection);
}
