package com.helloSpring.firstServiceHelloSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Election {

    private String typeElection;
    private LocalDateTime localDateTime;
    
}
