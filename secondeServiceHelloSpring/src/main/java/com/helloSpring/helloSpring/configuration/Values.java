package com.helloSpring.helloSpring.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("file:C:/Users/Carlo/Desktop/Program/Spring/project_Spring/welcomeSpring/test/application.properties")
@Getter
@Setter
public class Values {


    // READ AN  EXTERNAL PROPERTY

    private String welcome;


    
    
}
