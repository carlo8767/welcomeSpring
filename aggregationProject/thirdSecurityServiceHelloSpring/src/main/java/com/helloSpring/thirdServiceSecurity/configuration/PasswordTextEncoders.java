package com.helloSpring.thirdServiceSecurity.configuration;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.security.NoSuchAlgorithmException;

public class PasswordTextEncoders implements PasswordEncoder {



    private static final String SECRET = "secret";
    private static final int SALT_LENGTH = 100;
    private static final int ITERATION = 100;

/*
    private String hashWithSHA512(String input) {
        StringBuilder result = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte [] digested = md.digest(input.getBytes());
                for (int i = 0; i < digested.length; i++) {
                    result.append(Integer.toHexString(0xFF & digested[i]));
                }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Bad algorithm");
        }
        return result.toString();
    }*/


    public String uniqueEncoding (  PasswordEncoder p, CharSequence input) throws NoSuchAlgorithmException {
        try{
            return  p.encode(input);
        }
        catch (Exception e){
            throw  new NoSuchAlgorithmException("Bad algorithm");
        }

    }

    @Override
    public String encode(CharSequence rawPassword) {
        PasswordEncoder p =
                new Pbkdf2PasswordEncoder(SECRET, SALT_LENGTH,
                        ITERATION, Pbkdf2PasswordEncoder. SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
        return  p.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        PasswordEncoder p =
                new Pbkdf2PasswordEncoder(SECRET, SALT_LENGTH,
                        ITERATION, Pbkdf2PasswordEncoder. SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
        return p.matches(rawPassword, encodedPassword);

    }


}
