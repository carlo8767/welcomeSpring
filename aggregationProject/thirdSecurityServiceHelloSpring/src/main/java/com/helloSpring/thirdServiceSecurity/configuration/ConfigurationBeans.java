package com.helloSpring.thirdServiceSecurity.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ConfigurationBeans {


    // WHEN YOU OVERRIDE THE USER DETAILS SERVICE
    // YOU HAVE TO OVERRIDE AS  WELL THE PASSWORD ENCODER
    @Bean
    protected UserDetailsService userDetailsService (){
        var user = User.withUsername("carlo")
                 .password("12345")
                 .authorities("read")
                 .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Deprecated
    @Bean
    public PasswordEncoder passwordEncoder() {
        // NEVER USER NO PASSWORD ENCODER IN PROD
        return NoOpPasswordEncoder.getInstance();
    }

}
