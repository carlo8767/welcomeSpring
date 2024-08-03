package com.helloSpring.firstServiceHelloSpring.controller;

import com.helloSpring.firstServiceHelloSpring.apiDescriptor.ElectionApiDescriptor;
import com.helloSpring.firstServiceHelloSpring.dto.Election;

import java.time.LocalDateTime;

public class ControllerElection implements ElectionApiDescriptor {





    @Override
    public Election getTypeElection(String nameElection, LocalDateTime dateElection) {
        return null;
    }
}
