package com.helloSpring.thirdServiceSecurity.ServiceRepository;

import com.helloSpring.thirdServiceSecurity.EntityObject.UserEntity;
import com.helloSpring.thirdServiceSecurity.RepositoryObject.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;



@Service
public class UserServiceRepository {


    UserRepository userRepository;

    @Autowired
    public UserServiceRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

     public void addUser(UserDetails dummyUser){
         userRepository.save(new UserEntity(0,dummyUser.getUsername(), dummyUser.getPassword(), dummyUser.getAuthorities().toString()));
     }

}
