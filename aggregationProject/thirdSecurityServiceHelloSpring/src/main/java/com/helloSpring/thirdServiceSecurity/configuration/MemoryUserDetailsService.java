package com.helloSpring.thirdServiceSecurity.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

// THIS CLASS VERIFY IF THE USER EXIST
public class MemoryUserDetailsService implements UserDetailsService {



    private final List<UserDetails> users;

    public MemoryUserDetailsService(List<UserDetails> users) {
        this.users = users;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return users.stream()
                .filter(
                        u -> u.getUsername().equals(username)
                )
                .findFirst()
      .orElseThrow(
        () -> new UsernameNotFoundException("User not found")
      );
    }

}



