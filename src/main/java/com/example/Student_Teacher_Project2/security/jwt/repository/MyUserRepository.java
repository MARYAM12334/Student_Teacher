package com.example.Student_Teacher_Project2.security.jwt.repository;


import com.example.Student_Teacher_Project2.security.jwt.domain.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, String> {
    MyUser findByUsername(String username);
}
