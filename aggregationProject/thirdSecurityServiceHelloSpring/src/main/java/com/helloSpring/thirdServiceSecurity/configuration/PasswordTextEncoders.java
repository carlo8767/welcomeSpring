package com.helloSpring.thirdServiceSecurity.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

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


    public String applyBcryptPasswordEncoder(CharSequence rawPassword) throws NoSuchAlgorithmException {
        SecureRandom s = SecureRandom.getInstanceStrong();
        PasswordEncoder p = new BCryptPasswordEncoder(4, s);
        return p.encode(rawPassword);
    }

    public void encryption (){
        // KEY GENERATION FOR HASHING
        String salt = KeyGenerators.string().generateKey();
        String password = "secret";
        String valueToEncrypt = "HELLO";

        BytesEncryptor e = Encryptors.standard(password, salt);
        // GIVE THE BYTE
        byte [] encrypted = e.encrypt(valueToEncrypt.getBytes());
        byte [] decrypted = e.decrypt(encrypted);
    }


}
