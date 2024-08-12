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
        return new InMemoryUserDetailsManager(users);
    }

    @Deprecated
    @Bean
    public PasswordEncoder passwordEncoder() {
        // NEVER USER NO PASSWORD ENCODER IN PROD
        return NoOpPasswordEncoder.getInstance();
    }

}
