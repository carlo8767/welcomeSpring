package com.helloSpring.thirdServiceSecurity.configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;


// USER DETAILS SERVICE ALLOW ME TO CUSTOMIZE THE USER DETAILS
// YOU COULD IMPLEMENT AS WELL FOR AN ENTITY AS WELL
// THIS IS AN IMMUTABLE CLASS
public class DummyUser implements UserDetails {


    private final String username;
    private final String password;
    private final String authority;

    public DummyUser(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of  (()->authority);
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
