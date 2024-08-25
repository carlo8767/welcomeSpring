package com.helloSpring.thirdServiceSecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


public class CustomAuthenticationProvider implements AuthenticationProvider {



    private MemoryUserDetailsService memoryUserDetailsService;
    private PasswordTextEncoders passwordTextEncoders;

    @Autowired
    public CustomAuthenticationProvider(MemoryUserDetailsService memoryUserDetailsService, PasswordTextEncoders passwordTextEncoders){
        this.memoryUserDetailsService = memoryUserDetailsService;
        this.passwordTextEncoders = passwordTextEncoders;
    }


    // LOGIC AUTHENTICATION
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // THIS IS THE USERNAME STORE ON THE DATABASE WITH THE ENCODING PASSWORD
        // OR INSIDE THE MEMORY CASH
        UserDetails userDetails =  memoryUserDetailsService.loadUserByUsername(username);
        Optional<UserDetails> optionalUserDetails = Optional.ofNullable(userDetails);
        if(optionalUserDetails.isPresent()){
            // VERIFY THAT THE PASSWORD MATCHES
            if(passwordTextEncoders.matches(password, optionalUserDetails.get().getPassword())){
                return new UsernamePasswordAuthenticationToken(username, authentication.getCredentials(),
                        authentication.getAuthorities() );
            }
            else {
                throw new BadCredentialsException("It s a wrong workflow");
            }

        }
        else  {
            throw  new NullPointerException("object null");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
