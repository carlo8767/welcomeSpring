package com.helloSpring.thirdServiceSecurity.RepositoryObject;


import com.helloSpring.thirdServiceSecurity.EntityObject.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}