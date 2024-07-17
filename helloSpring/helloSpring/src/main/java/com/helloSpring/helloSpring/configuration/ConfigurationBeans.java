package com.helloSpring.helloSpring.configuration;

import com.helloSpring.helloSpring.utility.BankOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationBeans {
    
    // Beans is advisable to use when I have an external service
    // that required to managed configuration, such as scope
    @Bean
    @Scope("singleton")
    public BankOperations bankOperations(){
        return new BankOperations();
    }
}
