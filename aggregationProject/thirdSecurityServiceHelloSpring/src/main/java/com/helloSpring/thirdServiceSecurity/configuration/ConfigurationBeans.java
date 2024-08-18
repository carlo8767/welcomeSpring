package com.helloSpring.thirdServiceSecurity.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class ConfigurationBeans {



    // WHEN YOU OVERRIDE THE USER DETAILS SERVICE
    // YOU HAVE TO OVERRIDE AS  WELL THE PASSWORD ENCODER
    @Bean
    protected UserDetailsService userDetailsService (){
        DummyUser firstUser = new DummyUser("carlo", "12345", "READ");
        DummyUser secondUser = new DummyUser("pippo", "123456", "WRITE");
        List<UserDetails> users = List.of(firstUser, secondUser);
           // IF THE USER DO NOT EXIST THROW USERNAME NOT FOUND EXCEPTION
        // ONLY USE FOR DEVELOPMENT PURPOSE YOU SHOULD USE MemoryUserDetailsService
        return new InMemoryUserDetailsManager(users);
    }
    /*
    // CONNECTION FOR THE REGISTRATION OF THE USER NO NEED TO CREATE THE ENTITY
    // BUT YOU UPLOAD THE USER SISTEMATICALLY BUT YOU SHOULD CREATE A SQL FILE
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
       return new JdbcUserDetailsManager(dataSource);
    }*/


    @Deprecated
    @Bean
    protected PasswordEncoder passwordEncoder() {
        // NEVER USER NO PASSWORD ENCODER IN PROD
        // YOU SHOULD USE PBKDF2F
        return NoOpPasswordEncoder.getInstance();

    }




}
