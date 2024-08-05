package com.helloSpring.thirdServiceSecurity.apiDescriptor;

import com.helloSpring.thirdServiceSecurity.dto.Election;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/election")
public interface ElectionApiDescriptor {

    @GetMapping("/typeElection")
    @ResponseBody
    public Election getTypeElection (@RequestParam("nameElection") String nameElection, @RequestParam ("dateElection")String dateElection);
}
