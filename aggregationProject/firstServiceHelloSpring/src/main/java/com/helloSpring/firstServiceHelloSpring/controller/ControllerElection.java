package com.helloSpring.firstServiceHelloSpring.controller;

import com.helloSpring.firstServiceHelloSpring.apiDescriptor.ElectionApiDescriptor;
import com.helloSpring.firstServiceHelloSpring.dto.Election;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
public class ControllerElection implements ElectionApiDescriptor {

    @Override
    public Election getTypeElection(String nameElection, String dateElection) {
        // VERIFICATION THAT THE DATA HAS THE CORRECT FORMAT
        // YOU SPECIFY WITH THE DATA FORMATTER THE TYPE OF PATTERN
        boolean verification = false;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(dateElection, dateTimeFormatter);
            verification = true;
        } catch (DateTimeParseException e) {
            System.out.println(e);
        }
        if (verification) {
            return new Election(nameElection, dateElection);
        }
        else {
           return  null;
        }
    }
}
