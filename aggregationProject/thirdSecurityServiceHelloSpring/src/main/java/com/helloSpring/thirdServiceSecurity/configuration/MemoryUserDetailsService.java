package com.helloSpring.thirdServiceSecurity.configuration;

import com.helloSpring.thirdServiceSecurity.ServiceRepository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.List;

// THIS CLASS VERIFY IF THE USER EXIST
public class MemoryUserDetailsService implements UserDetailsManager {





    // INJECT REPOSITORY
    @Autowired
    UserServiceRepository userServiceRepository;


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

    @Override
    public void createUser(UserDetails user) {
        userServiceRepository.addUser(user);
    }

    @Override
    public void updateUser(UserDetails user) {
    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }
}



