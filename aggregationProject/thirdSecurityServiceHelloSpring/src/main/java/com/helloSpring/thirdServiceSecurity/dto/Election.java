package com.helloSpring.thirdServiceSecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Election {

    private String typeElection;
    private String localDateTime;

}
