package com.helloSpring.thirdServiceSecurity.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTextEncodersTest {

    @Test
    public void verificationEncodeTrue () {
        PasswordTextEncoders passwordTextEncoders = new PasswordTextEncoders();
        String passwordToEncode = "pippo";
        String encoding = passwordTextEncoders.encode(passwordToEncode);
        boolean verification = passwordTextEncoders.matches("pippo", encoding);
        assertTrue(verification);
    }

    @Test
    public void verificationEncodeFalse (){
        PasswordTextEncoders passwordTextEncoders = new PasswordTextEncoders();
        String passwordToEncode = "pippo";
        String encoding = passwordTextEncoders.encode(passwordToEncode);
        boolean verification = passwordTextEncoders.matches("mario", encoding);
        assertFalse(verification);
    }

}